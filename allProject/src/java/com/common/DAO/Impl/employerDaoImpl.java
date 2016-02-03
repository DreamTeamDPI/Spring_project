/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.DAO.Impl;

import com.common.DAO.employerDao;
import com.common.model.Employer;
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
@Repository("employer")
public class employerDaoImpl{

    @Autowired
    private SessionFactory sessionFactory;
    

    @Transactional
    public List<Employer> list() {
                @SuppressWarnings("unchecked")
		List<Employer> listEmployers = (List<Employer>) sessionFactory.getCurrentSession()
				.createCriteria(Employer.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listEmployers; 
    }

    @Transactional

	public Employer get(int id) {
		String hql = "from Employer where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Employer> listUser = (List<Employer>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
	}
        
        
         @Transactional
	public void saveOrUpdate(Employer user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}


    @Transactional
    public void save(Employer depart) {
        //sessionFactory.getCurrentSession().saveOrUpdate(user);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Transactional
	public void delete(int id) {
		Employer userToDelete = new Employer(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}


}
