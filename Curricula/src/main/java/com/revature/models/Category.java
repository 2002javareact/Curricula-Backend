package com.revature.models;

import java.awt.Color;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//create
//update
//findall
//delete


/**
 * The type Category.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {

	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	@Column(name = "category_color")
	private String categoryColor;
	
	@Column(name = "category_name")
	private String categoryName;

	/**
	 * Instantiates a new Category.
	 */
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets category id.
	 *
	 * @return the category id
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * Sets category id.
	 *
	 * @param categoryId the category id
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Gets category color.
	 *
	 * @return the category color
	 */
	public String getCategoryColor() {
		return categoryColor;
	}

	/**
	 * Sets category color.
	 *
	 * @param categoryColor the category color
	 */
	public void setCategoryColor(String categoryColor) {
		this.categoryColor = categoryColor;
	}

	/**
	 * Gets category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets category name.
	 *
	 * @param categoryName the category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Instantiates a new Category.
	 *
	 * @param categoryId    the category id
	 * @param categoryColor the category color
	 * @param categoryName  the category name
	 */
	public Category(int categoryId, String categoryColor, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryColor = categoryColor;
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryColor=" + categoryColor + ", categoryName="
				+ categoryName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryColor == null) ? 0 : categoryColor.hashCode());
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
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
		Category other = (Category) obj;
		if (categoryColor == null) {
			if (other.categoryColor != null)
				return false;
		} else if (!categoryColor.equals(other.categoryColor))
			return false;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		return true;
	}
}
