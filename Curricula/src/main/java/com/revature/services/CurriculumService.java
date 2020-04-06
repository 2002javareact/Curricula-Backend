package com.revature.services;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.revature.models.Curriculum;

public interface CurriculumService{

	
	public Curriculum getCurriculumById(int id); 
	public List<Curriculum> getAllCurriculum();
	public Curriculum updateCurriculum(Curriculum cm);
	public Curriculum createCurriculum(Curriculum cm);
	public Curriculum deleteCurriculumById(int id);
}
