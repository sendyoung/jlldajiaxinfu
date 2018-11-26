package jll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 权限与角色中间表
 */

@Entity(name = "zyzs_role_group_bi")
public class zyzs_role_group_bi {
	
	/**主键id**/
	private String id;
	/**角色id**/
	private String GroupId;
	/**权限id**/
	private String RoleId;
	
	
	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	/** 
	 * @return 返回 groupId 
	 */
	@Column(name = "groupId")
	public String getGroupId() {
		return GroupId;
	}
	
	/** 
	* @param 对groupId进行赋值 
	*/
	
	public void setGroupId(String groupId) {
		GroupId = groupId;
	}
	
	
	/** 
	 * @return 返回 roleId 
	 */
	@Column(name = "roleId")
	public String getRoleId() {
		return RoleId;
	}
	
	/** 
	* @param 对roleId进行赋值 
	*/
	
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	
	
}
