package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Skill;
import com.revature.services.SkillService;
//delete me needed to push code
@RestController 
@RequestMapping("skill")
@CrossOrigin
public class SkillController {
	
	private SkillService ss;
	
	@Autowired
	public SkillController(SkillService ss) {
		this.ss = ss;
	}
	
	@GetMapping 
	public ResponseEntity<List<Skill>> getAllSkill(){
		return new ResponseEntity(ss.getAllSkills(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Skill> saveNewSkill(@RequestBody Skill s){
		if(s.getSkillId() != 0)
			return new ResponseEntity("skilId must be 0", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Skill>(ss.saveNewSkill(s), HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<List<Skill>> getSkillByCategoryId(@PathVariable int id){
		if(id == 0)
			return new ResponseEntity("Id must not be 0", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<Skill>>(ss.findByCategory_CategoryId(id), HttpStatus.OK);
	}
	
	@PatchMapping
	public ResponseEntity<Skill> updateSkill(@RequestBody Skill s){
		if(s.getSkillId() == 0)
			return new ResponseEntity("skillId must not be 0", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Skill>(ss.updateSkill(s),HttpStatus.CREATED);
	}
}
