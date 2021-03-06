package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.CurriculumDao;
import com.revature.models.Curriculum;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type Curriculum service.
 */
@Service
public class CurriculumServiceImpl implements CurriculumService{

	/**
	 * The Cd.
	 */
	CurriculumDao cd;

	/**
	 * Instantiates a new Curriculum service.
	 *
	 * @param cd the cd
	 */
	@Autowired
	public CurriculumServiceImpl(CurriculumDao cd) {
		this.cd = cd; 
		
	}

	@Override
	public Curriculum getCurriculumById(int id) {
		// TODO Auto-generated method stub
		return cd.findById(id).orElse(null);
	}

	//
	@Override
	public List<Curriculum> getAllCurriculum() {
		// TODO Auto-generated method stub
		return cd.findAll();
	}

	@Override
	@Transactional
	public Curriculum updateCurriculum(Curriculum newCurriculum) {
		// TODO Auto-generated method stub
		Curriculum oldCurriculum = cd.getOne(newCurriculum.getCurriculumId());
		if(!newCurriculum.getCurriculumName().equals("")) {
			oldCurriculum.setCurriculumName(newCurriculum.getCurriculumName());
		}
		if(newCurriculum.getSkills().size() != 0) {
			oldCurriculum.setSkills(newCurriculum.getSkills());
		}
		return oldCurriculum;
	}

	@Override
	public Curriculum createCurriculum(Curriculum cm) {
		// TODO Auto-generated method stub
		return cd.save(cm);
	}

	@Override
	public Curriculum deleteCurriculumById(int id) {
		// TODO Auto-generated method stub
		cd.deleteById(id);
		return new Curriculum();
	}
	

}
