package com.server.abm.controller;

import com.server.abm.entity.User;
import com.server.abm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/")
public class UserController {

    private final UserService userService;

    @PostMapping("auth/users/add")
    public ResponseEntity<?> addMember(@RequestBody User user) {
        if (userService.getByEmail(user.getEmail()) != null || userService.getByPhone(user.getPhone()) != null) {
            return ResponseEntity.badRequest().body("email or phone is ready !!");
        }
        return ResponseEntity.ok().body(userService.saveOrUpdate(user));
    }

    @GetMapping("auth/users/randomId")
    public ResponseEntity<String> randomIdCustomer() {
        return ResponseEntity.ok().body(userService.randomId());
    }

    @GetMapping("users/getListUser")
    public ResponseEntity<?> getListCustomer() {
        List<User> customerList = userService.getAllUser();
        if (customerList != null) {
            return ResponseEntity.ok().body(customerList);
        } else {
            return ResponseEntity.badRequest().body("Error !!");
        }
    }

}
