package com.erp.employeeservice.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the experience database table.
 * 
 */
@Entity
@NamedQuery(name="Experience.findAll", query="SELECT e FROM Experience e")
public class Experience implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="created_on")
	private Long createdOn;

	private double ctc;

	private String designation;

	@Column(name="from_date")
	private Long fromDate;

	@Column(name="to_date")
	private Long toDate;

	private String type;

	private int years;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee")
	private Employee employeeBean;

	public Experience() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public double getCtc() {
		return this.ctc;
	}

	public void setCtc(double ctc) {
		this.ctc = ctc;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Long getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Long fromDate) {
		this.fromDate = fromDate;
	}

	public Long getToDate() {
		return this.toDate;
	}

	public void setToDate(Long toDate) {
		this.toDate = toDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYears() {
		return this.years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

}