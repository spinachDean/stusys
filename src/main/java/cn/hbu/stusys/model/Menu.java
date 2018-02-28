package cn.hbu.stusys.model;

public class Menu {
	private Integer menuID;
	private String menuName;
	private String uri;
	public Integer getMenuID() {
		return menuID;
	}
	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	@Override
	public String toString() {
		return "Menu [menuID=" + menuID + ", menuName=" + menuName + ", uri="
				+ uri + "]";
	}
	/**
	 * 用来判断是否属于目标uri
	 * @param uri
	 * @return
	 */
	public boolean equal(String uri)
	{
		char c1[]=uri.toCharArray();
		char c2[]=this.uri.toCharArray();
		for(int i=0,k=0;i<c2.length;i++,k++)
		{
			if(c1[k]=='*')
			{
				if(k>=c1.length-1)return true;
				k++;
				while(c2[i]!=c1[k])
				{
					i++;
				}
			}
			if(i>=c2.length)return false;
			if(c2[i]!=c1[k])return false;
		}
		return true;
	}


	

}
