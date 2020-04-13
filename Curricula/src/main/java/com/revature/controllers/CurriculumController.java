package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Curriculum;
import com.revature.services.CurriculumService;

@RestController
@RequestMapping("curriculum")
public class CurriculumController {
	
	private CurriculumService cs;

	@Autowired
	public CurriculumController(CurriculumService cs) {
		super();
		this.cs = cs;
	}
	
	@GetMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity getAllCurriculum(){
		return new ResponseEntity<List<Curriculum>>(cs.getAllCurriculum(), HttpStatus.OK);
	}
	
	@PostMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity createNewCurriculum(@RequestBody Curriculum nc) {
		System.out.println("###################" + nc.getCurriculumName());
		if(nc.getCurriculumId() != 0 ) {
			return new ResponseEntity<>("Id must not be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Curriculum>(cs.createCurriculum(nc),HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	@SuppressWarnings("rawtypes")
	public ResponseEntity getCurriculumById(@PathVariable int id){
		if(id == 0) {
			return new ResponseEntity<>("Id must not be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Curriculum>(cs.getCurriculumById(id), HttpStatus.OK);
	}
	
	@PatchMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity updateCurriculum(@RequestBody Curriculum curriculum) {
		return new ResponseEntity<Curriculum>(cs.updateCurriculum(curriculum),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteCurriculum(@PathVariable int id) {
		if (id == 0) {
			return new ResponseEntity<>("Id must not be 0",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Curriculum>(cs.deleteCurriculumById(id),HttpStatus.NO_CONTENT);
	}
	
}
