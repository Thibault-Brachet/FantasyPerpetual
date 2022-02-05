package com.sombreurs.demo2.repo;

import com.sombreurs.demo2.model.Competition;
import com.sombreurs.demo2.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitionRepo extends JpaRepository<Competition, Long> {

    List<Competition> findByLeagueId(Long leagueId);



}
