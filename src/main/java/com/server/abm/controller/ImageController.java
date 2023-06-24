package com.server.abm.controller;

import com.server.abm.entity.Image;
import com.server.abm.service.CloudinaryService;
import com.server.abm.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {

    private final CloudinaryService cloudinaryService;
    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestBody MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null) {
            return ResponseEntity.badRequest().body("Error !!");
        }
        Map result = cloudinaryService.upload(multipartFile);
        Image image = new Image();
        image.setName((String) result.get("original_filename"));
        image.setImageUrl((String) result.get("url"));
        image.setId((String) result.get("public_id"));
        return ResponseEntity.ok().body(imageService.addImage(image));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) throws IOException {
        if (!imageService.check(id)) {
            return ResponseEntity.badRequest().body("Image not found !!");
        }
        Image image = imageService.getById(id);
        Map result = cloudinaryService.delete(image.getId());
        imageService.delete(id);
        return ResponseEntity.ok().body(result);
    }

}
