package com.order.dao.subsystem;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.order.bean.Customers;
import com.order.dao.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Customers entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.order.bean.Customers
 * @author MyEclipse Persistence Tools
 */
public class CustomersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CustomersDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	public static final String ADDRESS = "address";
	public static final String TOTAL_COST = "totalCost";
	public static final String CUSTOMER_PHONE = "customerPhone";

	public void save(Customers transientInstance) {
		log.debug("saving Customers instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Customers persistentInstance) {
		log.debug("deleting Customers instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Customers findById(java.lang.Integer id) {
		log.debug("getting Customers instance with id: " + id);
		try {
			Customers instance = (Customers) getSession().get(
					"com.order.bean.Customers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Customers instance) {
		log.debug("finding Customers instance by example");
		try {
			List results = getSession().createCriteria("com.order.bean.Customers")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Customers instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Customers as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByTotalCost(Object totalCost) {
		return findByProperty(TOTAL_COST, totalCost);
	}

	public List findByCustomerPhone(Object customerPhone) {
		return findByProperty(CUSTOMER_PHONE, customerPhone);
	}

	public List findAll() {
		log.debug("finding all Customers instances");
		try {
			String queryString = "from Customers";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Customers merge(Customers detachedInstance) {
		log.debug("merging Customers instance");
		try {
			Customers result = (Customers) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Customers instance) {
		log.debug("attaching dirty Customers instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Customers instance) {
		log.debug("attaching clean Customers instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void updateTotalCost(float price,Customers customer) {
		try {
			getSession().beginTransaction();
			String queryString = "update Customers set totalcost=totalcost+? where customerid=? ";
			Query query = getSession().createQuery(queryString);
			query.setParameter(0,price);
			query.setParameter(1,customer.getCustomerId());
			query.executeUpdate();
			getSession().getTransaction().commit();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List checkCustomer(String username,String password) {

		try {
			String queryString = "from Customers as model where model.userName=? and model.password=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, username);
			queryObject.setParameter(1, password);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}