package com.server.abm.service;

import com.server.abm.entity.Image;

public interface ImageService {
    Image addImage(Image image);
    void delete(String id);
    Image getById(String id);
    boolean check(String id);
}
