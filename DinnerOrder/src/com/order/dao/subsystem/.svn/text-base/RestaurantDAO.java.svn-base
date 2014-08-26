package com.order.dao.subsystem;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.order.bean.Restaurant;
import com.order.dao.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Restaurant entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.order.bean.Restaurant
 * @author MyEclipse Persistence Tools
 */
public class RestaurantDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RestaurantDAO.class);
	// property constants
	public static final String RES_NAME = "resName";
	public static final String RES_ADDRESS = "resAddress";
	public static final String RES_PHONE = "resPhone";
	public static final String RES_DESCRIPTION = "resDescription";
	public static final String RES_TYPE = "resType";

	public void save(Restaurant transientInstance) {
		log.debug("saving Restaurant instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Restaurant persistentInstance) {
		log.debug("deleting Restaurant instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Restaurant findById(java.lang.Integer id) {
		log.debug("getting Restaurant instance with id: " + id);
		try {
			Restaurant instance = (Restaurant) getSession().get(
					"com.order.bean.Restaurant", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Restaurant instance) {
		log.debug("finding Restaurant instance by example");
		try {
			List results = getSession()
					.createCriteria("com.order.bean.Restaurant")
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
		log.debug("finding Restaurant instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Restaurant as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByResName(Object resName) {
		return findByProperty(RES_NAME, resName);
	}

	public List findByResAddress(Object resAddress) {
		return findByProperty(RES_ADDRESS, resAddress);
	}

	public List findByResPhone(Object resPhone) {
		return findByProperty(RES_PHONE, resPhone);
	}

	public List findByResDescription(Object resDescription) {
		return findByProperty(RES_DESCRIPTION, resDescription);
	}

	public List findByResType(Object resType) {
		return findByProperty(RES_TYPE, resType);
	}

	public List findAll() {
		log.debug("finding all Restaurant instances");
		try {
			String queryString = "from Restaurant";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Restaurant merge(Restaurant detachedInstance) {
		log.debug("merging Restaurant instance");
		try {
			Restaurant result = (Restaurant) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Restaurant instance) {
		log.debug("attaching dirty Restaurant instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Restaurant instance) {
		log.debug("attaching clean Restaurant instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}