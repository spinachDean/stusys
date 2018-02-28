package cn.hbu.stusys.model;

/**
 * @author chensiming
 *班级实体类，用于动态的获取班级
 */
public class Clazz {
	private String name;
	private int classID;//班级id，方便插入和删除时的操作。
	private int year;//年级，由班级定义
	private String teacher;//教师的用户名
	private String teacherName;//教师姓名
	private int collegeID;	//学院id
	private String collegeName;//学院名
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getCollegeID() {
		return collegeID;
	}
	public void setCollegeID(int collegeID) {
		this.collegeID = collegeID;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

}
