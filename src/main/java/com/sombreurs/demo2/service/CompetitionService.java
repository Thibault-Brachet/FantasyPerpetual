package com.sombreurs.demo2.service;

import com.sombreurs.demo2.exception.UserNotFoundException;
import com.sombreurs.demo2.model.Competition;
import com.sombreurs.demo2.repo.CompetitionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompetitionService {

    private final CompetitionRepo competitionRepo;


    @Autowired
    public CompetitionService(CompetitionRepo competitionRepo) {
        this.competitionRepo = competitionRepo;
    }

    public Competition addLCompetition(Competition competition){
        return competitionRepo.save(competition);
    }

    public List<Competition> findAll(){
        return competitionRepo.findAll();
    }

    public Competition findCompetitionById(Long id){
        return competitionRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Competition with id "+id+" was not found"));
    }

    public List<Competition> findCompetitionByLeagueId(Long leagueId){
        return competitionRepo.findByLeagueId(leagueId);
    }

    public Competition updateCompetition(Competition competition){
        return competitionRepo.save(competition);
    }

    public void deleteCompetition(Long id){
        competitionRepo.deleteById(id);
    }

}
