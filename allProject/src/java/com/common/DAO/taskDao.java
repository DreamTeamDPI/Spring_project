/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.DAO;

import com.common.model.Task;
import java.util.List;

/**
 *
 * @author SEMEN
 */
public interface taskDao {
    public List<Task> list();
    
    public Task get(int id);
            
    public void save(Task task);
    
    public void delete(int id);
    
}
