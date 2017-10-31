package com.comup.personal.site.controller;

import com.comup.personal.site.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Comup
 */
@Controller
@RequestMapping("login")
public class LoginController {

    private final GitHubService gitHubService;

    @Autowired
    public LoginController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @RequestMapping("/github/callback")
    public void callback(HttpServletRequest request,HttpServletResponse response, String code, String state) throws IOException {
        response.sendRedirect("https://xlz35429674.3322.org/#/login/" + gitHubService.getToken(request,code, state));
    }
}
