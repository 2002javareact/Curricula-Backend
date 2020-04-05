package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Visualization;

@Repository
public interface VisualizationDao extends JpaRepository<Visualization,Integer> {

}
