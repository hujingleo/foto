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
@TableName("tb_push")
public class PushEntity implements Serializable {
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
	private String pushTitle;
	/**
	 * 
	 */
	private String pushContent;
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
	public void setPushTitle(String pushTitle) {
		this.pushTitle = pushTitle;
	}
	/**
	 * 获取：
	 */
	public String getPushTitle() {
		return pushTitle;
	}
	/**
	 * 设置：
	 */
	public void setPushContent(String pushContent) {
		this.pushContent = pushContent;
	}
	/**
	 * 获取：
	 */
	public String getPushContent() {
		return pushContent;
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
