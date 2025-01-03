package com.vemm8ks2.service;

public interface PythonScriptService {

  public String executePythonScript(String executable, String path, String arg) throws Exception;
}
