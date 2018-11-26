package jll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 角色表
 */
@Entity(name = "zyzs_group_bi")
public class zyzs_group_bi {
	
	/**主键id**/
	private String id;
	/**分组名称Ch**/
	private String groupNameCh;
	
	/**分组名称En**/
	private String groupNameEn;
	
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
	 * @return 返回 groupNameCh 
	 */
	@Column(name = "groupNameCH")
	public String getGroupNameCh() {
		return groupNameCh;
	}
	
	/** 
	* @param 对groupNameCh进行赋值 
	*/
	
	public void setGroupNameCh(String groupNameCh) {
		this.groupNameCh = groupNameCh;
	}
	
	/** 
	 * @return 返回 groupNameEn 
	 */
	@Column(name = "groupNameEn")
	public String getGroupNameEn() {
		return groupNameEn;
	}
	
	/** 
	* @param 对groupNameEn进行赋值 
	*/
	
	public void setGroupNameEn(String groupNameEn) {
		this.groupNameEn = groupNameEn;
	}
	
}
