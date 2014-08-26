package com.order.dao.subsystem;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.order.bean.Productcategories;
import com.order.dao.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Productcategories entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.order.bean.Productcategories
 * @author MyEclipse Persistence Tools
 */
public class ProductcategoriesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ProductcategoriesDAO.class);
	// property constants
	public static final String CATEGORY_NAME = "categoryName";
	public static final String CATEGORY_PICTURE = "categoryPicture";

	public void save(Productcategories transientInstance) {
		log.debug("saving Productcategories instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Productcategories persistentInstance) {
		log.debug("deleting Productcategories instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Productcategories findById(java.lang.Integer id) {
		log.debug("getting Productcategories instance with id: " + id);
		try {
			Productcategories instance = (Productcategories) getSession().get(
					"com.order.bean.Productcategories", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Productcategories instance) {
		log.debug("finding Productcategories instance by example");
		try {
			List results = getSession()
					.createCriteria("com.order.bean.Productcategories")
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
		log.debug("finding Productcategories instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Productcategories as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCategoryName(Object categoryName) {
		return findByProperty(CATEGORY_NAME, categoryName);
	}

	public List findByCategoryPicture(Object categoryPicture) {
		return findByProperty(CATEGORY_PICTURE, categoryPicture);
	}

	public List findAll() {
		log.debug("finding all Productcategories instances");
		try {
			String queryString = "from Productcategories";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Productcategories merge(Productcategories detachedInstance) {
		log.debug("merging Productcategories instance");
		try {
			Productcategories result = (Productcategories) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Productcategories instance) {
		log.debug("attaching dirty Productcategories instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Productcategories instance) {
		log.debug("attaching clean Productcategories instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}