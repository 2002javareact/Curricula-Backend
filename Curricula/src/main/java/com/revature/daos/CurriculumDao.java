package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Curriculum;

@Repository
public interface CurriculumDao extends JpaRepository<Curriculum,Integer> {

}
