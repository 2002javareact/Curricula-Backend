package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The type Skill.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Skill {

	@Id
	@Column(name = "skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	
	@Column(name = "skill_name")
	private String skillName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category_id")
	private Category category;

	/**
	 * Instantiates a new Skill.
	 */
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets skill id.
	 *
	 * @return the skill id
	 */
	public int getSkillId() {
		return skillId;
	}

	/**
	 * Sets skill id.
	 *
	 * @param skillId the skill id
	 */
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	/**
	 * Gets skill name.
	 *
	 * @return the skill name
	 */
	public String getSkillName() {
		return skillName;
	}

	/**
	 * Sets skill name.
	 *
	 * @param skillName the skill name
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	/**
	 * Gets category.
	 *
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Sets category.
	 *
	 * @param category the category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Instantiates a new Skill.
	 *
	 * @param skillId   the skill id
	 * @param skillName the skill name
	 * @param category  the category
	 */
	public Skill(int skillId, String skillName, Category category) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + skillId;
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
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
		Skill other = (Skill) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (skillId != other.skillId)
			return false;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
			return false;
		return true;
	}
}
