package com.server.abm.controller;

import com.server.abm.entity.Role;
import com.server.abm.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/roles")
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Role role) {
        if (roleService.getByName(role.getName()) != null) {
            return ResponseEntity.ok().body("role is ready in database!");
        } else {
            Role newRole = roleService.createRole(role);
            if (newRole == null) {
                return ResponseEntity.badRequest().body("Error !!");
            }
            return ResponseEntity.ok().body(newRole);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(roleService.getById(id));
    }

    @GetMapping("/getByName")
    public ResponseEntity<Role> getByName(@RequestParam("name") String name) {
        return ResponseEntity.ok().body(roleService.getByName(name));
    }

    @GetMapping("/getList")
    public ResponseEntity<List<Role>> getAll() {
        return ResponseEntity.ok().body(roleService.getAll());
    }
}
