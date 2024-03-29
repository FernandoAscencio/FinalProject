package com.montrealcollege.finalproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue
	@Column
	private int id;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private double salary;

	@Column
	private String type;

	@Column(name = "req_skills")
	private String reqSkills;

	@Column
	private String city;

	@Column(name = "created_at")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date createdAt;

	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "comp_id")
	private User company;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST,
			CascadeType.REFRESH }, mappedBy = "job")
	private List<Application> applicant;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReqSkills() {
		return reqSkills;
	}

	public void setReqSkills(String reqSkills) {
		this.reqSkills = reqSkills;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getCompany() {
		return company;
	}

	public void setCompany(User company) {
		this.company = company;
	}

	public List<Application> getApplicant() {
		return applicant;
	}

	public void setApplicant(List<Application> applicant) {
		this.applicant = applicant;
	}

	public void addApplicant(Application tempApplicant) {
		if (applicant == null)
			applicant = new ArrayList<>();
		applicant.add(tempApplicant);
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", salary=" + salary + ", type="
				+ type + ", reqSkills=" + reqSkills + ", city=" + city + ", createdAt=" + createdAt + ", endDate="
				+ endDate + ", company=" + company + "]";
	}
}
