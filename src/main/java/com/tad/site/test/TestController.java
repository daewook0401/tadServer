package com.tad.site.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tad.site.util.responseType.Body;
import com.tad.site.util.responseType.Header;
import com.tad.site.util.responseType.ResponseWrapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/users")
    public ResponseEntity<ResponseWrapper<UserTestDto>> getMethodName(@RequestParam(name = "param", required = false) String param) {
        List<UserTestDto> users = IntStream.range(1, 6)
                .mapToObj(i -> new UserTestDto((long) i, "User" + i, "user" + i + "@mail.com", LocalDate.now()))
                .toList();
        return ResponseEntity.ok(new ResponseWrapper<>(
                new Header(0, "사용자 테스트 데이터입니다."),
                new Body<>(users, users.size())
        ));
    }
    @PostMapping("/users")
    public ResponseWrapper<UserTestDto> getMethodName2() {
        List<UserTestDto> users = IntStream.range(1, 12)
                .mapToObj(i -> new UserTestDto((long) i, "User" + i, "user" + i + "@mail.com", LocalDate.now()))
                .toList();

        return new ResponseWrapper<>(
                new Header(0, "사용자 테스트 데이터입니다."),
                new Body<>(users, users.size())
        );
    }
    
}
