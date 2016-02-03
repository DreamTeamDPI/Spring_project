/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.controller;

import com.common.DAO.Impl.departmentDaoImpl;
import com.common.DAO.departmentDao;
import com.common.model.Department;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SEMEN
 */
@Controller
public class controller_depart {
    
    @Autowired
    @Qualifier("rep")
    
    
	
    private departmentDaoImpl departDao;
    
    @RequestMapping(value = "list/departList" , method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {
		List<Department> listDeparts = departDao.list();
		ModelAndView model = new ModelAndView("list/DepartList");
		model.addObject("departList", listDeparts);
		return model;
	}
        
    @RequestMapping(value = "list/edit", method = RequestMethod.GET)
	public ModelAndView editUser(int id) {
		
		Department user = departDao.get(id);
		ModelAndView model = new ModelAndView("DepartForm");
		model.addObject("user", user);
		return model;		
	}
        
        
        
        @RequestMapping(value = "list/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute Department user) {
		departDao.saveOrUpdate(user);
		return new ModelAndView("redirect:/");
	}
        
      @RequestMapping(value = "list/new", method = RequestMethod.GET)
	public ModelAndView newDepart() {
		ModelAndView model = new ModelAndView("DepartForm");
		model.addObject("user", new Department());
		return model;		
	}
        
        @RequestMapping(value = "list/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(int id) {
		
		departDao.delete(id);
		return new ModelAndView("redirect:/");		
	}
        
        
        
        
        
    
}
