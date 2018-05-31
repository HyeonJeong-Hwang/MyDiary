package com.mydiary.member.vo;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {

	private int id;
	private String password;
	private String nickname;
	private String email;
	private String birthday;
	private String name;
	private String likeThing;
	private String hateThing;
	private String profileMemo;
	private String profilePicture;
	private MultipartFile file;
	
	public int getUserId() {
		return id;
	}

	public void setUserId(int userId) {
		this.id = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLikeThing() {
		return likeThing;
	}

	public void setLikeThing(String likeThing) {
		this.likeThing = likeThing;
	}

	public String getHateThing() {
		return hateThing;
	}

	public void setHateThing(String hateThing) {
		this.hateThing = hateThing;
	}

	public String getProfileMemo() {
		return profileMemo;
	}

	public void setProfileMemo(String profileMemo) {
		this.profileMemo = profileMemo;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String save() {
		if( file != null && !file.isEmpty()) {
			profilePicture = file.getOriginalFilename();
			
			File newFile = new File("d:/"+file.getOriginalFilename());
			try {
				file.transferTo(newFile);
				return newFile.getAbsolutePath();
			} catch (IllegalStateException e) {
				throw new RuntimeException(e.getMessage(), e);
				
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		return null;
	}

}
