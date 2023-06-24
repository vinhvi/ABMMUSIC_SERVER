package com.server.abm.serviceImpl;

import com.server.abm.entity.Image;
import com.server.abm.repository.ImageRepository;
import com.server.abm.service.ImageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void delete(String id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Image getById(String id) {
        return imageRepository.findImageById(id);
    }

    @Override
    public boolean check(String id) {
        return imageRepository.existsById(id);
    }
}
