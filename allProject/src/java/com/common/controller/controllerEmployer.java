/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.controller;

import com.common.DAO.Impl.departmentDaoImpl;
import com.common.DAO.Impl.employerDaoImpl;
import com.common.model.Department;
import com.common.model.Employer;
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
 * @author SEMEN
 */
@Controller

public class controllerEmployer {
    
    @Autowired
    @Qualifier("employer")
    private employerDaoImpl emplDao;
    
    @RequestMapping(value = "list/emplList" , method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {
		List<Employer> listEmpls = emplDao.list();
		ModelAndView model = new ModelAndView("list/EmplList");
		model.addObject("emplList", listEmpls);
		return model;
	}
        
        
           @RequestMapping(value = "list/editEmpl", method = RequestMethod.GET)
	public ModelAndView editUser(int id) {
		
		Employer user = emplDao.get(id);
		ModelAndView model = new ModelAndView("EmplForm");
		model.addObject("user", user);
		return model;		
	}
        
      @RequestMapping(value = "list/newemplo", method = RequestMethod.GET)
	public ModelAndView newEmpl() {
		ModelAndView model = new ModelAndView("EmplForm");
		model.addObject("user", new Employer());
		return model;		
	}
        
        @RequestMapping(value = "list/saveempl", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute Employer user) {
		emplDao.saveOrUpdate(user);
		return new ModelAndView("redirect:/");
	}
        
        
        @RequestMapping(value = "list/deleteEmpl", method = RequestMethod.GET)
	public ModelAndView deleteUser(int id) {
		
		emplDao.delete(id);
		return new ModelAndView("redirect:/");		
	}
        
     
        
}
