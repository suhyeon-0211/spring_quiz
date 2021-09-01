package com.quiz.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerDAO {
	public void addSeller(
			@Param("nickname") String nickname, 
			@Param("profileImage") String profileImage, 
			@Param("temperature") double temperature);
}
