package com.spring.boot.development.project.controller;


import com.spring.boot.development.project.dao.UserDao;
import com.spring.boot.development.project.dto.RoleDto;
import com.spring.boot.development.sa.models.User;
import com.spring.boot.development.sa.payload.response.CurrentUser;
import com.spring.boot.development.sa.payload.response.MessageResponse;
import com.spring.boot.development.sa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserDao userDao;

    @RequestMapping(value = "/getAllRoles", method = RequestMethod.POST)
    public ResponseEntity<?> getAllRoles(@RequestBody User user) {
//    public List<RoleDto> getAllRoles(Long id) {
        List<RoleDto> roles = userDao.getAllRoles(user.getUserId());
        return ResponseEntity.ok(new MessageResponse(roles));
    }

    @RequestMapping(value = "/getAssignedRoles", method = RequestMethod.POST)
    public ResponseEntity<?> getAssignedRoles(@RequestBody User user) {
        List<RoleDto> roles = userDao.getAssignedRoles(user.getUserId());
        return ResponseEntity.ok(new MessageResponse(roles));
    }

    @GetMapping("/userList")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<User> userList(HttpServletRequest request) {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        List<User> users = userRepository.findAll();
//        List<User> users = userDao.getAllUser();
        return users;
    }

/*
@DeleteMapping(value = "deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable Integer id) {
        return bookingService.deleteById(id);
    }*/

    @PostMapping("/deleteUser")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
//        User user = new User();
//        user.setId(id);p
        userRepository.deleteById(user.getUserId());
        return ResponseEntity.ok(new MessageResponse("Deleted successfully!"));
    }
}
