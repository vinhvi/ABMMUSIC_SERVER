package com.server.abm.service;

import com.server.abm.entity.Music;
import com.server.abm.entity.Type;

import java.util.List;

public interface MusicService {
    Music createOrUpdate(Music music);
    Music getByName(String name);
    Music getById(String id);
    List<Music> getByType(Type type);
    String randomId();
}
