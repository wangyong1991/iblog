package com.iblog.plugin;

import java.util.LinkedHashMap;

/**
 * 提供方法链功能和增强的Map&lt;String,Object&gt;实现
 * @author &#x738B;&#x52C7;
 * @iblog
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
@SuppressWarnings("unchecked")
public class MapContainer extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = -4427483659403578833L;

	  public MapContainer(){
	  }

	  public MapContainer(String key, Object value){
	    super();
	    put(key, value);
	  }

	  public <T> T get(String key, Class<T> clazz){
	    return (T) super.get(key);
	  }

	  /**
	   * 此方法和getAs方法区别为getAs为把对应键值转化为字符串再parse，此方法为直接获取值进行强转
	   * 
	   * @param key
	   * @return
	   */
	  public <T> T get(String key){
	    return (T) super.get(key);
	  }

	  @Override
	  public MapContainer put(String key, Object value){
	    super.put(key, value);
	    return this;
	  }

	  /**
	   * 缺少即加入,和ConcurrentHashMap中的putIfAbsent一致
	   * 
	   * @param key
	   * @param value
	   * @return
	   */
	  public <T> T putIfAbsent(String key, T value){
	    T result = value;
	    if(containsKey(key)){
	      result = get(key);
	    }else{
	      put(key, value);
	    }

	    return result;
	  }

}
