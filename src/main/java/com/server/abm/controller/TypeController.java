package com.server.abm.controller;

import com.server.abm.entity.Type;
import com.server.abm.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/types")
public class TypeController {
    private final TypeService typeService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Type type) {
        Type typeCheck = typeService.getByName(type.getName());
        if (typeCheck != null) {
            return ResponseEntity.ok().body("Type is ready in database!!");
        }
        return ResponseEntity.ok().body(typeService.crate(type));
    }
}
