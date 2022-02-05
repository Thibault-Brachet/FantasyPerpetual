package com.sombreurs.demo2.repo;

import com.sombreurs.demo2.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player, Long> {

    List<Player> findByLeagueId(Long leagueId);

    List<Player> findByLeagueIdAndAccountId(Long leagueId, Long accountId);

    List<Player> findByLeagueIdAndDraftRank(Long leagueId, Integer draftRank);

    long countByLeagueId(Long leagueId);

}
