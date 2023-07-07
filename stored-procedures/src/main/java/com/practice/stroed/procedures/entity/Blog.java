package com.practice.stroed.procedures.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(name = "Blog.getTitleById", procedureName = "sp_getBlogById", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "title", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "content", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "id", type = Integer.class)})
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String title;
	private String content;

	public Blog() {
	}

	public Blog(String title, String content) {
		this.setTitle(title);
		this.setContent(content);
	}

	public Blog(int id, String title, String content) {
		this.setId(id);
		this.setTitle(title);
		this.setContent(content);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", getId()=" + getId() + ", getTitle()="
				+ getTitle() + ", getContent()=" + getContent() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}