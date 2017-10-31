package com.comup.personal.site.service;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public interface GitHubService {
    String getToken(HttpServletRequest request,String code, String state) throws IOException;
}