package com.revature.services;

import java.util.List;

import com.revature.models.Skill;

public interface SkillService{

	List<Skill> getAllSkills();

	Skill saveNewSkill(Skill s);

	Skill updateSkill(Skill s);

	List<Skill> findByCategory_CategoryId(int id);
	
	

}
