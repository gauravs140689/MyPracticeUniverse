package com.practice.cache;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CustomCache {

	private ConcurrentHashMap<String, List<String>> cache;
	private long lastModTimestamp = 0;
	

	public ConcurrentHashMap<String, List<String>> getCache() {
		return cache;
	}

	public void setCache(ConcurrentHashMap<String, List<String>> cache) {
		this.cache = cache;
	}

	public long getLastModTimestamp() {
		return lastModTimestamp;
	}

	public void setLastModTimestamp(long lastModTimestamp) {
		this.lastModTimestamp = lastModTimestamp;
	}

}
