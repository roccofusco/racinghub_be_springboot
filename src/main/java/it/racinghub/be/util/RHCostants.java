package it.racinghub.be.util;

import java.util.Arrays;
import java.util.List;

public class RHCostants {

	public static final String POSIZIONE = "POSITION";
	public static final String KART = "KART";
	public static final String MIGLIOR_GIRO = "BEST LAP";
	public static final String DURATA_TOT = "TOTAL TIME";
	public static final String N_GIRI = "N. LAP";

	public static final String DISTACCO_DA_POSIZIONE = "GAP TO POSITION";
	public static final String DISTACCO_DA_PRIMO = "GAP TO LEADER";

	
	public static final String[] expectedColumnsFile = new String[] {POSIZIONE, KART, MIGLIOR_GIRO, DURATA_TOT, N_GIRI};

	public static final List<String> domainExtendedPosizione = Arrays.asList(new String[]{"DNF", "DNS", "DSQ"});

}
	