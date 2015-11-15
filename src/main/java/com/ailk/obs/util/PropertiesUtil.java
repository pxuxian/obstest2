package com.ailk.obs.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//配置文件读取，单例实现
public class PropertiesUtil {
	private static final String BASECONFIG_FILE = "baseConfig.cfg";
	private static PropertiesUtil loder = new PropertiesUtil(BASECONFIG_FILE);

	Properties propes = new Properties();

	private PropertiesUtil(String fileName) {
		InputStream ins = null;
		try {
			ins = this.getClass().getClassLoader().getResourceAsStream(fileName);
			propes.load(ins);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ins != null) {
					ins.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PropertiesUtil getInstance() {
		return loder;
	}

	public String get(String key) {
		String value = this.propes.getProperty(key);
		return value == null ? "" : value;
	}

}
