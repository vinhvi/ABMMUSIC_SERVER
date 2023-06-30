package com.server.abm.controller;

import com.server.abm.entity.Music;
import com.server.abm.entity.Type;
import com.server.abm.service.MusicService;
import com.server.abm.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/musics")
public class MusicController {
    private final MusicService musicService;
    private final TypeService typeService;

    @PostMapping("/createOrUpdate")
    public ResponseEntity<?> createOrUpdate(@RequestBody Music music) {
        return ResponseEntity.ok().body(musicService.createOrUpdate(music));
    }

    @GetMapping("/randomId")
    public ResponseEntity<?> randomId() {
        return ResponseEntity.ok().body(musicService.randomId());
    }

    @GetMapping("/getByType")
    public ResponseEntity<?> getByType(@RequestBody String typeName) {
        Type type = typeService.getByName(typeName);
        if (type!=null){
            List<Music> musicList = musicService.getByType(type);
            if (musicList != null) {
                return ResponseEntity.ok().body(musicList);
            }
        }
        return ResponseEntity.badRequest().body("not found!!");
    }
}
