package com.revature.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Skill;

@Repository
public interface SkillDao extends  JpaRepository<Skill,Integer> {
	/*this is a method that is sends a request into the jpa to retrieve all skills associated
	 * with the category id being fed into the method. 
	 * @params 
	 * the id number of the category that references the skills that have that category.
	 * @returns
	 * list of skills that are referenced by that category. 
	 * */
	public List<Skill>findByCategory_CategoryId(int id);
}
