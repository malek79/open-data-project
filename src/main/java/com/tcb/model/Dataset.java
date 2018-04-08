package com.tcb.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@ToString
@Getter
public class Dataset {
	private String id;
	private String name;
	private String title;

	private List<String> groups;
	private String organization;
	private List<String> tags;
	private String licensetitle;
	private String author;
	private  List<Map<String, String>> resources;

	@Override
	public String toString() {
		return "Dataset [id=" + id + ", name=" + name + ", title=" + title + ", groups=" + groups + ", organization="
				+ organization + ", tags=" + tags + ", licensetitle=" + licensetitle + ", author=" + author
				+ ", resources=" + resources + "]";
	}

	public Dataset(){}
	@Builder
    @JsonCreator
	public Dataset( @JsonProperty("id") String id, 
			@JsonProperty("name") String name, 
			@JsonProperty("title") String title, 
			@JsonProperty("groups") List<String> groups, 
			@JsonProperty("organization") String organization,
			@JsonProperty("tags") List<String> tags, 
			@JsonProperty("licensetitle") String licensetitle, 
			@JsonProperty("author") String author, 
			@JsonProperty("resources") List<Map<String, String>> resources) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.groups = groups;
		this.organization = organization;
		this.tags = tags ; 
		this.licensetitle = licensetitle;
		
		this.author = author ; 
		this.resources = resources;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getLicensetitle() {
		return licensetitle;
	}

	public void setLicensetitle(String licensetitle) {
		this.licensetitle = licensetitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Map<String, String>> getResources() {
		return resources;
	}

	public void setResources(List<Map<String, String>> resources) {
		this.resources = resources;
	}

	

	
}
