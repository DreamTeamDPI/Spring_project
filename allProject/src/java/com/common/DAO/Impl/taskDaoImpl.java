/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common.DAO.Impl;
import com.common.model.Project;
import com.common.model.Task;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Konos
 */

@Repository("task")
public class taskDaoImpl {
    @Autowired
	private SessionFactory sessionFactory;

	public taskDaoImpl() {
		
	}
	
	public taskDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Task> list() {
		@SuppressWarnings("unchecked")
		List<Task> listUser = (List<Task>) sessionFactory.getCurrentSession()
				.createCriteria(Task.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

        @Transactional
        public Task get(int id) {


                    @SuppressWarnings("unchecked")
                    List<Task> listTask = sessionFactory.getCurrentSession().createCriteria(Task.class)
                            .add(Restrictions.eq("idTask",id)).list();

                    if (listTask != null && !listTask.isEmpty()) {
                            return listTask.get(0);
                    }

                    return null;

        }

        @Transactional
        public void save(Task project) {
            sessionFactory.getCurrentSession().saveOrUpdate(project);
        }

        @Transactional
        public void delete(int id, int prId) {
            Task n = new Task();
            n.setIdTask(id);
            n.setProjectidProgect(new Project(prId));
            sessionFactory.getCurrentSession().delete(n);
        }
}