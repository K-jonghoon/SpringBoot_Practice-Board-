package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.min.edu.vo.PlayerVo;

@Mapper
public interface IPlayerDao {

	public List<PlayerVo> selectPlayer(Map<String, Object> map);
	
	public int cntPlayer(String team_id);
	
}
