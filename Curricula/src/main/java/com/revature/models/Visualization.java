package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})// put this on all of your entities
public class Visualization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "visualization_id")
	private int visualizationId;
	
	@Column(name = "visualization_name")
	private String visualizationName;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Curriculum> curriculum;
	
}
