package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;

@Controller
public class SellerController {

	@Autowired
	private SellerBO sellerBO;
	
	// 요청 URL : http://localhost/lesson04/quiz01/1
	@RequestMapping("/lesson04/quiz01/1")
	public String quiz01_1() {
		return "lesson04/addSeller";
	}
	
	@PostMapping("/lesson04/quiz01/add_seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value="profileImage", required = false) String profileImage,
			@RequestParam(value="temperature", defaultValue = "36.5") double temperature) {
		sellerBO.addSeller(nickname, profileImage, temperature);
		return "lesson04/afterAddSeller";
	}
}
