package com.sombreurs.demo2.repo;

import com.sombreurs.demo2.model.Points;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointsRepo extends JpaRepository<Points, Long> {



}
