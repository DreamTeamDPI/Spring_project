/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.DAO;

import com.common.model.Department;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SEMEN
 */
public interface departmentDao {
    public List<Department> list();
    
    public Department get(int id);
            
    public void save(Department depart);
    
    public void delete(int id);
    
}