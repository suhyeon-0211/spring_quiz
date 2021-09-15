package com.quiz.lesson06.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson06.model.UrlFavorites;

@Repository
public interface UrlFavoritesDAO {
	public void insertUrlFavorites(UrlFavorites urlFavorites);
	public List<UrlFavorites> selectUrlFavorites();
	public boolean existUrlFavoritesByUrl(String url);
}
