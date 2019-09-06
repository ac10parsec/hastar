package io.github.hastar.harin;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import io.github.hastar.VO.PostVO;

@Controller
public class HarinController {
	
	@Autowired
	BoardService bsi;
	
	@GetMapping("/test")
	public String test() {
		return "first";
	}
	
	@GetMapping("/board")
	public String boardTest(HttpSession session) {
		if(session.getAttribute("id")==null) {
			System.out.println("사용자의 아이디 값이 없습니다.");
			return "redirect:/test";
		}
		return "board/board";
	}
	
	@GetMapping("/view/{numb}")
	public String viewDetail(@PathVariable String numb) {
		System.out.println("상세보기 No : "+numb);
		return "board/boardDetail";
	}
	
	@GetMapping("/createBoard")
	public String createNewBoard(HttpSession session) {
		if(session.getAttribute("id")==null) {
			System.out.println("사용자의 아이디 값이 없습니다.");
			return "redirect:/board";
		}
		return "board/boardNew";
	}
	
	@PostMapping("/uploads")
	public String uploadNewData(@Valid PostVO pv,@RequestParam("file")MultipartFile[] files,HttpSession session){
		System.out.println("PostVO : "+pv);
		bsi.setNewData(pv,session);
		return "redirect:/board";
	}
}
