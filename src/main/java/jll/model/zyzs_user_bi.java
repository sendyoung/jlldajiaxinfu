package jll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户Entity
 */
@Entity(name = "zyzs_user_bi")
public class zyzs_user_bi {
	
	/**主键id**/
	private String id;
	/**用户名**/
	private String username;
	/**密码**/
	private String password;
	/**角色**/
	private String groupId;
	/**是否删除    0:激活 1:禁用**/
	private String isDelete;
	
	private String name;
	
	
	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	/** 
	 * @return 返回 groupId 
	 */
	@Column(name = "groupId")
	public String getGroupId() {
		return groupId;
	}
	
	/** 
	* @param 对groupId进行赋值 
	*/
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	@Column(name = "isDelete")
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
