package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.dao.SellerDAO;
import com.quiz.lesson04.model.Seller;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO;
	
	public void addSeller(String nickname, String profileImage, double temperature) {
		sellerDAO.insertSeller(nickname, profileImage, temperature);
	}
	
	public Seller getLastSeller() {
		Seller seller = sellerDAO.selectLastSeller();
//		if (seller.getProfileImage() == null) {
//			seller.setProfileImage("https://3.bp.blogspot.com/-ZKBbW7TmQD4/U6P_DTbE2MI/AAAAAAAADjg/wdhBRyLv5e8/s1600/noimg.gif");
//		}
		return seller;
	}
	
	public Seller getSellerById(int id) {
		Seller seller = sellerDAO.selectSellerById(id);
//		if (seller.getProfileImage() == null) {
//			seller.setProfileImage("https://3.bp.blogspot.com/-ZKBbW7TmQD4/U6P_DTbE2MI/AAAAAAAADjg/wdhBRyLv5e8/s1600/noimg.gif");
//		}
		return seller;
	}
}
