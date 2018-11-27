package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-27 09:51:20
 */
@TableName("tb_user_data")
public class UserDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private String dataType;
	/**
	 * 
	 */
	private String dataTitle;
	/**
	 * 
	 */
	private String dataContent;
	/**
	 * 
	 */
	private Date createdTime;
	/**
	 * 
	 */
	private Date updatedTime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	/**
	 * 获取：
	 */
	public String getDataType() {
		return dataType;
	}
	/**
	 * 设置：
	 */
	public void setDataTitle(String dataTitle) {
		this.dataTitle = dataTitle;
	}
	/**
	 * 获取：
	 */
	public String getDataTitle() {
		return dataTitle;
	}
	/**
	 * 设置：
	 */
	public void setDataContent(String dataContent) {
		this.dataContent = dataContent;
	}
	/**
	 * 获取：
	 */
	public String getDataContent() {
		return dataContent;
	}
	/**
	 * 设置：
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}
}
