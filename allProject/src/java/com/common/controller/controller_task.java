/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.controller;


import com.common.DAO.Impl.projectDaoImpl;
import com.common.DAO.Impl.taskDaoImpl;
import com.common.model.Department;
import com.common.model.Employer;
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

public class controller_task {
    
    @Autowired
    @Qualifier("task")
    private taskDaoImpl taskDao;
    
    @Autowired
    @Qualifier("project")
    private projectDaoImpl projectDao;
    
    @RequestMapping(value = "list/taskList" , method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {
		List<Task> listTask = taskDao.list();
		ModelAndView model = new ModelAndView("list/TaskList");
		model.addObject("listTask", listTask);
		return model;
	}
       
    @RequestMapping(value = "list/edittask", method = RequestMethod.GET)
	public ModelAndView editTask(int id) {
		Task task = taskDao.get(id);
                List<Project> projects = projectDao.list();
                ModelAndView model = new ModelAndView("TaskForm");
		model.addObject("task", task);
                model.addObject("project",projects);
		return model;		
	}
    
        
     @RequestMapping(value = "list/savetask", method = RequestMethod.POST)
	public ModelAndView saveTask(@ModelAttribute Task empl) {
		taskDao.save(empl);
		return new ModelAndView("redirect:/list/taskList");
	}
        
        
    @RequestMapping(value = "list/newtask", method = RequestMethod.GET)
	public ModelAndView newTask() {
		ModelAndView model = new ModelAndView("TaskForm");
		
                List<Project> projects = projectDao.list();
                model.addObject("project",projects);
                model.addObject("task", new Task());
		return model;		
	}
        
     @RequestMapping(value = "list/deletetask", method = RequestMethod.GET)
	public ModelAndView deleteTask(int id,int prId) {
		taskDao.delete(id,prId);
		return new ModelAndView("redirect:/list/taskList");		
	}
        
   
}