package com.sombreurs.demo2.service;

import com.sombreurs.demo2.exception.UserNotFoundException;
import com.sombreurs.demo2.model.Competition;
import com.sombreurs.demo2.model.League;
import com.sombreurs.demo2.model.Pick;
import com.sombreurs.demo2.model.Player;
import com.sombreurs.demo2.repo.PickRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PickService {

    private final PickRepo pickRepo;

    private final PlayerService playerService;

    private final CompetitionService competitionService;

    private final LeagueService leagueService;


    @Autowired
    public PickService(PickRepo PickRepo, PlayerService playerService, CompetitionService competitionService, LeagueService leagueService) {
        this.pickRepo = PickRepo;
        this.playerService = playerService;
        this.competitionService = competitionService;
        this.leagueService = leagueService;
    }

    public Pick addPick(Pick pick){

        // Pick is created
        Pick createdPick = pickRepo.save(pick);

        // competitom current pick is updated
        Competition competition = createdPick.getCompetition();
        Integer currentCompetitionPick = competition.getCompetitionCurrentPick();
        if (currentCompetitionPick == null || currentCompetitionPick.intValue() == 0) {
            competition.setCompetitionCurrentPick(1);
        } else{
            competition.setCompetitionCurrentPick(currentCompetitionPick+1);
        }
        competitionService.updateCompetition(competition);

        //league current pick is updated
        League league = competition.getLeague();
        Integer currentLeaguePick = league.getLeagueCurrentPick();
        if (currentLeaguePick == null || currentLeaguePick.intValue() == 0) {
            league.setLeagueCurrentPick(1);
        } else{
            league.setLeagueCurrentPick(currentCompetitionPick+1);
        }
        leagueService.updateLeague(league);

        //Next player picking is updated
        if (createdPick != null && createdPick.getPlayer() != null) {
            Player currentPlayer = createdPick.getPlayer();

            //setting current player as inactive
            currentPlayer.setActive(false);
            //increasing current pick
            Integer currentPlayerPick = currentPlayer.getPlayerCurrentPick();
            if (currentPlayerPick == null || currentPlayerPick.intValue() == 0) {
                currentPlayer.setPlayerCurrentPick(1);
            } else{
                currentPlayer.setPlayerCurrentPick(currentPlayerPick+1);
            }
            currentPlayer = playerService.updatePlayer(currentPlayer);


            // Looking for next player based on leagueId and draftRank of current player
            Player nextPlayer = playerService.findNextPlayer(currentPlayer);

            if (nextPlayer != null) {

                playerService.updatePlayer(nextPlayer);

                //setting next player as active
                nextPlayer.setActive(true);
                playerService.updatePlayer(nextPlayer);
            }

            //updating pick number of pick object
            createdPick.setCompetitionPickNumber(competition.getCompetitionCurrentPick());
            createdPick.setLeaguePickNumber(league.getLeagueCurrentPick());
            createdPick.setPlayerPickNumber(currentPlayer.getPlayerCurrentPick());
            pickRepo.save(createdPick);
        }

        return createdPick;
    }

    public List<Pick> findAll(){
        return pickRepo.findAll();
    }

    public Pick findPickById(Long id){
        return pickRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Pick with id "+id+" was not found"));
    }

    public List<Pick> findPickByCompetitionId(Long competitionId){
        return pickRepo.findByCompetitionId(competitionId);
    }

    public List<Pick> findPickByCompetitionIdAndPlayerId(Long competitionId, long playerId){
        return pickRepo.findByCompetitionIdAndPlayerId(competitionId, playerId);
    }

    public Pick updatePick(Pick Pick){
        return pickRepo.save(Pick);
    }

    public void deletePick(Long id){
        pickRepo.deleteById(id);
    }

}
