package it.racinghub.be.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.racinghub.be.entity.IscrizioneEvento;
import it.racinghub.be.entity.Risultato;
import it.racinghub.be.entity.Sessione;
import it.racinghub.be.repository.IscrizioneEventoRepository;
import it.racinghub.be.repository.RisultatoRepository;
import it.racinghub.be.repository.SessioneRepository;
import it.racinghub.be.service.RisultatoService;
import it.racinghub.be.util.RHCostants;

@Service
public class RisultatoServiceImpl  implements RisultatoService{

    @Autowired
    private SessioneRepository sessioneRepository;
    @Autowired
    private IscrizioneEventoRepository iscrevenRepository;
    @Autowired
    private RisultatoRepository risultatoRepository;
    

	@Override
	public boolean verifyFile(MultipartFile file, String fileName) {
        try {
            // Verifica se il file è vuoto
            if (file.isEmpty() || fileName.isEmpty()) {
                return false;
            }
            
            Workbook workbook=getWorkbookFromFile(file, fileName);
            
            // Ottieni il primo foglio di lavoro (worksheet) dal workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Verifica la presenza delle colonne desiderate
            return validateFile(sheet);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	 private Workbook getWorkbookFromFile(MultipartFile file, String fileName) throws IOException {
         Workbook workbook= new XSSFWorkbook();
		 
		 if(fileName.endsWith(".csv")) {
         	// Convert MultipartFile to Reader
         	InputStreamReader reader = new InputStreamReader(file.getInputStream(),StandardCharsets.UTF_8);
             
             try (// Create CSVParser
				CSVParser csvParser = CSVParser.parse(reader, CSVFormat.DEFAULT.builder().setDelimiter(';').build())) {
				
            	// Creazione di un nuovo foglio di lavoro XLS
        	 	workbook = new XSSFWorkbook();
				Sheet sheet = workbook.createSheet("Sheet1");

				// Popolamento del foglio di lavoro con i dati del parser CSV
				int rowNum = 0;
				for (CSVRecord record : csvParser) {
				    Row row = sheet.createRow(rowNum++);
				    int cellNum = 0;
				    for (String value : record) {
				        Cell cell = row.createCell(cellNum++);
				        cell.setCellValue(value);
				    }
				}
			}
         }
         
         // Carica il file XLS/XLSX in un workbook
         else if(fileName.endsWith(".xls") || fileName.endsWith(".xlsx")){
	            try (InputStream inputStream = file.getInputStream()) {
	                workbook = WorkbookFactory.create(inputStream);
	            }
         }
		 
		 return workbook;
	 }
	
    // Verifica la presenza delle colonne attese nel foglio di lavoro
    private boolean validateFile(Sheet sheet) {

    	if(!validateHeader(sheet)) {
    		return false;
    	}
        
    	if(!validateTable(sheet)) {
    		return false;
    	}
        
        return true;
    }
    
    private boolean validateHeader(Sheet sheet) {
    	 Row headerRow = sheet.getRow(0);
         if (headerRow == null) {
             return false;
         }

         int lastCellNum = headerRow.getLastCellNum();
         int firstCellNum = headerRow.getFirstCellNum();

         for (int i = 0; i < RHCostants.expectedColumnsFile.length; i++) {
             String expectedColumn = RHCostants.expectedColumnsFile[i];
             
             boolean isOK = false;
             for (int j = firstCellNum; j < lastCellNum; j++) {
 	            Cell cell = headerRow.getCell(j);
 	            if (cell != null && cell.getStringCellValue().trim().equalsIgnoreCase(expectedColumn)) {
 	                isOK=true;
 	                break;
 	            }
             }
             
             if(!isOK)
             	return false;
         }
         
         return true;
    }
    
    private boolean validateTable(Sheet sheet) {
        boolean isValid = true;

        // Controllo righe
        for (int i = sheet.getFirstRowNum()+1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null && !validateRow(row)) {
                return false;
            }
        }

        return isValid;
    }

    private boolean validateRow(Row row) {
        boolean isValid = true;

        // Controllo celle
        for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
            Cell cell = row.getCell(j);
            if (row != null && !validateCell(cell)) {
                return false;
            }
        }

        return isValid;
    }

    private boolean validateCell(Cell cell) {
    	int indexColumn = cell.getColumnIndex();
    	Cell cellHeader = cell.getSheet().getRow(0).getCell(indexColumn);
    	
    	String valueCell= new DataFormatter().formatCellValue(cell);
    	
    	try {
    	switch(cellHeader.getStringCellValue().toUpperCase()) {
            case RHCostants.POSIZIONE:
                return RHCostants.domainExtendedPosizione.contains(valueCell) ||
                		Integer.parseInt(valueCell) > 0;
            case RHCostants.KART:
                return !valueCell.isEmpty();
            case RHCostants.MIGLIOR_GIRO:
                return !valueCell.isEmpty() && Objects.nonNull(convertTime(valueCell));
            case RHCostants.DURATA_TOT:
                return !valueCell.isEmpty() && Objects.nonNull(convertTime(valueCell));
            case RHCostants.N_GIRI:
                return Integer.parseInt(valueCell) >= 0;
            case RHCostants.DISTACCO_DA_POSIZIONE:
                return !valueCell.isEmpty() && Objects.nonNull(convertTime(valueCell));
            case RHCostants.DISTACCO_DA_PRIMO:
                return !valueCell.isEmpty() && Objects.nonNull(convertTime(valueCell));
            default:
                return true;
        }
    	}catch(Exception e) {
    		return false;
    	}
    }

	@Override
	public List<Risultato> getListRisultatoFromFile(MultipartFile file, String fileName, int idSessione) {
		
		List<Risultato> res = new ArrayList<Risultato>();
		
		
        Workbook workbook = null;
		try {
			workbook = getWorkbookFromFile(file, fileName);
	        Sheet sheet = workbook.getSheetAt(0);

	        //righe
	        for (int i = sheet.getFirstRowNum()+1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);

	            Risultato risElement = new Risultato();
                Sessione sess = sessioneRepository.findByIdSessione(idSessione);
                risElement.setSessione(sess);
                
	            //celle
	            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
	                Cell cell = row.getCell(j);
	                
	               
                    
	                int indexColumn = cell.getColumnIndex();
	            	Cell cellHeader = cell.getSheet().getRow(0).getCell(indexColumn);
	            	
	            	String valueCell= new DataFormatter().formatCellValue(cell);
	            	
	            	try {
		            	switch(cellHeader.getStringCellValue().toUpperCase()) {
		                    case RHCostants.POSIZIONE:
		                    	 risElement.setPosizione(valueCell);
		                    	 break;
		                    	
		                    case RHCostants.KART:
		                         IscrizioneEvento ie = iscrevenRepository.findByTargaVeicoloAndEvento(valueCell, sess.getEvento());
		                         risElement.setIscrizioneEvento(ie);
		                         break;
		                         
		                    case RHCostants.MIGLIOR_GIRO:
		                    	 risElement.setBestLap(convertTime(valueCell));
		                    	 break;
		                    	 
		                    case RHCostants.DURATA_TOT:
		                    	 risElement.setTotalTime(convertTime(valueCell));
		                    	 break;
		                    	 
		                    case RHCostants.N_GIRI:
		                    	risElement.setnLap(Integer.parseInt(valueCell));
		                    	break;
		                    	
		                    case RHCostants.DISTACCO_DA_POSIZIONE:
		                    	risElement.setGapToPosition(convertTime(valueCell));
		                    	break;
		                    	
		                    case RHCostants.DISTACCO_DA_PRIMO:
		                    	risElement.setGapToLeader(convertTime(valueCell));
		                    	break;
		                    	
		                    default:
		                         break;
		                }
	            	}catch(Exception e) {
	        			e.printStackTrace();
	            	}
	            }
            	res.add(risElement);
	        }
		}
        catch (IOException e) {
			e.printStackTrace();
			return null;	
		}
		return res;
	}


	private Timestamp convertTime(String timeString) {
        
        String day= "0", hour= "0", minute= "0", second= "0", millisecond = "0";
        
        // Proviamo a parsare la stringa con i diversi formati
        try {
        	if(timeString.toUpperCase().contains("Lap".toUpperCase())){
        		//setta di default tempo 0 per i doppiati
        	}else {
	            String[] parts = timeString.split(":");
	            if (parts.length == 3) {
	                // Formato HH:mm:ss.SSS
	                hour = parts[0];
	                minute = parts[1];
	                String[] secondsAndMilliseconds = parts[2].split("\\.");
	                second = secondsAndMilliseconds[0];
	                millisecond = secondsAndMilliseconds[1];
	            } else if (parts.length == 2) {
	                // Formato mm:ss.SSS
	            	 minute = parts[0];
	                 String[] secondsAndMilliseconds = parts[1].split("\\.");
	                 second = secondsAndMilliseconds[0];
	                 millisecond = secondsAndMilliseconds[1];
	            } else if (parts.length == 1) {
	                // Formato ss.SSS
	            	String[] secondsAndMilliseconds = parts[0].split("\\.");
	                second = secondsAndMilliseconds[0];
	                millisecond = secondsAndMilliseconds[1];
	            } else {
	                // Formato non riconosciuto
	                return null;
	            }
        	}       
//		    "PnDTnHnMn.nS"
	        Duration duration= Duration.parse("P"+day+"D"+"T"+hour+"H"+minute+"M"+second+"."+millisecond+"S");
	        
            // Otteniamo la rappresentazione degli orari della durata
            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;
            long seconds = duration.getSeconds() % 60;
            long milliseconds = duration.toMillis() % 1000;
            
            LocalTime localTime = LocalTime.of((int) hours, (int) minutes, (int) seconds, (int) milliseconds * 1_000_000); // Esempio di LocalTime
            
            // Imposta una data di riferimento (ad esempio, 1 gennaio 1970)
            LocalDate referenceDate = LocalDate.of(1970, 1, 1);
            
            // Combina la data di riferimento con l'orario LocalTime per ottenere un LocalDateTime
            LocalDateTime localDateTime = LocalDateTime.of(referenceDate, localTime);
            
            // Converti LocalDateTime in Timestamp
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
            
//	        return LocalTime.of((int) hours, (int) minutes, (int) seconds, (int) milliseconds * 1_000_000);
	        return timestamp;
//          return duration;
        } catch (Exception e) {
        	return null;
        }
    }

	@Override
	public void cancellaRisultatiBySessione(int idSessione) {
        Sessione sess = sessioneRepository.findByIdSessione(idSessione);
        risultatoRepository.deleteBySessione(sess);
	}

	@Override
	public void importaRisultato(List<Risultato> listRisultato, int idSessione) {
		risultatoRepository.saveAll(listRisultato);
		
		risultatoRepository.assegnaPuntiBonus(idSessione);
	}
	
}