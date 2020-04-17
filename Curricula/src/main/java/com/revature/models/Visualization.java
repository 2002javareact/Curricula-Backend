package com.revature.models;

import java.awt.Color;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * The type Visualization.
 */
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Visualization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "visualization_id")
	private int visualizationId;

	@Column(name = "visualization_name")
	private String visualizationName;

	@ManyToMany
	@JoinTable(
			name = "visualization_curriculum",
			joinColumns = @JoinColumn(name = "visualization_id"),
			inverseJoinColumns = @JoinColumn(name = "curriculum_id"))
	@Fetch(value= FetchMode.SUBSELECT)
	private List<Curriculum> curriculum;

	/**
	 * Instantiates a new Visualization.
	 */
	public Visualization() {
		super();

	}

	/**
	 * Gets visualization id.
	 *
	 * @return the visualization id
	 */
	public int getVisualizationId() {

		return visualizationId;

	}

	/**
	 * Sets visualization id.
	 *
	 * @param visualizationId the visualization id
	 */
	public void setVisualizationId(int visualizationId) {
		this.visualizationId = visualizationId;
	}

	/**
	 * Gets visualization name.
	 *
	 * @return the visualization name
	 */
	public String getVisualizationName() {
		return visualizationName;
	}

	/**
	 * Sets visualization name.
	 *
	 * @param visualizationName the visualization name
	 */
	public void setVisualizationName(String visualizationName) {
		this.visualizationName = visualizationName;
	}

	/**
	 * Gets curriculum.
	 *
	 * @return the curriculum
	 */
	public List<Curriculum> getCurriculum() {
		return curriculum;
	}

	/**
	 * Sets curriculum.
	 *
	 * @param curriculum the curriculum
	 */
	public void setCurriculum(List<Curriculum> curriculum) {
		this.curriculum = curriculum;
	}

	/**
	 * Instantiates a new Visualization.
	 *
	 * @param visualizationId   the visualization id
	 * @param visualizationName the visualization name
	 * @param curriculum        the curriculum
	 */
	public Visualization(int visualizationId, String visualizationName, List<Curriculum> curriculum) {
		super();
		this.visualizationId = visualizationId;
		this.visualizationName = visualizationName;
		this.curriculum = curriculum;
	}

	@Override
	public String toString() {
		return "Visualization [visualizationId=" + visualizationId + ", visualizationName=" + visualizationName
				+ ", curriculum=" + curriculum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curriculum == null) ? 0 : curriculum.hashCode());
		result = prime * result + visualizationId;
		result = prime * result + ((visualizationName == null) ? 0 : visualizationName.hashCode());
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
		Visualization other = (Visualization) obj;
		if (curriculum == null) {
			if (other.curriculum != null)
				return false;
		} else if (!curriculum.equals(other.curriculum))
			return false;
		if (visualizationId != other.visualizationId)
			return false;
		if (visualizationName == null) {
			if (other.visualizationName != null)
				return false;
		} else if (!visualizationName.equals(other.visualizationName))
			return false;
		return true;
	}
}
