package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.VisualizationDao;
import com.revature.models.Visualization;

/*
 * Implementations for the service of Visualization request
 */

@Service
public class VisualizationServiceImpl implements VisualizationService {

	VisualizationDao vd;

	@Autowired
	public VisualizationServiceImpl(VisualizationDao vd) {
		this.vd = vd;
	}

	//Get one Visualization
	@Override
	public Visualization getVisualizationById(int id) {
		return vd.getOne(id);
	}

	//Get all Visualizations
	@Override
	public List<Visualization> getAllVisualizations() {
		return vd.findAll();
	}

	/*Update a Visualization. Checks for empty sting and if the array of curriculums are different
	* If they array is the same size it checks the elements in the array, if they have a different id values they are overwritten
	*/
	@Override
	@Transactional
	public Visualization updateVisualization(Visualization v) {
		Visualization oldVisualization = vd.getOne(v.getVisualizationId());
		
		if (!v.getVisualizationName().equals("")) {
			oldVisualization.setVisualizationName(v.getVisualizationName());
		}		
		if (oldVisualization.getCurriculum().size() > v.getCurriculum().size()
				|| oldVisualization.getCurriculum().size() < v.getCurriculum().size()) {
			oldVisualization.setCurriculum(v.getCurriculum());
		} else {
			for (int i = 0; i < v.getCurriculum().size(); i++) {

				if (v.getCurriculum().get(i).getCurriculumId() != oldVisualization.getCurriculum().get(i).getCurriculumId()) {
					oldVisualization.getCurriculum().set(i, v.getCurriculum().get(i));
				}

			}
		}
		return oldVisualization;		
	}

	//Creates a new Visualization
	@Override
	public Visualization createVisualization(Visualization v) {
		return vd.save(v);
	}

	//Deletes a Visualization (not implemented on Front End)
	@Override
	public Visualization deleteVisualizationById(int id) {
		vd.deleteById(id);
		return new Visualization();
	}

}
