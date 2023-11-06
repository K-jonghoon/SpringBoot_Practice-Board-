package com.min.edu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.model.IPlayerDao;
import com.min.edu.vo.Paging_VO;
import com.min.edu.vo.PlayerVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PlayerController {

	@Autowired
	private IPlayerDao dao;
	
	@GetMapping(value = "/")
	public String home() {
		log.info("처음 호출요청");
		return "redirect:/playerList.do";
	}
	
	@GetMapping(value = "/playerList.do")
	public String playerList(
			Model model, HttpSession session,
			@RequestParam(required = false, defaultValue = "1") String page,
			String teamVal) {
		log.info("플레이어 리스트 조회");
		log.info("전달받은 team value : "+teamVal);
		Paging_VO pVo = null;
		if(session.getAttribute("row")==null) {
			pVo = new Paging_VO();
			session.setAttribute("row", pVo);
		} 
		else {
			pVo = (Paging_VO)session.getAttribute("row");
		}
		log.info("----------------현재페이지 : {}", page);
		int selectPage = Integer.parseInt(page);
		log.info("----------------선택된페이지 : {}", selectPage);
		
		pVo.setTotalCount(dao.cntPlayer(teamVal)); //총 게시물의 개수
		pVo.setCountList(10); //출력될 게시글의 개수
		pVo.setCountPage(5); // 화면에 몇 개의 페이지를 보여줄 건지 (페이지 그룹)
		pVo.setTotalPage(pVo.getTotalCount()); // 총 페이지의 개수
		pVo.setPage(selectPage); // 화면에서 선택된 페이지 번호
		pVo.setStagePage(selectPage); // 페이지 그룹의 시작 번호
		pVo.setEndPage(pVo.getCountPage()); // 끝 번호
		
		Map<String, Object> map = new HashMap<String, Object>();
		//페이징처리된 결과를 가지고 옴
		// 현재 페이지 * 한 페이지의 글 개수 row - (한 페이지의 글 개수 row -1) : 1*5 - (5-1) = 1
		map.put("first", pVo.getPage()*pVo.getCountList()-(pVo.getCountList()-1));
		// 현재 페이지 * 한 페이지의 글 개수 row
		map.put("last", pVo.getPage()*pVo.getCountList());
		if(teamVal != null) {
			map.put("team_id",teamVal);
			model.addAttribute("teamVal", teamVal);
		}
		
		List<PlayerVo> lists = dao.selectPlayer(map);
		model.addAttribute("lists", lists);
		model.addAttribute("page", pVo);
		return "playerList";
	}
	
//	@PostMapping(value = "/teamSearch.do")
//	@ResponseBody
//	public String searchTeam(String teamVal) {
//		log.info("ajax 요청 : "+teamVal);
//		
//		return "redirect:/playerList.do";
//	}
	
}
