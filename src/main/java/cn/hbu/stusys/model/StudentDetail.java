package cn.hbu.stusys.model;

/**
 * @author chensiming
 *学生的详细信息，在请求查询、修改学生详细信息的时候使用
 */
public class StudentDetail extends Student {
	private String homeNumber;//家庭电话
	private String address;//家庭住址
	private String hornor;//所获荣誉
	private String activity;//活动经历
	public String getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHornor() {
		return hornor;
	}
	public void setHornor(String hornor) {
		this.hornor = hornor;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
}
