package com.min.edu;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.min.edu.model.IPlayerDao;
import com.min.edu.vo.PlayerVo;

@SpringBootTest
class PracticeSpringBootApplicationTests {

	@Autowired
	private IPlayerDao mapper;
	
	@Test
	public void contextLoads() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first", 1);
		map.put("last", 10);
//		map.put("team_id", "K01");
		
		List<PlayerVo> lists = mapper.selectPlayer(map);
		System.out.println(lists);
		assertNotNull(lists);
	
		String team_id=null;
		int n = mapper.cntPlayer(team_id);
		System.out.println(n);
	}

}
