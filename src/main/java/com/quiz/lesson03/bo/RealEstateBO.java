package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.RealEstateDAO;
import com.quiz.lesson03.model.RealEstate;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateDAO realEstateDAO;
	
	public RealEstate getRealEstateById(int id) {
		return realEstateDAO.selectRealEstateById(id);
	}
	
	public List<RealEstate> getRealEstateByRentPrice(Integer rentPrice) {
		List<RealEstate> realEstateList = realEstateDAO.selectRealEstateByRentPrice(rentPrice);
		return realEstateList;
	}
	
	public List<RealEstate> getRealEstateByAreaAndPrice(int area, int price) {
		List<RealEstate> realEstateList = realEstateDAO.selectRealEstateByAreaAndPrice(area, price);
		return realEstateList;
	}
	
	public int addRealEstate(RealEstate realEstate) {
		return realEstateDAO.insertRealEstate(realEstate);
	}
	
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price, Integer rentPrice) {
		return realEstateDAO.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	public int updateRealEstate(int id, String type, int price) {
		return realEstateDAO.updateRealEstate(id, type, price);
	}
	
	public int deleteRealEstateById(int id) {
		return realEstateDAO.deleteRealEstateById(id);
	}
}
