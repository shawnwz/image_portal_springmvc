/* This file Dynamic.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gaopin.utils.JsonFormat;

public class Dynamic {
	private Map<String, Object> _map;
	private Object obj;

	public Dynamic(Object map) {
		if(map!=null)
		{
			this._map=new HashMap<String, Object>();
			Map<String, Object> m=(Map<String, Object>) map;
			for (String key : m.keySet()) {
				this._map.put(key.toLowerCase(), m.get(key));
			}
			this._map =(Map<String, Object>) map;
		}
		this.obj=map;

	}
	public Dynamic get(String key)
	{
		return new Dynamic(_map.get(key));
	}
	
	public <T>T value()
	{
		return (T)obj;
	}
	
	public static void main()
	{
		String jsonString="{\"param\":[{\"name\":\"08:00-16:00\" ,\"value\":1},{\"name\": \"16:00-24:00\" ,\"value\":2},{\"name\": \"00:00-8:00\" ,\"value\":3}]}";
		
		Map<String, Object> map = JsonFormat.toMap(jsonString);
		
		
	}
}
