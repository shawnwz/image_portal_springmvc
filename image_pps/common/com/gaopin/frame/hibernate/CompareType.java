/**
 * 
 */
package com.gaopin.frame.hibernate;

/**
 *
 */
public enum CompareType {
	Equal("="),NotEqual("<>"),Gt(">"),Lt("<"),Ge(">="),Le("<=");
	
	private String value;
	private CompareType(String value)
	{
		this.value = value;
	}
	public String getValue()
	{
		return value;
	}
}
