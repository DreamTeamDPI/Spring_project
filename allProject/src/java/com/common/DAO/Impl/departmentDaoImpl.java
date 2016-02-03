/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.DAO.Impl;

import com.common.DAO.departmentDao;
import com.common.model.Department;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SEMEN
 */
@Repository("rep")

public class departmentDaoImpl{

    @Autowired
    private SessionFactory sessionFactory;
    
  
    @Transactional
    public List<Department> list() {
                @SuppressWarnings("unchecked")
		List<Department> listDepart = (List<Department>) sessionFactory.getCurrentSession()
				.createCriteria(Department.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listDepart; 
    }

   
  @Transactional
	public Department get(int id) {
		String hql = "from Department where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Department> listUser = (List<Department>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
	}
        

    
    public void save(Department depart) {
        //sessionFactory.getCurrentSession().saveOrUpdate(user);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Transactional
	public void saveOrUpdate(Department user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

    
    @Transactional
	public void delete(int id) {
		Department userToDelete = new Department(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}
    
}
