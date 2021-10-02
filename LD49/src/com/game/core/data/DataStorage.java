package com.game.core.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.game.Constants;

public class DataStorage {
	
	public static <T> T get(String key, Class<T> classOf) {
		String file = getStoragePath(key);
		
		try {
			byte[] data = Files.readAllBytes(Paths.get(file));
			String json = new String(data);
			
			return (T) JsonConvert.deserializeObject(json, classOf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void add(String key, Object object) {
		String file = getStoragePath(key);
		
		try {
			String json = JsonConvert.serializeObject(object);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write(json);
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean contains(String key) {
		String file = getStoragePath(key);
		return Files.exists(Paths.get(file));
	}
	
	private static String getStoragePath(String key) {
		return Constants.DATA_PATH + "/" + key + ".json";
	}

}
