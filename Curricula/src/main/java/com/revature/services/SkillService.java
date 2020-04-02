package com.revature.services;

import java.util.List;

import com.revature.models.Skill;

public interface SkillService{

	List<Skill> getAllSkills();

	Skill saveNewSkill(Skill s);

	Skill getSkillByCategoryId(int id);

	Skill updateSkill(Skill s);
	
	

}
