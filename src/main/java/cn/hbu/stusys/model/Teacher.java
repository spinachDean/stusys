package cn.hbu.stusys.model;

import java.util.List;

public class Teacher {
	private String username;//用户名
	private String roleName;//角色名
	private Integer roleID;
	private String name;//姓名
	private List<String> clazz;//班级列表
	private List<Menu> menulist;//菜单列表
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Menu> getMenulist() {
		return menulist;
	}
	public void setMenulist(List<Menu> menulist) {
		this.menulist = menulist;
	}
	@Override
	public String toString() {
		return "Teacher [username=" + username + ", roleName=" + roleName
				+ ", roleID=" + roleID + ", name=" + name + ", clazz=" + clazz
				+ ", menulist=" + menulist + "]";
	}
	
	
}
