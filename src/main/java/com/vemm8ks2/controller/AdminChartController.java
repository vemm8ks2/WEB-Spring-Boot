package com.vemm8ks2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.dto.request._ProductDTO;
import com.vemm8ks2.service.PythonScriptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/admin/chart")
@RequiredArgsConstructor
@Slf4j
public class AdminChartController {

  @Value("${chart.executable}")
  private String executable;

  @Value("${chart.script}")
  private String script;

  private final PythonScriptService pythonScriptService;

  @PostMapping
  public String getChart(@RequestBody String arg) {
    try {
      return pythonScriptService.executePythonScript(executable, script, arg);
    } catch (Exception e) {
      return "Error generating chart: " + e.getMessage();
    }
  }
}
