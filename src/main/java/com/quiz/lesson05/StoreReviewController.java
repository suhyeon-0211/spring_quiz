package com.quiz.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.model.Store;
import com.quiz.lesson05.bo.ReviewBO;
import com.quiz.lesson05.model.Review;

@Controller
public class StoreReviewController {
	
	@Autowired
	private StoreBO storeBO;
	@Autowired
	private ReviewBO reviewBO;
	
	@RequestMapping("/lesson05/store_list")
	public String storeList(Model model) {
		List<Store> storeList = storeBO.getStoreList();
		model.addAttribute("storeList", storeList);
		return "lesson05/storeList";
	}
	
	@RequestMapping("/lesson05/reviews")
	public String reviewList(
			@RequestParam("storeId") int storeId,
			@RequestParam("storeName") String storeName,
			Model model) {
		List<Review> reviewList = reviewBO.getReviewByStoreId(storeId);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("storeName", storeName);
		return "lesson05/reviewList";
	}
}
