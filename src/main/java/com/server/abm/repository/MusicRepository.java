package com.server.abm.repository;

import com.server.abm.entity.Music;
import com.server.abm.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository  extends JpaRepository<Music,String> {
    Music findMusicById(String id);
    Music findMusicByName(String name);
    List<Music> findMusicByType(Type type);
}
