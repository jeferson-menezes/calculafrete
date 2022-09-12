package com.argon.valorfrete.helper;

import java.lang.reflect.Field;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class StreamHelper {
	
	 public static <T extends Object> MultiValueMap<String, String> converterNotNullObjeto(T objeto) {

	        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	        Class<T> objetoClass = (Class<T>) objeto.getClass();
	        Field[] fields = objetoClass.getDeclaredFields();
	        for (Field field : fields) {
	            try {
	                field.setAccessible(true);
	                Object object = field.get(objeto);

	                if (object != null) {
	                    params.set(field.getName(), object.toString());
	                }
	            } catch (IllegalArgumentException | IllegalAccessException ex) {
	            }
	        }

	        return params;
	    }

}
