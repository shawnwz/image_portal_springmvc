/**
 * 
 */
package com.gaopin.frame.hibernate;

import org.hibernate.criterion.Criterion;

/**
 *
 */
public interface HibernateExpression {
	public Criterion createCriteria();
}
