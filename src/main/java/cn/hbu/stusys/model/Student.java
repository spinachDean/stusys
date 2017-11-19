package cn.hbu.stusys.model;

/**
 * @author chensiming
 *学生基本信息的实体类，用于查询、创建、修改学生基本信息
 */
public class Student {
	
	private String id;//学号
	private String name;//姓名
	private String sex;
	private String phone;//电话
	private String clazz;//班级名称 由于class是关键字需要用clazz
	private int classId;//班级id，方便插入和删除时的操作。
	private int year;//年级，由班级定义
	private String college;//学院名
	private int collegeID;//学院id，方便插入和删除时的操作。

	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getCollegeID() {
		return collegeID;
	}
	public void setCollegeID(int collegeID) {
		this.collegeID = collegeID;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", clazz=" + clazz + ", classId=" + classId + ", year="
				+ year + ", college=" + college + ", collegeID=" + collegeID
				+ "]";
	}
	
	
}
