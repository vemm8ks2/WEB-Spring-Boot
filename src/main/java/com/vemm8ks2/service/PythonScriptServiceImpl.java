package com.vemm8ks2.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.stereotype.Service;

@Service
public class PythonScriptServiceImpl implements PythonScriptService {

  @Override
  public String executePythonScript(String executable, String path, String arg) throws Exception {

    String[] command = {executable, path, arg};

    ProcessBuilder processBuilder = new ProcessBuilder(command);

    processBuilder.redirectErrorStream(true); // 에러 스트림과 표준 스트림을 합침

    Process process = processBuilder.start(); // 프로세스 실행

    // 파이썬 스크립트의 출력을 읽음
    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

    StringBuilder output = new StringBuilder();
    String line;

    while ((line = reader.readLine()) != null) {
      output.append(line).append("\n");
    }

    process.waitFor(); // 프로세스 종료 대기

    return output.toString(); // 파이썬 스크립트의 출력 결과 (SVG 태그)
  }

}
