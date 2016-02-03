/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.DAO;

import com.common.model.Employer;
import java.util.List;

/**
 *
 * @author SEMEN
 */
public interface employerDao {
    public List<Employer> list();
    
    public Employer get(int id);
            
    public void save(Employer employer);
    
    public void delete(int id);
    
}
