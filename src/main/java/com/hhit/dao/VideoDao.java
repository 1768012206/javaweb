package com.hhit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.hhit.pojo.Video;

@Repository
public interface VideoDao {
	@Insert("insert into video values(#{0},#{1},#{2})")
	public void insertVideo(int id, String name, String path);
	
	@Select("select * from video")
	public List<Video> getAllVideo();
}
