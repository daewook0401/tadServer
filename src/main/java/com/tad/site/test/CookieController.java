package com.tad.site.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/cookie")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class CookieController {

    @GetMapping
    public ResponseEntity<String> checkCookie(HttpServletRequest request,
                                            HttpServletResponse response){
        Map<String, String> cookies = new HashMap();
        String responseStr = null;

        Cookie[] cookieArr = request.getCookies();

        if(cookieArr != null){
            Arrays.stream(cookieArr).forEach(cookie -> cookies.put(cookie.getName(), cookie.getValue()));
            System.out.println(cookies);
            responseStr = "쿠키 잘 받음";
        } else {
            responseStr = "전달받은 쿠키가 존재하지 않습니다.";
        }
        Cookie c = new Cookie("my-Cookie", "hoho");
        c.setMaxAge(60*60*24);
        response.addCookie(c);

        return ResponseEntity.ok(responseStr);
    }
}
