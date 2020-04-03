package com.revature.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Skill;


@Repository
public interface SkillDao extends JpaRepository<Skill,Integer> {
	
	List<Skill>findByCategory_CategoryId(int id);
	
}
