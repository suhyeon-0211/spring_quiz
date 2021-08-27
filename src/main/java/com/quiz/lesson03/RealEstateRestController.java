package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.dao.RealEstateDAO;
import com.quiz.lesson03.model.RealEstate;

@RequestMapping("/lesson03/quiz01/")
@RestController
public class RealEstateRestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	// 요청 URL : http://localhost/lesson03/quiz01/1?id=20
	@RequestMapping("1")
	public RealEstate quiz01_1(
			@RequestParam(value="id", defaultValue = "1", required = false) int id
			) {
		return realEstateBO.getRealEstateById(id);
	}
	
	@RequestMapping("2")
	public List<RealEstate> quiz01_2(
			@RequestParam(value="rent_price", required=false) Integer rentPrice
			) {
		List<RealEstate> realEstateList = realEstateBO.getRealEstateByRentPrice(rentPrice);
		return realEstateList;
	}
	
	@RequestMapping("3")
	public List<RealEstate> quiz01_3(
			@RequestParam(value="area", defaultValue="1") int area,
			@RequestParam(value="price", defaultValue="1") int price
			) {
		List<RealEstate> realEstateList = realEstateBO.getRealEstateByAreaAndPrice(area, price);
		return realEstateList;
	}
}
