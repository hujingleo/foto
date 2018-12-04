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
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 登录邮箱账号
	 */
	private String username;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String nickname;
	/**
	 * 
	 */
	private Integer gender;
	/**
	 *
	 */
	private String avatarUrl;
	/**
	 * 个人简介
	 */
	private String personalProfile;
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
	 * 设置：登录邮箱账号
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：登录邮箱账号
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}
	/**
	 * 获取：
	 */
	public int getGender() {
		return gender;
	}
	/**
	 * 设置：
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	/**
	 * 获取：
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}
	/**
	 * 设置：个人简介
	 */
	public void setPersonalProfile(String personalProfile) {
		this.personalProfile = personalProfile;
	}
	/**
	 * 获取：个人简介
	 */
	public String getPersonalProfile() {
		return personalProfile;
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

