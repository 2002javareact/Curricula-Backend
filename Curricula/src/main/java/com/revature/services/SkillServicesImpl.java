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
	
	/*
	 * @returns a list of skills in the database*/
	@Override 
	public List<Skill> getAllSkill(){
		return sd.findAll();
	}
	
	/*@param
	 * skill object to be saved into the database
	 * @return 
	 * the skill with the new id number associated with that skill.
	 * */
	@Override 
	public Skill saveNewSkill(Skill s){
		return sd.save(s);
	}
	
	/*
	 * @param
	 * the id number number of the skill being searched for in the database
	 * @return 
	 * the skill associated with that id. 
	 * @NullPointerException 
	 * will return null if the id number is not found. 
	 * */
	@Override
	public Skill getBySkillId(int id) {
		return sd.getOne(id);
	}
	
	/*
	 * @param
	 * the id number of the category that references a list of skill
	 * @return 
	 * the list of skills associated with the category being fed into the method. 
	 * */
	@Override
	public List<Skill> getSkillByCategoryId(int id) {
		return sd.findByCategory_CategoryId(id);
	}
	
	/*
	 * @param
	 * the skill to update, this skill could have null field values. 
	 * @return 
	 * an updated skill with the valid fields of the skill object being fed into method. 
	 * */
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
	
	/*
	 * @param
	 * takes in id number of skill being deleted
	 * @returns
	 * returns a list of skills without the skill associated with the id number being
	 * fed into the method.
	 * */
	@Override 
	public List<Skill> deleteSkill(int id){
		sd.deleteById(id);
		return sd.findAll();		
	}

	
}
