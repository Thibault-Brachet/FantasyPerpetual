package com.sombreurs.demo2.service;

import com.sombreurs.demo2.exception.UserNotFoundException;
import com.sombreurs.demo2.model.League;
import com.sombreurs.demo2.repo.LeagueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LeagueService {

    private final LeagueRepo leagueRepo;


    @Autowired
    public LeagueService(LeagueRepo leagueRepo) {
        this.leagueRepo = leagueRepo;
    }

    public League addLeague(League player){
        return leagueRepo.save(player);
    }

    public List<League> findAll(){
        return leagueRepo.findAll();
    }

    public League findLeagueById(Long id){
        return leagueRepo.findById(id).orElseThrow(()-> new UserNotFoundException("League with id "+id+" was not found"));
    }

    public League findLeagueByCode(String code){
        List<League> list = leagueRepo.findByLeagueCode(code);
        if (list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public void joinLeague(Long accountId, Long leagueId){
        leagueRepo.joinLeague(accountId, leagueId);
    }

    public List<League> findLeagueByName(String name){
        return leagueRepo.findByLeagueName(name);
    }

    public List<League> findLeagueByAccountId(Long accountId){
        return leagueRepo.findByAccountId(accountId);
    }

    public League updateLeague(League league){
        return leagueRepo.save(league);
    }

    public void deleteLeague(Long id){
        leagueRepo.deleteById(id);
    }

}
