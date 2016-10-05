package com.hhit.pojo;

import org.springframework.stereotype.Component;

@Component
public class Video {
	private int Id;
	private String Name;
	private String Path;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}
}
