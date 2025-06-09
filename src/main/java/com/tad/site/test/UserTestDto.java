package com.tad.site.test;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTestDto {
    private Long userId;
    private String userName;
    private String email;
    private LocalDate joinedDate;
}

