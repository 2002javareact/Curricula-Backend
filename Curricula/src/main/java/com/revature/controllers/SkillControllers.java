//Endpoints for Skills table

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


@RestController
@RequestMapping("skill")
@CrossOrigin
public class SkillControllers {

	private SkillServices ss;

	@Autowired
	public SkillControllers(SkillServices ss) {
		super();
		this.ss = ss;
	}

	/*
	 * this method provides an end point for mapping all skills.
	 * @return 
	 * *returns a response object with a status of 200 and a list of all skills in the database.
	 * */
	@GetMapping
	public ResponseEntity<List<Skill>>getAllSkill(){
		return new ResponseEntity(ss.getAllSkill(),HttpStatus.OK);
	}

	/*
	 * this method takes in a skill and saves it to the database
	 * @param 
	 * 	skill object
	 * @returns 
	 * this returns a response object with new skill persisted in to the database and its new id number, a status of 200.
	 * */
	@PostMapping
	public ResponseEntity<Skill>saveNewSkill(@RequestBody Skill s){
		if(s.getSkillId() != 0) {
			return new ResponseEntity("userId must be 0", HttpStatus.BAD_REQUEST);
		}
	return new ResponseEntity<Skill>(ss.saveNewSkill(s), HttpStatus.OK);
	}

	/*
	 * this method takes an id number from a skill and returns that skill object.
	 * @param
	 * the id number of the skill being searched for. 
	 * @return the skill being searched for 
	 * @NullPointerException 
	 * 	will return a response of 200 ok and a null if object is not found.
	 * */
	@GetMapping({"skillId"})
	public ResponseEntity<Skill>getSkillById(@PathVariable int id){
		if(id == 0) {
			return new ResponseEntity("Id must not be 0",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Skill>(ss.getBySkillId(id),HttpStatus.OK);
	}
	
	/*This method will take in a category id and send back a list of skills associated with that category
	 * @param 
	 * 	takes in an id that cannot be 0 or a response of bad request will be returned,
	 * will return a response object with the skill associated with that id and a status of 200 
	 * */
	@GetMapping({"categoryId/{id}"})
	public ResponseEntity<List<Skill>>getSkillByCategoryId(@PathVariable int id){
		if(id == 0) {
			return new ResponseEntity("Id must not be 0",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(ss.getSkillByCategoryId(id),HttpStatus.OK);
	}

	/*
	 * This method will take in a skill and update it with the fields that are not equal to null. 
	 * @param
	 * a skill that could have fields that are equal to null
	 * @return 
	 * a skill that has been updated with the valid fields fed in and a response object of ok.
	 * */
	@PatchMapping
	public ResponseEntity<Skill> updateSkill(@RequestBody Skill s){
		return new ResponseEntity<Skill>(ss.updateSkill(s),HttpStatus.OK);
	}
	
	/*
	 * this method deletes a skill in the database associated with the id number fed into the method, 
	 * and returns the new list with the deleted id. 
	 * @params
	 * id number associated with the skill being deleted. 
	 * @returns 
	 * the list of skills with the skill deleted from the list. 
	 * */
	@DeleteMapping("{id}")
	public ResponseEntity<List<Skill>>deleteSkill(@PathVariable int id) {
		if(id == 0) {
			return new ResponseEntity("Id must not be 0",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(ss.deleteSkill(id),HttpStatus.OK);
	}
}
