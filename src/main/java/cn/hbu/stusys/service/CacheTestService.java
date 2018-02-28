	package cn.hbu.stusys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheTestService {
	public List<Integer> list=new ArrayList<Integer>();
	@Cacheable(value="common",key="'abc'")
	public String getLists()
	{
		return "test";
	}
	@CachePut(value="common",key="'abc'")
	public void setLists()
	{
		list.add(1);
		list.add(2);
		list.add(3);
	}
	@CacheEvict(value="common",key="'abc'")
	public void deleteLists()
	{
		list.clear();
	}
}
