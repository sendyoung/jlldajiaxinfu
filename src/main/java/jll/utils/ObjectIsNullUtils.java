package jll.utils;

import java.lang.reflect.Field;

public class ObjectIsNullUtils {
	//判断对象是否为空
	//空，返回false
	//非空，返回true
	public static  boolean checkObjFieldIsNull(Object obj){ 
		boolean flag = false; 
		for(Field f : obj.getClass().getDeclaredFields()){ 
			f.setAccessible(true); 
			try {
				if(f.get(obj) == null){ 
					flag = false; 
				}else {
					return true;
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
}
