package com.revature.services;

import java.util.List;

import com.revature.models.Visualization;

/*
 * interfaced used by the serviceImpl
 */

public interface VisualizationService {

	public Visualization getVisualizationById(int id);
	public List<Visualization> getAllVisualizations();
	public Visualization updateVisualization(Visualization v);
	public Visualization createVisualization(Visualization v);
	public Visualization deleteVisualizationById (int id);
}
