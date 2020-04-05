package com.revature.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})// put this on all of your entities
public class Curriculum {
	
	@Id
	@Column(name = "curriculum_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int curriculumId;
	
	@Column(name="curriculum_name")
	private String curriculumName;
	
	@ManyToMany
	@JoinTable(
		name = "curriculum_skill",
		joinColumns = @JoinColumn(name = "curriculum_id"),
		inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skill> skills;

	public Curriculum() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCurriculumId() {
		return curriculumId;
	}

	public void setCurriculumId(int curriculumId) {
		this.curriculumId = curriculumId;
	}

	public String getCurriculumName() {
		return curriculumName;
	}

	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Curriculum(int curriculumId, String curriculumName, List<Skill> skills) {
		super();
		this.curriculumId = curriculumId;
		this.curriculumName = curriculumName;
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Curriculum [curriculumId=" + curriculumId + ", curriculumName=" + curriculumName + ", skills=" + skills
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + curriculumId;
		result = prime * result + ((curriculumName == null) ? 0 : curriculumName.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curriculum other = (Curriculum) obj;
		if (curriculumId != other.curriculumId)
			return false;
		if (curriculumName == null) {
			if (other.curriculumName != null)
				return false;
		} else if (!curriculumName.equals(other.curriculumName))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		return true;
	}
}
