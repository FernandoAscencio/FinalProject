package com.montrealcollege.finalproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String login;

	@Column
	private String password;

	@Column
	@Email
	private String email;

	@Column
	@Size(max=4)
	private String type;

	@Column
	private String location;

	@Column
	private String role;

	@Column
	private String phone;

	@Column
	private String description;

	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@CreationTimestamp
	private Date createdAt;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "company", cascade=CascadeType.ALL)
	private List<Job> jobs;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
	private List<Education> educations;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
	private List<Skills> skillList;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
	private List<WorkExperience> experiences;
	
	@ManyToMany(fetch=FetchType.LAZY, 
			cascade={CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="application", joinColumns=@JoinColumn(name="user_id"), 
	inverseJoinColumns=@JoinColumn(name="job_id"))
	private List<Job> applied;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public void addJob(Job tempJob) {
		if(jobs == null)
			jobs = new ArrayList<>();
		jobs.add(tempJob);
		tempJob.setCompany(this);
	}
	
	public List<Education> getEducations() {
		return educations;
	}
	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}
	public void addEducation(Education tempedu) {
		if(educations == null)
			educations = new ArrayList<>();
		educations.add(tempedu);
		tempedu.setUser(this);
	}
	public List<Skills> getSkillList() {
		return skillList;
	}
	public void setSkillList(List<Skills> skillList) {
		this.skillList = skillList;
	}
	public void addSkill(Skills skill) {
		if(skillList == null)
			skillList = new ArrayList<>();
		skillList.add(skill);
		skill.setUser(this);
	}
	public List<WorkExperience> getExperiences() {
		return experiences;
	}
	public void setExperiences(List<WorkExperience> experiences) {
		this.experiences = experiences;
	}
	public void addExperience(WorkExperience tempExp) {
		if(experiences == null)
			experiences = new ArrayList<>();
		experiences.add(tempExp);
		tempExp.setUser(this);
	}
	
	public List<Job> getApplied() {
		return applied;
	}
	public void setApplied(List<Job> applied) {
		this.applied = applied;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", login=" + login + ", password=" + password + ", email=" + email
				+ ", type=" + type + ", location=" + location + ", role=" + role + ", phone=" + phone + ", description="
				+ description + ", createdAt=" + createdAt + "]";
	}
}
