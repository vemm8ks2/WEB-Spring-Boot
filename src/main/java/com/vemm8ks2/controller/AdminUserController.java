package com.vemm8ks2.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.dto.SuccessResponse;
import com.vemm8ks2.model.Users;
import com.vemm8ks2.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/user")
@RequiredArgsConstructor
public class AdminUserController {

  private final UserService userService;

  @GetMapping
  public ResponseEntity<SuccessResponse<Page<Users>>> getAllUser(
      @RequestParam(defaultValue = "0", name = "page") int page,
      @RequestParam(defaultValue = "10", name = "size") int size) {

    Page<Users> users = userService.getAllUser(page, size);

    String msg = "page: " + page + " | size : " + size + " | 유저 데이터를 가져왔습니다.";
    SuccessResponse<Page<Users>> response = new SuccessResponse<Page<Users>>(msg, users);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
