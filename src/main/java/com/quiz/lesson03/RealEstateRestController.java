package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.model.RealEstate;

@RequestMapping("/lesson03/")
@RestController
public class RealEstateRestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	// 요청 URL : http://localhost/lesson03/quiz01/1?id=20
	@RequestMapping("quiz01/1")
	public RealEstate quiz01_1(
			@RequestParam(value="id", defaultValue = "1", required = false) int id
			) {
		return realEstateBO.getRealEstateById(id);
	}
	
	@RequestMapping("quiz01/2")
	public List<RealEstate> quiz01_2(
			@RequestParam(value="rent_price", required=false) Integer rentPrice
			) {
		List<RealEstate> realEstateList = realEstateBO.getRealEstateByRentPrice(rentPrice);
		return realEstateList;
	}
	
	@RequestMapping("quiz01/3")
	public List<RealEstate> quiz01_3(
			@RequestParam(value="area", defaultValue="1") int area,
			@RequestParam(value="price", defaultValue="1") int price
			) {
		List<RealEstate> realEstateList = realEstateBO.getRealEstateByAreaAndPrice(area, price);
		return realEstateList;
	}
	
	// 요청 URL : http://localhost/lesson03/quiz02/1
	@RequestMapping("quiz02/1")
	public String quiz02_1() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		int rowCount = realEstateBO.addRealEstate(realEstate);
		return "입력 성공 : " + rowCount;
	}
	
	// 요청 URL : http://localhost/lesson03/quiz02/2?realtor_id=5
	@RequestMapping("quiz02/2")
	public String quiz02_2(
			@RequestParam(value="realtor_id") int realtorId
			) {
		int rowCount = realEstateBO.addRealEstateAsField(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 성공 : " + rowCount;
	}
	
	// 요청 URL : http://localhost/lesson03/quiz03/1?id=8&...
	@RequestMapping("quiz03/1")
	public String quiz03_1(
			@RequestParam("id") int id,
			@RequestParam(value="type", defaultValue = "전세") String type,
			@RequestParam(value="price", defaultValue="70000") int price) {
		int rowCount = realEstateBO.updateRealEstate(id, type, price);
		return "수정 성공 : " + rowCount;
	}
}
