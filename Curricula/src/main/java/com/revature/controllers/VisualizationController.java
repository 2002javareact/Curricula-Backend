package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Visualization;
import com.revature.services.VisualizationService;

/**
 * The type Visualization controller.
 */
@RestController
@RequestMapping("visualization")
public class VisualizationController {

	private VisualizationService vs;

	/**
	 * Instantiates a new Visualization controller.
	 *
	 * @param vs the vs
	 */
	@Autowired
	public VisualizationController(VisualizationService vs) {
		super();
		this.vs = vs;
	}

	/**
	 * Gets all visualizations.
	 *
	 * @return the all visualizations
	 */
	@GetMapping
	public ResponseEntity getAllVisualizations() {
		return new ResponseEntity<List<Visualization>>(vs.getAllVisualizations(), HttpStatus.OK);
	}

	/**
	 * Gets visualization by id.
	 *
	 * @param id the id
	 * @return the visualization by id
	 */
	@GetMapping("{id}")
	public ResponseEntity getVisualizationById(@PathVariable int id) {
		if (id == 0) {
			return new ResponseEntity<>("Id must not be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Visualization>(vs.getVisualizationById(id), HttpStatus.OK);
	}

	/**
	 * Update visualization response entity.
	 *
	 * @param visualization the visualization
	 * @return the response entity
	 */
	@PatchMapping
	public ResponseEntity updateVisualization(@RequestBody Visualization visualization) {
		return new ResponseEntity<Visualization>(vs.updateVisualization(visualization), HttpStatus.OK);
	}

	/**
	 * Create visualization response entity.
	 *
	 * @param visualization the visualization
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity createVisualization(@RequestBody Visualization visualization) {
		return new ResponseEntity<Visualization>(vs.createVisualization(visualization), HttpStatus.OK);
	}

	/**
	 * Delete visualization by id response entity.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("{id}")
	public ResponseEntity deleteVisualizationById (@PathVariable int id) {
		if(id == 0 ) {
			return new ResponseEntity<>("Id must not be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Visualization>(vs.deleteVisualizationById(id), HttpStatus.OK);
	}
}
