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
	 * @param id of visualization
	 * @return the visualization by id
	 */
	public Visualization getVisualizationById(int id);

	/**
	 * Gets all visualizations.
	 *@param none
	 * @return the all visualizations
	 */
	public List<Visualization> getAllVisualizations();

	/**
	 * Update visualization visualization.
	 *
	 * @param v the Visualization to update
	 * @return the updated visualization
	 */
	public Visualization updateVisualization(Visualization v);

	/**
	 * Create visualization visualization.
	 *
	 * @param v the Visualization to create
	 * @return the new visualization
	 */
	public Visualization createVisualization(Visualization v);

	/**
	 * Delete visualization by id.
	 *
	 * @param id the id of the Visualization to delete
	 * @return a default visualization
	 */
	public Visualization deleteVisualizationById (int id);
}
