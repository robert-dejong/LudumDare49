package com.game.core.data;

import com.google.gson.Gson;

public class JsonConvert {
	
	private static Gson gson = new Gson();
	
	public static String serializeObject(Object object) {
		return gson.toJson(object);
	}
	
	public static <T> T deserializeObject(String json, Class<T> classOf) {
		return gson.fromJson(json, classOf);
	}

}
