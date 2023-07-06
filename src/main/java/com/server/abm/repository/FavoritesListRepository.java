package com.server.abm.repository;

import com.server.abm.entity.FavoritesList;
import com.server.abm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesListRepository extends JpaRepository<FavoritesList,Integer> {

    FavoritesList findFavoritesListById(int id);
    FavoritesList findFavoritesListByUser(User user);
}
