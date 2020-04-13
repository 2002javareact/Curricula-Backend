package com.revature.services;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.SkillDao;
import com.revature.models.Skill;
import com.revature.models.Category;
import org.springframework.stereotype.Service;

@Service
public class SkillServicesImpl implements SkillServices {
	
	private SkillDao sd;
	
	@Autowired
	public SkillServicesImpl(SkillDao sd) {
		this.sd = sd;
	}
	
	@Override 
	public List<Skill> getAllSkill(){
		return sd.findAll();
	}
	
	@Override 
	public Skill saveNewSkill(Skill s){
		return sd.save(s);
	}
	
	@Override
	public Skill getBySkillId(int id) {
		return sd.getOne(id);
	}
	
	@Override
	public List<Skill> getSkillByCategoryId(int id) {
		return sd.findByCategory_CategoryId(id);
	}
	
	@Override
	@Transactional
	public Skill updateSkill (Skill s) {
		Skill oldSkill = sd.getOne(s.getSkillId());
		if(s.getSkillName() != "")
			oldSkill.setSkillName(s.getSkillName());
		if(s.getCategory().getCategoryId() != 0)
			oldSkill.setCategory(s.getCategory());
		
		return oldSkill;
	}
	
	@Override 
	public List<Skill> deleteSkill(int id){
		sd.deleteById(id);
		return sd.findAll();		
	}

	
}
