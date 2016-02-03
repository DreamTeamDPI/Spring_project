/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.DAO;

import com.common.model.Project;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SEMEN
 */
public interface projectDao {
    
    public List<Project> list();
    
    public Project get(int id);
            
    public void save(Project project);
    
    public void delete(int id);
    
}
