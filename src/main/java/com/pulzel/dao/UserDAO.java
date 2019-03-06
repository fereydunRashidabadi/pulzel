package com.pulzel.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pulzel.entity.User;
@Repository
@Transactional
public class UserDAO implements IUserDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	public User getActiveUser(String userName) {
		User activeUser = new User();
		short enabled = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM User u WHERE userName=? and enabled=?")
				.setParameter(1, userName).setParameter(2, enabled).getResultList();
		if(!list.isEmpty()) {
			activeUser = (User)list.get(0);
		}
		return activeUser;
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public boolean userExists(String national_code) {
		String hql = "FROM User as user WHERE user.national_code = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, national_code)
				.getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public List<User> getAllUser() {
		String hql = "FROM User as user ORDER BY user.id";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}
}