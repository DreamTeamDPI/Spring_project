/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.controller;

import com.common.DAO.Impl.departmentDaoImpl;
import com.common.DAO.Impl.projectDaoImpl;
import com.common.DAO.departmentDao;
import com.common.model.Department;
import com.common.model.Project;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SEMEN
 */
@Controller
public class MainController {
    
    @Autowired
    @Qualifier("rep")
      
   
    @RequestMapping(value = " " , method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {
		ModelAndView model = new ModelAndView("Main");
		return model;
	}
       
	}
        
  
    