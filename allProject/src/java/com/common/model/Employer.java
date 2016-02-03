/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SEMEN
 */
@Entity
@Table(name = "employer", catalog = "projects_v2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employer.findAll", query = "SELECT e FROM Employer e"),
    @NamedQuery(name = "Employer.findByIdEmployer", query = "SELECT e FROM Employer e WHERE e.idEmployer = :idEmployer"),
    @NamedQuery(name = "Employer.findByName", query = "SELECT e FROM Employer e WHERE e.name = :name"),
    @NamedQuery(name = "Employer.findBySecondName", query = "SELECT e FROM Employer e WHERE e.secondName = :secondName"),
    @NamedQuery(name = "Employer.findByPatronymic", query = "SELECT e FROM Employer e WHERE e.patronymic = :patronymic"),
    @NamedQuery(name = "Employer.findByAdress", query = "SELECT e FROM Employer e WHERE e.adress = :adress"),
    @NamedQuery(name = "Employer.findByNomberphone", query = "SELECT e FROM Employer e WHERE e.nomberphone = :nomberphone"),
    @NamedQuery(name = "Employer.findByFunction", query = "SELECT e FROM Employer e WHERE e.function = :function"),
    @NamedQuery(name = "Employer.findBySalary", query = "SELECT e FROM Employer e WHERE e.salary = :salary"),
    @NamedQuery(name = "Employer.findByTypesalary", query = "SELECT e FROM Employer e WHERE e.typesalary = :typesalary")})
public class Employer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmployer")
    private Integer idEmployer;
    @Column(name = "Name")
    private String name;
    @Column(name = "Second_Name")
    private String secondName;
    @Column(name = "Patronymic")
    private String patronymic;
    @Column(name = "Adress")
    private String adress;
    @Column(name = "Nomber_phone")
    private String nomberphone;
    @Column(name = "Function")
    private String function;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Salary")
    private Float salary;
    @Column(name = "Type_salary")
    private String typesalary;
    @JoinTable(name = "employer_has_task", joinColumns = {
        @JoinColumn(name = "employer_idEmployer", referencedColumnName = "idEmployer")}, inverseJoinColumns = {
        @JoinColumn(name = "task_idTask", referencedColumnName = "idTask")})
    @ManyToMany
    private List<Task> taskList;
    @JoinTable(name = "employer_has_project", joinColumns = {
        @JoinColumn(name = "Employer_idEmployer", referencedColumnName = "idEmployer")}, inverseJoinColumns = {
        @JoinColumn(name = "Project_idProgect", referencedColumnName = "idProgect")})
    @ManyToMany
    private List<Project> projectList;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Department_idDepartment")  
    private Department departmentidDepartment;

    public Employer() {
    }

    public Employer(Integer idEmployer) {
        this.idEmployer = idEmployer;
    }

    public Integer getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(Integer idEmployer) {
        this.idEmployer = idEmployer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNomberphone() {
        return nomberphone;
    }

    public void setNomberphone(String nomberphone) {
        this.nomberphone = nomberphone;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getTypesalary() {
        return typesalary;
    }

    public void setTypesalary(String typesalary) {
        this.typesalary = typesalary;
    }

    @XmlTransient
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @XmlTransient
    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Department getDepartmentidDepartment() {
        return departmentidDepartment;
    }

    public void setDepartmentidDepartment(Department departmentidDepartment) {
        this.departmentidDepartment = departmentidDepartment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployer != null ? idEmployer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employer)) {
            return false;
        }
        Employer other = (Employer) object;
        if ((this.idEmployer == null && other.idEmployer != null) || (this.idEmployer != null && !this.idEmployer.equals(other.idEmployer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.common.model.Employer[ idEmployer=" + idEmployer + " ]";
    }
    
}
