package com.revature.services;

import java.util.List;

import com.revature.models.Skill;

public interface SkillServices {

	List<Skill> getAllSkill();

	Skill saveNewSkill(Skill s);

	List<Skill> getSkillByCategoryId(int id);

	Skill updateSkill(Skill s);

	List<Skill> deleteSkill(int id);

	Skill getBySkillId(int id);

}
