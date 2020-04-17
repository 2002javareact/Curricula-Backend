package com.revature.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Skill;

/**
 * The interface Skill dao.
 */
@Repository
public interface SkillDao extends  JpaRepository<Skill,Integer> {

	/**
	 * Find by category category id list.
	 *
	 * @param id the id
	 * @return the list
	 */
	public List<Skill>findByCategory_CategoryId(int id);
}
