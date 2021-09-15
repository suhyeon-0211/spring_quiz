package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.UrlFavoritesBO;
import com.quiz.lesson06.model.UrlFavorites;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Quiz01Controller {
	
	// submit : @Controller -> view 리턴(화면으로 보낸다.)
	// ajax : @Controller + @ResponseBody -> String, JSON (데이터만 보낸다.)

	@Autowired
	private UrlFavoritesBO urlFavoritesBO;
	
	@RequestMapping("/quiz01/add_url_favorite")
	public String addUrlFavorite() {
		return "lesson06/addUrlFavorite";
	}
	
	@ResponseBody
	@PostMapping("/quiz01/add_url")
	public Map<String, String> addUrl(
			@ModelAttribute UrlFavorites urlFavorites) {
		// DB INSERT
		urlFavoritesBO.addUrlFavorite(urlFavorites);
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		return result;
	}
	
	@RequestMapping("/quiz01/after_add_url")
	public String affterAddUrl(Model model) {
		List<UrlFavorites> urlFavoritesList = urlFavoritesBO.getUrlFavorites();
		model.addAttribute("urlFavorites", urlFavoritesList);
		return "lesson06/afterAddUrl";
	}
	
	@ResponseBody
	@RequestMapping("/quiz02/is_duplication")
	public Map<String, Boolean> isDuplication(
			@RequestParam("url") String url) {
		
		Map<String, Boolean> result = new HashMap<>();
		result.put("isDuplication", urlFavoritesBO.existUrlFavoritesByUrl(url));
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/quiz02/delete_url_favorite")
	public Map<String, Integer> isDeleted(
			@RequestParam("id") int id) {
		
		Map<String, Integer> result = new HashMap<>();
		result.put("deleted", urlFavoritesBO.deleteUrlFavoritesById(id));
		return result;
	}
}
