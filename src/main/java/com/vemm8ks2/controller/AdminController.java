package com.vemm8ks2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.dto.response.CheckAdminDTO_;
import com.vemm8ks2.dto.response.GeneralResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {


  @GetMapping
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hi Admin.");
  }

  @PostMapping("/validate")
  public ResponseEntity<GeneralResponse<CheckAdminDTO_>> isAdmin() {

    GeneralResponse<CheckAdminDTO_> response =
        new GeneralResponse<CheckAdminDTO_>("관리자 계정입니다.", new CheckAdminDTO_(true));

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

}
