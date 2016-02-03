/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.controller;

import com.common.DAO.Impl.departmentDaoImpl;
import com.common.DAO.Impl.projectDaoImpl;
import com.common.model.Department;
import com.common.model.Project;
import com.common.model.Task;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Konos
 */
@Controller

public class controller_project {
    
    @Autowired
    @Qualifier("project")
    private projectDaoImpl projectDao;
    
    @RequestMapping(value = "list/projectList" , method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {
		List<Project> listProject = projectDao.list();
		ModelAndView model = new ModelAndView("list/ProjectList");
		model.addObject("listProject", listProject);
		return model;
	}
        
   @RequestMapping(value = "list/editpr", method = RequestMethod.GET)
	public ModelAndView editTask(int id) {
		Project task = projectDao.get(id);
		ModelAndView model = new ModelAndView("ProjectForm");
		model.addObject("pr", task);
		return model;		
	}
    
        
     @RequestMapping(value = "list/savepr", method = RequestMethod.POST)
	public ModelAndView saveTask(@ModelAttribute Project empl) {
		projectDao.save(empl);
		return new ModelAndView("redirect:/list/projectList");
	}
        
        
    @RequestMapping(value = "list/newpr", method = RequestMethod.GET)
	public ModelAndView newTask() {
		ModelAndView model = new ModelAndView("ProjectForm");
		model.addObject("pr", new Project());
		return model;		
	}
        
     @RequestMapping(value = "list/deletepr", method = RequestMethod.GET)
	public ModelAndView deleteTask(int id) {
		projectDao.delete(id);
		return new ModelAndView("redirect:/list/projectList");		
	}
}