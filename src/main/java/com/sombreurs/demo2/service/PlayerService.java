package com.sombreurs.demo2.service;

import com.sombreurs.demo2.exception.UserNotFoundException;
import com.sombreurs.demo2.model.Player;
import com.sombreurs.demo2.repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayerService {

    private final PlayerRepo playerRepo;

    @Autowired
    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public Player addPlayer(Player player){
        return playerRepo.save(player);
    }

    public List<Player> findAll(){
        return playerRepo.findAll();
    }

    public Player findPlayerById(Long id){
        return playerRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Player with id "+id+" was not found"));
    }

    public List<Player> findPlayerByLeagueId(Long leagueId){
        return playerRepo.findByLeagueId(leagueId);
    }

    public Player findPlayerByLeagueIdAndAccountId(Long leagueId, Long accountId){
        List<Player> listPlayer = playerRepo.findByLeagueIdAndAccountId(leagueId, accountId);
        if (listPlayer != null && listPlayer.size() > 0) {
            return listPlayer.get(0);
        }
        return null;
    }

    public Player updatePlayer(Player player){
        return playerRepo.save(player);
    }

    public void deletePlayer(Long id){
        playerRepo.deleteById(id);
    }

    public long countByPlayerByLeagueId(Long leagueId){
        return playerRepo.countByLeagueId(leagueId);
    }

    public Player findNextPlayer(Player currentPlayer) {
        Player nextPlayer = null;
        long playerNumber =0;
        if (currentPlayer!=null && currentPlayer.getLeague()!=null) {
            // count of players
            playerNumber = countByPlayerByLeagueId(currentPlayer.getLeague().getId());

            if (currentPlayer.getDraftRank().longValue() == playerNumber) {
                // if current player is the last one in draft order then we start from the beginning again and next player is the frist palyer who drafted
                nextPlayer = playerRepo.findByLeagueIdAndDraftRank(currentPlayer.getLeague().getId(), 1).get(0);
            } else {
                // otherwise next player is the one with draftRank = currentPlayer/draftRank +1
                nextPlayer = playerRepo.findByLeagueIdAndDraftRank(currentPlayer.getLeague().getId(), currentPlayer.getDraftRank()+1).get(0);
            }
        }




        return nextPlayer;
    }
}
