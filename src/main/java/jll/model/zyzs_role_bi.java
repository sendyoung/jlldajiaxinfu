package jll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;

/**
 * 权限表
 */

@Entity
@Table(name = "zyzs_role_bi")
public class zyzs_role_bi {
	
	/**主键id**/
	private String id;
	/**权限描述**/
	private String descpt;
	/**分类 1:为菜单   2：为按钮或页面操作**/
	private String category;
	/**URL**/
	private String url;
	
	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	@Column(name = "descpt")
	public String getDescpt() {
		return descpt;
	}
	public void setDescpt(String descpt) {
		this.descpt = descpt;
	}
	
	@Column(name = "category")
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	
}
