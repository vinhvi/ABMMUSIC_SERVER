package com.server.abm.serviceImpl;

import com.server.abm.entity.Music;
import com.server.abm.entity.Type;
import com.server.abm.repository.MusicRepository;
import com.server.abm.service.MusicService;
import com.server.abm.service.TypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MusicServiceImpl implements MusicService {
    private final MusicRepository musicRepository;

    @Override
    public Music createOrUpdate(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public Music getByName(String name) {
        return musicRepository.findMusicByName(name);
    }

    @Override
    public Music getById(String id) {
        return musicRepository.findMusicById(id);
    }

    @Override
    public List<Music> getByType(Type type) {
        return musicRepository.findMusicByType(type);
    }

    @Override
    public String randomId() {
        Random random = new Random();
        String id = "";
        boolean check = false;
        int attempts = 0;
        int maxAttempts = 10000; // set a maximum number of attempts to prevent infinite loop
        while (!check && attempts < maxAttempts) {
            int number = random.nextInt(10000);
            id = "MU" + String.format("%04d", number);
            if (musicRepository.findMusicById(id) == null) {
                check = true;
            }
            attempts++;
        }
        if (!check) {
            throw new RuntimeException("Unable to generate a unique ID after " + maxAttempts + " attempts.");
        }
        return id;
    }
}
