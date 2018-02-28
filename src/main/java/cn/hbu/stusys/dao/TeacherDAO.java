package cn.hbu.stusys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.hbu.stusys.model.Clazz;
import cn.hbu.stusys.model.Teacher;

/**
 * @author chensiming
 *
 */

public interface TeacherDAO {
	
	public Teacher getTeacherInfo(@Param("username")String username);
	public String getPassword(@Param("username")String username);
	public List<Clazz> getTeacherClasses(@Param("username")String username);
}
