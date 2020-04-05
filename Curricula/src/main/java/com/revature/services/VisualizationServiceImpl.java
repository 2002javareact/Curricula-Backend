package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.VisualizationDao;
import com.revature.models.Visualization;

@Service
public class VisualizationServiceImpl implements VisualizationService {

	VisualizationDao vd;

	@Autowired
	public VisualizationServiceImpl(VisualizationDao vd) {
		this.vd = vd;
	}

	@Override
	public Visualization getVisualizationById(int id) {
		return vd.getOne(id);
	}

	@Override
	public List<Visualization> getAllVisualizations() {
		return vd.findAll();
	}

	@Override
	@Transactional
	public Visualization updateVisualization(Visualization v) {
		Visualization oldVisualization = vd.getOne(v.getVisualizationId());
		//This Check might need updating after front end integration to .equals("")
		if (v.getVisualizationName() != null) {
			oldVisualization.setVisualizationName(v.getVisualizationName());
		}		
		if (oldVisualization.getCurriculum().size() > v.getCurriculum().size()
				|| oldVisualization.getCurriculum().size() > v.getCurriculum().size()) {
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

	@Override
	public Visualization createVisualization(Visualization v) {
		return vd.save(v);
	}

	@Override
	public Visualization deleteVisualizationById(int id) {
		vd.deleteById(id);
		return new Visualization();
	}

}
