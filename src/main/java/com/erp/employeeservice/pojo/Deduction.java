package com.erp.employeeservice.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the deductions database table.
 * 
 */
@Entity
@Table(name="deductions")
@NamedQuery(name="Deduction.findAll", query="SELECT d FROM Deduction d")
public class Deduction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private int amount;

	private String name;

	//bi-directional many-to-one association to Salary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="salary")
	private Salary salaryBean;

	public Deduction() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Salary getSalaryBean() {
		return this.salaryBean;
	}

	public void setSalaryBean(Salary salaryBean) {
		this.salaryBean = salaryBean;
	}

}