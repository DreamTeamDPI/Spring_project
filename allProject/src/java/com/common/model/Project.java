/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SEMEN
 */
@Entity
@Table(name = "project", catalog = "projects_v2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByIdProgect", query = "SELECT p FROM Project p WHERE p.idProgect = :idProgect"),
    @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name"),
    @NamedQuery(name = "Project.findByDatestart", query = "SELECT p FROM Project p WHERE p.datestart = :datestart"),
    @NamedQuery(name = "Project.findByDatefinish", query = "SELECT p FROM Project p WHERE p.datefinish = :datefinish"),
    @NamedQuery(name = "Project.findByFinancing", query = "SELECT p FROM Project p WHERE p.financing = :financing"),
    @NamedQuery(name = "Project.findByType", query = "SELECT p FROM Project p WHERE p.type = :type")})
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProgect")
    private Integer idProgect;
    //@Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Date_start")
    @Temporal(TemporalType.DATE)
    private Date datestart;
    @Column(name = "Date_finish")
    @Temporal(TemporalType.DATE)
    private Date datefinish;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Financing")
    private Float financing;
    @Column(name = "Type")
    private String type;
    @ManyToMany(mappedBy = "projectList")
    private List<Employer> employerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectidProgect")
    private List<Task> taskList;

    public Project() {
    }

    public Project(Integer idProgect) {
        this.idProgect = idProgect;
    }

    public Project(Integer idProgect, String name) {
        this.idProgect = idProgect;
        this.name = name;
    }

    public Integer getIdProgect() {
        return idProgect;
    }

    public void setIdProgect(Integer idProgect) {
        this.idProgect = idProgect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDatestart() {
        return datestart;
    }
    
    @Transient
    public void setDatestart(String datestart) throws ParseException {
        
        
    DateFormat df = new SimpleDateFormat("yyyy MMM dd");
    
    Date result =  df.parse(datestart);  

        
    	


        this.datestart = result;
    }
    
    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public Date getDatefinish() {
        return datefinish;
    }

    public void setDatefinish(Date datefinish) {
        this.datefinish = datefinish;
    }

    public Float getFinancing() {
        return financing;
    }

    public void setFinancing(Float financing) {
        this.financing = financing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<Employer> getEmployerList() {
        return employerList;
    }

    public void setEmployerList(List<Employer> employerList) {
        this.employerList = employerList;
    }

    @XmlTransient
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProgect != null ? idProgect.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.idProgect == null && other.idProgect != null) || (this.idProgect != null && !this.idProgect.equals(other.idProgect))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.common.model.Project[ idProgect=" + idProgect + " ]";
    }
    
}
