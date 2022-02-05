package com.sombreurs.demo2.repo;

import com.sombreurs.demo2.model.Pick;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PickRepo extends JpaRepository<Pick, Long> {

    List<Pick> findByCompetitionId(Long comnpetitionId);

    List<Pick> findByCompetitionIdAndPlayerId(Long comnpetitionId, Long playerId);

}
