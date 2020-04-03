package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.SkillDao;
import com.revature.models.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	private SkillDao sd;
	
	@Autowired// tells spring to find a bean of type UsersDao and pass it in here
	public SkillServiceImpl(SkillDao sd) {
		this.sd = sd;
	}
	
	@Override
	public List<Skill> getAllSkills(){
		return sd.findAll();
	}
	
	@Override 
	public Skill saveNewSkill(Skill s) {
		return sd.save(s);
	}
	
	@Override
	public List<Skill> findByCategory_CategoryId(int id) {
		return sd.findByCategory_CategoryId(id);
	}
	
	@Override
	@Transactional
	public Skill updateSkill(Skill s) {
		Skill oldSkill = sd.getOne(s.getSkillId());
		if(s.getSkillName() != "") 
			oldSkill.setSkillName(s.getSkillName());
			
		return oldSkill;
	}
}

