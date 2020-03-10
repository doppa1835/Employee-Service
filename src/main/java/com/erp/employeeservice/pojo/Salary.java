package com.erp.employeeservice.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the salary database table.
 * 
 */
@Entity
@NamedQuery(name="Salary.findAll", query="SELECT s FROM Salary s")
public class Salary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private double basic;

	@Column(name="city_allowances")
	private double cityAllowances;

	@Column(name="created_on")
	private Long createdOn;

	private double da;

	@Column(name="from_date")
	private Long fromDate;

	@Column(name="gross_salary")
	private double grossSalary;

	private double hra;

	private double ltc;

	@Column(name="meal_card_allowances")
	private double mealCardAllowances;

	@Column(name="medical_allowances")
	private double medicalAllowances;

	@Column(name="net_salary")
	private double netSalary;

	private double other;

	@Column(name="payment_type")
	private String paymentType;

	@Column(name="phone_allowances")
	private double phoneAllowances;

	@Column(name="to_date")
	private Long toDate;

	@Column(name="uniform_allowances")
	private double uniformAllowances;

	//bi-directional many-to-one association to Deduction
	@OneToMany(mappedBy="salaryBean")
	private List<Deduction> deductions;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="accountant")
	private Employee employee1;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee")
	private Employee employee2;

	public Salary() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBasic() {
		return this.basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getCityAllowances() {
		return this.cityAllowances;
	}

	public void setCityAllowances(double cityAllowances) {
		this.cityAllowances = cityAllowances;
	}

	public Long getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public double getDa() {
		return this.da;
	}

	public void setDa(double da) {
		this.da = da;
	}

	public Long getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Long fromDate) {
		this.fromDate = fromDate;
	}

	public double getGrossSalary() {
		return this.grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getHra() {
		return this.hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getLtc() {
		return this.ltc;
	}

	public void setLtc(double ltc) {
		this.ltc = ltc;
	}

	public double getMealCardAllowances() {
		return this.mealCardAllowances;
	}

	public void setMealCardAllowances(double mealCardAllowances) {
		this.mealCardAllowances = mealCardAllowances;
	}

	public double getMedicalAllowances() {
		return this.medicalAllowances;
	}

	public void setMedicalAllowances(double medicalAllowances) {
		this.medicalAllowances = medicalAllowances;
	}

	public double getNetSalary() {
		return this.netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	public double getOther() {
		return this.other;
	}

	public void setOther(double other) {
		this.other = other;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public double getPhoneAllowances() {
		return this.phoneAllowances;
	}

	public void setPhoneAllowances(double phoneAllowances) {
		this.phoneAllowances = phoneAllowances;
	}

	public Long getToDate() {
		return this.toDate;
	}

	public void setToDate(Long toDate) {
		this.toDate = toDate;
	}

	public double getUniformAllowances() {
		return this.uniformAllowances;
	}

	public void setUniformAllowances(double uniformAllowances) {
		this.uniformAllowances = uniformAllowances;
	}

	public List<Deduction> getDeductions() {
		return this.deductions;
	}

	public void setDeductions(List<Deduction> deductions) {
		this.deductions = deductions;
	}

	public Deduction addDeduction(Deduction deduction) {
		getDeductions().add(deduction);
		deduction.setSalaryBean(this);

		return deduction;
	}

	public Deduction removeDeduction(Deduction deduction) {
		getDeductions().remove(deduction);
		deduction.setSalaryBean(null);

		return deduction;
	}

	public Employee getEmployee1() {
		return this.employee1;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}

	public Employee getEmployee2() {
		return this.employee2;
	}

	public void setEmployee2(Employee employee2) {
		this.employee2 = employee2;
	}

}