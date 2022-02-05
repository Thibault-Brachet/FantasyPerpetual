package com.sombreurs.demo2.repo;

import com.sombreurs.demo2.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeagueRepo extends JpaRepository<League, Long> {

    List<League> findByLeagueCode(String leagueCode);

    List<League> findByLeagueName(String leagueName);

    @Query(value = "SELECT league.* FROM league INNER JOIN account_league ON league.league_id = account_league.league_id WHERE account_league.account_id = ?1", nativeQuery = true)
    List<League> findByAccountId(Long accountId);

    @Query(value = "INSERT INTO account_league (account_id, league_id) VALUES (?1, ?2)", nativeQuery = true)
    void joinLeague(Long acountId, Long league_id);

}
