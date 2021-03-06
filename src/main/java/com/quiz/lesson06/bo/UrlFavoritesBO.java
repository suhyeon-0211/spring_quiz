package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.UrlFavoritesDAO;
import com.quiz.lesson06.model.UrlFavorites;

@Service
public class UrlFavoritesBO {

	@Autowired
	private UrlFavoritesDAO urlFavoritesDAO;
	
	public void addUrlFavorite(UrlFavorites urlFavorites) {
		urlFavoritesDAO.insertUrlFavorites(urlFavorites);
	}
	
	public List<UrlFavorites> getUrlFavorites() {
		return urlFavoritesDAO.selectUrlFavorites();
	}
	
	public boolean existUrlFavoritesByUrl(String url) {
		return urlFavoritesDAO.existUrlFavoritesByUrl(url);
	}
	
	public int deleteUrlFavoritesById(int id) {
		return urlFavoritesDAO.deleteUrlFavoritesById(id);
	}
}
