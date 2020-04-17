package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.VisualizationDao;
import com.revature.models.Visualization;

/**
 * The type Visualization service.
 */
@Service
public class VisualizationServiceImpl implements VisualizationService {

	/**
	 * The Vd.
	 */
	VisualizationDao vd;

	/**
	 * Instantiates a new Visualization service.
	 *
	 * @param vd the vd
	 */
	@Autowired
	public VisualizationServiceImpl(VisualizationDao vd) {
		this.vd = vd;
	}

	/**
	 * Returns one Visualization by Id
	 * @param id of Visualization
	 * @return Visualization
	 */
	@Override
	public Visualization getVisualizationById(int id) {
		return vd.getOne(id);
	}

	/**
	 * Returns All Visualizations
	 * @param none
	 * @return All Visualizations
	 */
	@Override
	public List<Visualization> getAllVisualizations() {
		return vd.findAll();
	}

	/**
	 * Updates one Visualization
	 * @param Visualization to be Updated
	 * @return Updated Visualization
	 */
	@Override
	@Transactional
	public Visualization updateVisualization(Visualization v) {
		Visualization oldVisualization = vd.getOne(v.getVisualizationId());
		//This Check might need updating after front end integration to .equals("")
		if (v.getVisualizationName() != "") {
			oldVisualization.setVisualizationName(v.getVisualizationName());
		}		
		if (oldVisualization.getCurriculum().size() > v.getCurriculum().size()
				|| oldVisualization.getCurriculum().size() < v.getCurriculum().size()) {

			oldVisualization.setCurriculum(v.getCurriculum());
		}else {
			for (int i = 0; i < v.getCurriculum().size(); i++) {

				if (v.getCurriculum().get(i).getCurriculumId() != oldVisualization.getCurriculum().get(i).getCurriculumId()) {
					oldVisualization.getCurriculum().set(i, v.getCurriculum().get(i));
				}
			}
		}
		return oldVisualization;
	}

	/**
	 * Creates a Visualization
	 * @param Visualization to be created
	 * @return Created Visualization
	 */
	@Override
	public Visualization createVisualization(Visualization v) {
		return vd.save(v);
	}

	/**
	 * Deletes one Visualization by Id
	 * @param id of Visualization
	 * @return default Visualization
	 */
	@Override
	public Visualization deleteVisualizationById(int id) {
		vd.deleteById(id);
		return new Visualization();
	}

}
