package com.quiz.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.bo.WeatherHistoryBO;
import com.quiz.lesson05.model.WeatherHistory;

@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// 요청 URL : http://localhost:8080/lesson05/weather_history
	@RequestMapping("/lesson05/weather_history")
	public String weatherHistory(Model model) {
		List<WeatherHistory> weatherList = weatherHistoryBO.getWeatherHistory();
		model.addAttribute("weatherList", weatherList);
		return "lesson05/weatherHistory";
	}
	
	// 요청 URL : http://localhost:8080/lesson05/weather_input
	@RequestMapping("lesson05/weather_input")
	public String weatherInput() {
		return "lesson05/weatherInput";
	}
	
	// 요청 URL : http://localhost:8080/lesson05/input
	@PostMapping("/lesson05/input")
	public String input(
			@ModelAttribute WeatherHistory weatherHistory) {
		weatherHistoryBO.addWeatherHistory(weatherHistory);
		return "redirect:/lesson05/weather_history";
	}
}
