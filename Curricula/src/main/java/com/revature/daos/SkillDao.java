package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Skill;


@Repository
public interface SkillDao extends JpaRepository<Skill,Integer> {

	
}
