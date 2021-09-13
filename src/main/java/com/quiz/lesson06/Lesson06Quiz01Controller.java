package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.UrlFavoritesBO;
import com.quiz.lesson06.model.UrlFavorites;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {

	@Autowired
	private UrlFavoritesBO urlFavoritesBO;
	
	@RequestMapping("/add_url_favorite")
	public String addUrlFavorite() {
		return "lesson06/addUrlFavorite";
	}
	
	@ResponseBody
	@PostMapping("/add_url")
	public String addUrl(
			@ModelAttribute UrlFavorites urlFavorites) {
		urlFavoritesBO.addUrlFavorite(urlFavorites);
		return "success";
	}
	
	@RequestMapping("/after_add_url")
	public String affterAddUrl(Model model) {
		List<UrlFavorites> urlFavoritesList = urlFavoritesBO.getUrlFavorites();
		model.addAttribute("urlFavorites", urlFavoritesList);
		return "lesson06/afterAddUrl";
	}
}
