package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Skill;
import com.revature.services.SkillServices;


/**
 * The type Skill controllers.
 */
@RestController
@RequestMapping("skill")
@CrossOrigin
public class SkillControllers {

	private SkillServices ss;

	/**
	 * Instantiates a new Skill controllers.
	 *
	 * @param ss the ss
	 */
	@Autowired
	public SkillControllers(SkillServices ss) {
		super();
		this.ss = ss;
	}

	/**
	 * Get all skill response entity.
	 *
	 * @return the response entity
	 */
	@GetMapping
	public ResponseEntity<List<Skill>>getAllSkill(){
		return new ResponseEntity(ss.getAllSkill(),HttpStatus.OK);
	}

	/**
	 * Save new skill response entity.
	 *
	 * @param s the s
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<Skill>saveNewSkill(@RequestBody Skill s){
		if(s.getSkillId() != 0) {
			return new ResponseEntity("userId must be 0", HttpStatus.BAD_REQUEST);
		}
	return new ResponseEntity<Skill>(ss.saveNewSkill(s), HttpStatus.OK);
	}

	/**
	 * Get skill by id response entity.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping({"skillId"})
	public ResponseEntity<Skill>getSkillById(@PathVariable int id){
		if(id == 0) {
			return new ResponseEntity("Id must not be 0",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Skill>(ss.getBySkillId(id),HttpStatus.OK);
	}

	/**
	 * Get skill by category id response entity.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping({"categoryId/{id}"})
	public ResponseEntity<List<Skill>>getSkillByCategoryId(@PathVariable int id){
		if(id == 0) {
			return new ResponseEntity("Id must not be 0",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(ss.getSkillByCategoryId(id),HttpStatus.OK);
	}

	/**
	 * Update skill response entity.
	 *
	 * @param s the s
	 * @return the response entity
	 */
	@PatchMapping
	public ResponseEntity<Skill> updateSkill(@RequestBody Skill s){
		return new ResponseEntity<Skill>(ss.updateSkill(s),HttpStatus.OK);
	}

	/**
	 * Delete skill response entity.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<List<Skill>>deleteSkill(@PathVariable int id) {
		if(id == 0) {
			return new ResponseEntity("Id must not be 0",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(ss.deleteSkill(id),HttpStatus.OK);
	}
}
