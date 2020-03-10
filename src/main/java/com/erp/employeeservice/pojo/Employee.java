package com.erp.employeeservice.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private double ctc;

	@Column(name="employee_id")
	private String employeeId;

	@Column(name="is_active")
	private byte isActive;

	@Column(name="joining_date")
	private Long joiningDate;

	@Column(name="leaving_date")
	private Long leavingDate;

	private int salary;

	@Column(name="total_experience")
	private int totalExperience;

	private Long user;

	//bi-directional many-to-one association to Designation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="designation")
	private Designation designationBean;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manager")
	private Employee employee;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employee")
	private List<Employee> employees;

	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="employeeBean")
	private List<Experience> experiences;

	//bi-directional many-to-one association to Salary
	@OneToMany(mappedBy="employee1")
	private List<Salary> salaries1;

	//bi-directional many-to-one association to Salary
	@OneToMany(mappedBy="employee2")
	private List<Salary> salaries2;

	public Employee() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCtc() {
		return this.ctc;
	}

	public void setCtc(double ctc) {
		this.ctc = ctc;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public Long getJoiningDate() {
		return this.joiningDate;
	}

	public void setJoiningDate(Long joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Long getLeavingDate() {
		return this.leavingDate;
	}

	public void setLeavingDate(Long leavingDate) {
		this.leavingDate = leavingDate;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getTotalExperience() {
		return this.totalExperience;
	}

	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	public Long getUser() {
		return this.user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Designation getDesignationBean() {
		return this.designationBean;
	}

	public void setDesignationBean(Designation designationBean) {
		this.designationBean = designationBean;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setEmployee(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setEmployee(null);

		return employee;
	}

	public List<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience addExperience(Experience experience) {
		getExperiences().add(experience);
		experience.setEmployeeBean(this);

		return experience;
	}

	public Experience removeExperience(Experience experience) {
		getExperiences().remove(experience);
		experience.setEmployeeBean(null);

		return experience;
	}

	public List<Salary> getSalaries1() {
		return this.salaries1;
	}

	public void setSalaries1(List<Salary> salaries1) {
		this.salaries1 = salaries1;
	}

	public Salary addSalaries1(Salary salaries1) {
		getSalaries1().add(salaries1);
		salaries1.setEmployee1(this);

		return salaries1;
	}

	public Salary removeSalaries1(Salary salaries1) {
		getSalaries1().remove(salaries1);
		salaries1.setEmployee1(null);

		return salaries1;
	}

	public List<Salary> getSalaries2() {
		return this.salaries2;
	}

	public void setSalaries2(List<Salary> salaries2) {
		this.salaries2 = salaries2;
	}

	public Salary addSalaries2(Salary salaries2) {
		getSalaries2().add(salaries2);
		salaries2.setEmployee2(this);

		return salaries2;
	}

	public Salary removeSalaries2(Salary salaries2) {
		getSalaries2().remove(salaries2);
		salaries2.setEmployee2(null);

		return salaries2;
	}

}