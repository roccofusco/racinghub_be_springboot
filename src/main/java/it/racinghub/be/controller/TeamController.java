package it.racinghub.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.racinghub.be.entity.Team;
import it.racinghub.be.service.TeamService;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

   
    @PostMapping("/save-update/teams")
    public ResponseEntity<Team> saveOrUpdateTeam(@RequestBody Team team) {
        return new ResponseEntity<Team>(teamService.saveOrUpdate(team),HttpStatus.OK);
    }
    
}
