package com.revature.services;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.revature.models.Curriculum;

/**
 * The interface Curriculum service.
 */
public interface CurriculumService{


	/**
	 * Gets curriculum by id.
	 *
	 * @param id the id
	 * @return the curriculum by id
	 */
	public Curriculum getCurriculumById(int id);

	/**
	 * Gets all curriculum.
	 *
	 * @return the all curriculum
	 */
	public List<Curriculum> getAllCurriculum();

	/**
	 * Update curriculum curriculum.
	 *
	 * @param cm the cm
	 * @return the curriculum
	 */
	public Curriculum updateCurriculum(Curriculum cm);

	/**
	 * Create curriculum curriculum.
	 *
	 * @param cm the cm
	 * @return the curriculum
	 */
	public Curriculum createCurriculum(Curriculum cm);

	/**
	 * Delete curriculum by id curriculum.
	 *
	 * @param id the id
	 * @return the curriculum
	 */
	public Curriculum deleteCurriculumById(int id);
}
