package com.revature.services;

import java.util.List;

import com.revature.models.Skill;

/**
 * The interface Skill services.
 */
public interface SkillServices {

	/**
	 * Gets all skill.
	 *
	 * @return the all skill
	 */
	List<Skill> getAllSkill();

	/**
	 * Save new skill skill.
	 *
	 * @param s the s
	 * @return the skill
	 */
	Skill saveNewSkill(Skill s);

	/**
	 * Gets skill by category id.
	 *
	 * @param id the id
	 * @return the skill by category id
	 */
	List<Skill> getSkillByCategoryId(int id);

	/**
	 * Update skill skill.
	 *
	 * @param s the s
	 * @return the skill
	 */
	Skill updateSkill(Skill s);

	/**
	 * Delete skill list.
	 *
	 * @param id the id
	 * @return the list
	 */
	List<Skill> deleteSkill(int id);

	/**
	 * Gets by skill id.
	 *
	 * @param id the id
	 * @return the by skill id
	 */
	Skill getBySkillId(int id);
}
