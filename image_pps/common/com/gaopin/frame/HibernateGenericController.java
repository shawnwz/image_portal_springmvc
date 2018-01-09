/**
 * 
 */
package com.gaopin.frame;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.ast.QueryTranslatorImpl;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.utils.BeanUtils;
import com.gaopin.utils.Page;

@SuppressWarnings("unchecked")
public class HibernateGenericController extends HibernateDaoSupport {

	private boolean cacheQueries = false;

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setCacheQueries(boolean cacheQueries) {
		this.cacheQueries = cacheQueries;
	}

	public boolean isCacheQueries() {
		return this.cacheQueries;
	}

	@SuppressWarnings("rawtypes")
	protected Criteria createCriteria(Class clazz) {
		Criteria criteria = getSession().createCriteria(clazz);
		if (isCacheQueries()) {
			criteria.setCacheable(true);
		}
		return criteria;
	}

	protected Query createQuery(String hql) throws HibernateException {
		Query query = getSession().createQuery(hql);
		if (isCacheQueries()) {
			query.setCacheable(true);
		}
		return query;
	}

	public <T> T load(Class<T> clasz, Serializable id)
			throws HibernateException {
		return (T) getHibernateTemplate().load(clasz, id);
	}

	public <T> T load(Class<T> clasz, Serializable id, LockMode lockMode)
			throws HibernateException {
		return (T) getHibernateTemplate().load(clasz, id, lockMode);
	}

	public <T> T get(Class<T> clasz, Serializable id) {
		return (T) getHibernateTemplate().get(clasz, id);
	}

	public Object get(String entityName, Serializable id) {
		return getHibernateTemplate().get(entityName, id);
	}

	public String getEntityName(Object obj) {
		return getSessionFactory().getClassMetadata(obj.getClass())
				.getEntityName();
	}

	public <T> T get(Class<T> clasz, Serializable id, LockMode lockMode) {
		return (T) getHibernateTemplate().get(clasz, id, lockMode);
	}

	public <T> List<T> getAll(Class<T> clasz) {
		return getHibernateTemplate().loadAll(clasz);
	}

	public <T> List<T> getAll(Class<T> clasz, String orderBy, boolean isAsc) {
		Assert.hasText(orderBy);
		if (isAsc)
			return getHibernateTemplate().findByCriteria(
					DetachedCriteria.forClass(clasz).addOrder(
							Order.asc(orderBy)));
		else
			return getHibernateTemplate().findByCriteria(
					DetachedCriteria.forClass(clasz).addOrder(
							Order.desc(orderBy)));
	}

	public void delete(Object entity) {
		getHibernateTemplate().delete(entity);
	}

	public <T> T merge(T entity) {
		return (T) getHibernateTemplate().merge(entity);
	}

	public void update(Object entity) {
		getHibernateTemplate().update(entity);
	}

	public void persist(Object entity) {
		getHibernateTemplate().persist(entity);
	}

	public Serializable save(Object entity) {
		return getHibernateTemplate().save(entity);
	}

	public <T> void deleteById(Class<T> clasz, Serializable id) {
		delete(get(clasz, id));
	}

	protected void flush() {
		getHibernateTemplate().flush();
	}

	protected void clear() {
		getHibernateTemplate().clear();
	}

	protected void refresh(Object entity, LockMode lockMode) {
		getHibernateTemplate().refresh(entity, lockMode);
	}

	protected void refresh(Object entity) {
		getHibernateTemplate().refresh(entity);
	}

	protected Query createQuery(String hql, Object... values) {
		Assert.hasText(hql);
		Query query = createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}

	@SuppressWarnings("rawtypes")
	protected Query createQuery(String hql, Map<String, Object> params) {
		Assert.hasText(hql);
		Query query = createQuery(hql);
		for (String key : params.keySet()) {
			Object param = params.get(key);
			if (param instanceof Object[]) {
				Object[] obj = (Object[]) param;
				query.setParameterList(key, obj);

			} else if (param instanceof Collection) {
				Collection collection = (Collection) param;
				query.setParameterList(key, collection);
			} else {
				query.setParameter(key, param);
			}
		}
		return query;
	}

	protected <T> Criteria createCriteria(Class<T> clasz,
			Criterion... criterions) {
		Criteria criteria = createCriteria(clasz);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	protected <T> Criteria createCriteria(Class<T> clasz, String orderBy,
			boolean isAsc, Criterion... criterions) {
		Assert.hasText(orderBy);

		Criteria criteria = createCriteria(clasz, criterions);

		String[] strs = orderBy.split(",");

		if (isAsc) {
			for (String s : strs)
				criteria.addOrder(Order.asc(s));
		} else {
			for (String s : strs)
				criteria.addOrder(Order.desc(s));
		}
		return criteria;
	}

	protected <T> Criteria createCriteria(Class<T> clasz,
			Collection<HibernateExpression> expressions) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		for (HibernateExpression expression : expressions) {
			Criterion criterion = expression.createCriteria();
			if (criterion != null) {
				criterions.add(criterion);
			}
		}

		return createCriteria(clasz, criterions.toArray(new Criterion[0]));
	}

	protected <T> Criteria createCriteria(Class<T> clasz, String orderBy,
			boolean isAsc, Collection<HibernateExpression> expressions) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		for (HibernateExpression expression : expressions) {
			Criterion criterion = expression.createCriteria();
			if (criterion != null) {
				criterions.add(criterion);
			}
		}
		return createCriteria(clasz, orderBy, isAsc,
				criterions.toArray(new Criterion[0]));
	}

	@SuppressWarnings("rawtypes")
	public List findBy(String hql, Object... values) {
		Assert.hasText(hql);
		return getHibernateTemplate().find(hql, values);
	}

	public <T> List<T> findBy(Class<T> clasz, String propertyName, Object value) {
		Assert.hasText(propertyName);
		return createCriteria(clasz, Restrictions.eq(propertyName, value))
				.list();
	}

	public <T> List<T> findBy(Class<T> clasz, Map<String, Object> map) {
		Criterion[] rs = new Criterion[map.size()];
		int i = 0;
		for (Entry<String, Object> entry : map.entrySet()) {
			rs[i] = Restrictions.eq(entry.getKey(), entry.getValue());
			i++;
		}
		return createCriteria(clasz, rs).list();
	}

	public <T> List<T> loadAll(Class<T> clasz) {
		Criteria criteria = createCriteria(clasz);
		return criteria.list();
	}

	public <T> List<T> findBy(Class<T> clasz, String propertyName,
			Object value, String orderBy, boolean isAsc) {
		Assert.hasText(propertyName);
		Assert.hasText(orderBy);
		return createCriteria(clasz, orderBy, isAsc,
				Restrictions.eq(propertyName, value)).list();
	}

	public <T> T findUniqueBy(Class<T> clasz, String propertyName, Object value) {
		Assert.hasText(propertyName);
		return (T) createCriteria(clasz, Restrictions.eq(propertyName, value))
				.uniqueResult();
	}

	@SuppressWarnings("rawtypes")
	public Long getResultCount(String hql, Object... values) {
		Assert.hasText(hql);
		String countQueryString = " select count (*) "
				+ removeSelect(removeOrders(hql));
		List countlist = getHibernateTemplate().find(countQueryString, values);
		return toLong(countlist.get(0));
	}

	@SuppressWarnings("rawtypes")
	public Integer executeUpdate(final String hql, final Object... objects) {
		return (Integer) getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(hql);
						if (objects != null) {
							for (int i = 0; i < objects.length; i++) {
								query.setParameter(i, objects[i]);
							}
						}
						return query.executeUpdate();
					}
				});
	}

	@SuppressWarnings("rawtypes")
	public Integer executeUpdateSql(final String sql, final Object... objects) {
		return (Integer) getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createSQLQuery(sql);
						if (objects != null) {
							for (int i = 0; i < objects.length; i++) {
								query.setParameter(i, objects[i]);
							}
						}
						return query.executeUpdate();
					}
				});
	}

	@SuppressWarnings("rawtypes")
	public Long getResultCount(Criteria criteria) {
		Assert.notNull(criteria);
		CriteriaImpl impl = (CriteriaImpl) criteria;
		Long totalCount = 0L;
		try {
			// 先把Projection和OrderBy条件取出来,清空两者来执行Count操作
			Projection projection = impl.getProjection();
			List<CriteriaImpl.OrderEntry> orderEntries;
			try {
				orderEntries = (List) BeanUtils.forceGetProperty(impl,
						"orderEntries");
				BeanUtils.forceSetProperty(impl, "orderEntries",
						new ArrayList());
			} catch (Exception e) {
				throw new InternalError(
						" Runtime Exception impossibility throw ");
			}

			// 执行查询
			totalCount = toLong(criteria.setProjection(Projections.rowCount())
					.uniqueResult());

			// 将之前的Projection和OrderBy条件重新设回去
			criteria.setProjection(projection);
			if (projection == null) {
				criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
			}

			try {
				BeanUtils.forceSetProperty(impl, "orderEntries", orderEntries);
			} catch (Exception e) {
				throw new InternalError(
						" Runtime Exception impossibility throw ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SessionFactoryUtils.closeSession((Session) impl.getSession());
		}
		return totalCount;
	}

	@SuppressWarnings("rawtypes")
	public Long getResultCount(Class clasz, Criterion... criterions) {
		Criteria criteria = createCriteria(clasz, criterions);
		return getResultCount(criteria);
	}

	@SuppressWarnings("rawtypes")
	public Long getResultCount(Class clasz,
			Collection<HibernateExpression> expressions) {
		Criteria criteria = createCriteria(clasz);
		for (HibernateExpression expression : expressions) {
			Criterion criterion = expression.createCriteria();
			if (criterion != null) {
				criteria.add(criterion);
			}

		}
		return getResultCount(criteria);
	}

	@SuppressWarnings("rawtypes")
	public List findBy(String hql, int pageNo, int pageSize, Object... values) {
		Assert.hasText(hql);
		Assert.isTrue(pageNo >= 0, "pageNo should start from 0");
		int startIndex = getStartOfPage(pageNo, pageSize);
		Query query = createQuery(hql, values);
		return query.setFirstResult(startIndex).setMaxResults(pageSize).list();

	}

	@SuppressWarnings("rawtypes")
	public List findBy(String hql, int pageNo, int pageSize,
			Map<String, Object> params) {
		Assert.hasText(hql);
		Assert.isTrue(pageNo >= 0, "pageNo should start from 0");
		int startIndex = getStartOfPage(pageNo, pageSize);
		Query query = createQuery(hql, params);
		return query.setFirstResult(startIndex).setMaxResults(pageSize).list();

	}

	@SuppressWarnings("rawtypes")
	public List findByArray(String hql, int pageNo, int pageSize,
			Object[] values) {
		Assert.hasText(hql);
		Assert.isTrue(pageNo >= 0, "pageNo should start from 0");
		int startIndex = getStartOfPage(pageNo, pageSize);
		Query query = createQuery(hql, values);
		return query.setFirstResult(startIndex).setMaxResults(pageSize).list();

	}

	@SuppressWarnings("rawtypes")
	public List findBy(Criteria criteria, int pageNo, int pageSize) {
		Assert.notNull(criteria);
		Assert.isTrue(pageNo >= 0, "pageNo should start from 0");
		int startIndex = getStartOfPage(pageNo, pageSize);
		return criteria.setFirstResult(startIndex).setMaxResults(pageSize)
				.list();
	}

	@SuppressWarnings("rawtypes")
	public List findBy(Criteria criteria) {
		Assert.notNull(criteria);
		return criteria.list();
	}

	@SuppressWarnings("rawtypes")
	public List findBy(Class clasz, int pageNo, int pageSize,
			Criterion... criterions) {
		Criteria criteria = createCriteria(clasz, criterions);
		return findBy(criteria, pageNo, pageSize);
	}

	public <T> List<T> findBy(Class<T> clasz, int pageNo, int pageSize,
			Collection<HibernateExpression> expressions) {
		Criteria criteria = createCriteria(clasz, expressions);
		return findBy(criteria, pageNo, pageSize);
	}

	public <T> List<T> findBy(Class<T> clasz, int pageNo, int pageSize, String orderBy,
			boolean isAsc, Collection<HibernateExpression> expressions) {
		Criteria criteria = createCriteria(clasz, orderBy, isAsc, expressions);
		return findBy(criteria, pageNo, pageSize);
	}

	public <T> List<T> findBy(Class<T> clasz,
			Collection<HibernateExpression> expressions) {
		Criteria criteria = createCriteria(clasz, expressions);
		return findBy(criteria);
	}

	public <T> List<T> findBy(Class<T> clasz, String orderBy, boolean isAsc,
			Collection<HibernateExpression> expressions) {
		Criteria criteria = createCriteria(clasz, orderBy, isAsc, expressions);
		return findBy(criteria);
	}

	@SuppressWarnings("rawtypes")
	public List findBy(Class clasz, int pageNo, int pageSize, String orderBy,
			boolean isAsc, Criterion... criterions) {
		Criteria criteria = createCriteria(clasz, orderBy, isAsc, criterions);
		return findBy(criteria, pageNo, pageSize);
	}

	public <T> boolean isUnique(Class<T> clasz, Object entity,
			String uniquePropertyNames) {
		Assert.hasText(uniquePropertyNames);
		Criteria criteria = createCriteria(clasz).setProjection(
				Projections.rowCount());
		String[] nameList = uniquePropertyNames.split(",");
		try {
			// 循环加入唯一列
			for (String name : nameList) {
				criteria.add(Restrictions.eq(name,
						PropertyUtils.getProperty(entity, name)));
			}

			// 以下代码为了如果是update的情况,排除entity自身.

			// 取得entity的主键值
			Serializable id = getId(clasz, entity);

			// 如果id!=null,说明对象已存在,该操作为update,加入排除自身的判断
			if (id != null) {
				String idName = getIdName(clasz);
				criteria.add(Restrictions.not(Restrictions.eq(idName, id)));
			}

		} catch (Exception e) {
			ReflectionUtils.handleReflectionException(e);
		}
		Integer resultCount = (Integer) criteria.uniqueResult();
		return resultCount.intValue() == 0;
	}

	@SuppressWarnings("rawtypes")
	public Serializable getId(Class clasz, Object entity)
			throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		Assert.notNull(entity);
		Assert.notNull(clasz);

		return (Serializable) PropertyUtils.getProperty(entity,
				getIdName(clasz));
	}

	public Serializable getId(Object entity) {
		return getSession().getIdentifier(entity);
	}

	@SuppressWarnings("rawtypes")
	public String getIdName(Class clazz) {
		Assert.notNull(clazz);
		ClassMetadata meta = getSessionFactory().getClassMetadata(clazz);
		Assert.notNull(meta, "Class " + clazz
				+ " not define in hibernate session factory.");
		String idName = meta.getIdentifierPropertyName();
		Assert.hasText(idName, clazz.getSimpleName()
				+ " has no identifier property define.");
		return idName;
	}

	private static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql : " + hql
				+ " must has a keyword 'from'");
		return hql.substring(beginPos);
	}

	private static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	private static int getStartOfPage(int pageNo, int pageSize) {
		return pageNo * pageSize;
	}

	private static Long toLong(Object obj) {
		if (obj instanceof Long) {
			return (Long) obj;
		} else if (obj instanceof Integer) {
			Integer i = (Integer) obj;
			return i.longValue();
		} else {
			return 0L;
		}
	}

	@SuppressWarnings("rawtypes")
	public Page findByPage(String hql, Object params, final int startPageNo,
			final int maxResultsInPage) {
		Query query = createQuery(hql);
		query.getQueryString();
		query.getNamedParameters();
		SQLQuery countQuery = getSession()
				.createSQLQuery(generateCountHql(hql));
		if (params instanceof Map) {
			prepareHql((Map<String, Object>) params, new Object[] { countQuery,
					query });
		} else {
			prepareHql((List) params, new Object[] { countQuery, query });
		}

		Long totalCount = ((BigInteger) countQuery.uniqueResult()).longValue();
		query.setMaxResults(maxResultsInPage);
		query.setFirstResult((startPageNo - 1) * maxResultsInPage);
		List datas = query.list();
		return new Page(startPageNo, totalCount, maxResultsInPage, datas);
	}

	private String generateCountHql(String originalHql) {
		QueryTranslatorImpl queryTranslatorImpl = new QueryTranslatorImpl(
				originalHql, originalHql, Collections.EMPTY_MAP,
				(SessionFactoryImplementor) getSessionFactory());
		queryTranslatorImpl.compile(Collections.EMPTY_MAP, false);
		return "SELECT count(*) FROM (" + queryTranslatorImpl.getSQLString()
				+ " ) t";
	}

	@SuppressWarnings("rawtypes")
	private void prepareHql(Map<String, Object> params, Object[] querys) {
		if (null != params) {
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				if (entry.getValue() instanceof Collection) {
					for (int i = 0; i < querys.length; i++) {
						if (querys[i] instanceof SQLQuery) {

							SQLQuery query = (SQLQuery) querys[i];
							query.setParameterList(entry.getKey(),
									(Collection) entry.getValue());
						} else {
							Query query = (Query) querys[i];
							query.setParameterList(entry.getKey(),
									(Collection) entry.getValue());
						}

					}
				} else {
					for (int i = 0; i < querys.length; i++) {
						if (querys[i] instanceof SQLQuery) {
							SQLQuery query = (SQLQuery) querys[i];
							query.setParameter(entry.getKey(), entry.getValue());

						} else {
							Query query = (Query) querys[i];
							query.setParameter(entry.getKey(), entry.getValue());
						}

					}
				}

			}
		}
	}

	@SuppressWarnings("rawtypes")
	private void prepareHql(List params, Object[] querys) {
		if (null != params) {
			for (int i = 0; i < params.size(); i++) {
				Object entry = params.get(i);
				for (int j = 0; j < querys.length; j++) {
					if (querys[j] instanceof SQLQuery) {
						SQLQuery query = (SQLQuery) querys[j];
						query.setParameter(i, entry);

					} else {
						Query query = (Query) querys[j];
						query.setParameter(i, entry);
					}

				}

			}
		}
	}

	public <T> List<T> findListBySql(String sql) {
		List<T> list = null;
		try {
			list = (List<T>) this.getSession().createSQLQuery(sql).list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public <T> List<T> findListByHql(String hql) {
		List<T> list = null;
		try {
			list = (List<T>) this.getSession().createQuery(hql).list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public <T> T findTBySql(String sql) {
		return (T) this.getSession().createSQLQuery(sql).setMaxResults(1)
				.uniqueResult();
	}

	public <T> T findTByHql(String hql) {
		return (T) this.getSession().createQuery(hql).setMaxResults(1)
				.uniqueResult();
	}
	
	public int getCount(String sql){
		ConnectionProvider cp =((SessionFactoryImplementor)getSessionFactory()).getConnectionProvider();  
//		ConnectionProvider cp1   = ConnectionProviderFactory.newConnectionProvider(); 
		Connection conn = null;
        Statement stmt = null;
        ResultSet rst = null;
        try { 
            conn = cp.getConnection();
            stmt = conn.createStatement();
            rst = stmt.executeQuery(sql);
            while(rst.next()){
            	return rst.getInt(1);
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        finally{
        	try { 
        		if(rst!=null) rst.close();
        		if(stmt!=null) stmt.close();
        		if(conn!=null) cp.closeConnection(conn); 
            } catch (SQLException e) { 
                e.printStackTrace(); 
            }
        }
        return 0;
	}
	
	/**
	 * 获取jdbc连接，此连接必须关闭
	 * @return
	 * @throws SQLException
	 */
	public Connection getConn() throws SQLException {
		return ((SessionFactoryImplementor)getSessionFactory()).getConnectionProvider().getConnection();
	}
}
