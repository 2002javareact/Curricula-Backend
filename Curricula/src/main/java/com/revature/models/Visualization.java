// package com.revature.models;

// import java.awt.Color;
// import java.util.List;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.OneToMany;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @Entity
// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})// put this on
// all of your entities
// public class Visualization {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// @Column(name = "visualization_id")
// private int visualizationId;

// @Column(name = "visualization_name")
// private String visualizationName;

// @OneToMany(fetch = FetchType.EAGER)
// private List<Curriculum> curriculum;

// public Visualization() {
// super();
// // TODO Auto-generated constructor stub
// }

// public int getVisualizationId() {

// return visualizationId;

// }

// public void setVisualizationId(int visualizationId) {
// this.visualizationId = visualizationId;
// }

// public String getVisualizationName() {
// return visualizationName;
// }

// public void setVisualizationName(String visualizationName) {
// this.visualizationName = visualizationName;
// }

// public List<Curriculum> getCurriculum() {
// return curriculum;
// }

// public void setCurriculum(List<Curriculum> curriculum) {
// this.curriculum = curriculum;
// }

// public Visualization(int visualizationId, String visualizationName,
// List<Curriculum> curriculum) {
// super();
// this.visualizationId = visualizationId;
// this.visualizationName = visualizationName;
// this.curriculum = curriculum;
// }

// @Override
// public String toString() {
// return "Visualization [visualizationId=" + visualizationId + ",
// visualizationName=" + visualizationName
// + ", curriculum=" + curriculum + "]";
// }

// @Override
// public int hashCode() {
// final int prime = 31;
// int result = 1;
// result = prime * result + ((curriculum == null) ? 0 : curriculum.hashCode());
// result = prime * result + visualizationId;
// result = prime * result + ((visualizationName == null) ? 0 :
// visualizationName.hashCode());
// return result;
// }

// @Override
// public boolean equals(Object obj) {
// if (this == obj)
// return true;
// if (obj == null)
// return false;
// if (getClass() != obj.getClass())
// return false;
// Visualization other = (Visualization) obj;
// if (curriculum == null) {
// if (other.curriculum != null)
// return false;
// } else if (!curriculum.equals(other.curriculum))
// return false;
// if (visualizationId != other.visualizationId)
// return false;
// if (visualizationName == null) {
// if (other.visualizationName != null)
// return false;
// } else if (!visualizationName.equals(other.visualizationName))
// return false;
// return true;
// }
// }
