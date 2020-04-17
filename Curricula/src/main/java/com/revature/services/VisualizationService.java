package com.revature.services;

import java.util.List;

import com.revature.models.Visualization;

/**
 * The interface Visualization service.
 */
public interface VisualizationService {

	/**
	 * Gets visualization by id.
	 *
	 * @param id the id
	 * @return the visualization by id
	 */
	public Visualization getVisualizationById(int id);

	/**
	 * Gets all visualizations.
	 *
	 * @return the all visualizations
	 */
	public List<Visualization> getAllVisualizations();

	/**
	 * Update visualization visualization.
	 *
	 * @param v the v
	 * @return the visualization
	 */
	public Visualization updateVisualization(Visualization v);

	/**
	 * Create visualization visualization.
	 *
	 * @param v the v
	 * @return the visualization
	 */
	public Visualization createVisualization(Visualization v);

	/**
	 * Delete visualization by id visualization.
	 *
	 * @param id the id
	 * @return the visualization
	 */
	public Visualization deleteVisualizationById (int id);
}
