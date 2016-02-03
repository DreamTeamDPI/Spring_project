/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.DAO.Impl;

import com.common.DAO.projectDao;
import com.common.model.Project;
import com.common.model.Task;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Konos
 */

@Repository("project")
public  class projectDaoImpl {
    
    @Autowired
	private SessionFactory sessionFactory;

	public projectDaoImpl() {
		
	}
	
	public projectDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Project> list() {
		@SuppressWarnings("unchecked")
		List<Project> listUser = (List<Project>) sessionFactory.getCurrentSession()
				.createCriteria(Project.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

        @Transactional
        public Project get(int id) {
                    @SuppressWarnings("unchecked")
                    List<Project> listTask = sessionFactory.getCurrentSession().createCriteria(Project.class)
                            .add(Restrictions.eq("idProgect",id)).list();

                    if (listTask != null && !listTask.isEmpty()) {
                            return listTask.get(0);
                    }

                    return null;
        }
        @Transactional
        public void save(Project project) {
                sessionFactory.getCurrentSession().saveOrUpdate(project);
        }
        @Transactional
        public void delete(int id) {
           sessionFactory.getCurrentSession().delete(new Project(id));
        }
}
