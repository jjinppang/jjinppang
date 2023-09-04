package org.jjinppang.jjinppang.api.dummy.controller;


import lombok.RequiredArgsConstructor;
import org.jjinppang.jjinppang.common.NotFoundException;
import org.jjinppang.jjinppang.common.response.ApiResponse;
import org.jjinppang.jjinppang.domain.user.User;
import org.jjinppang.jjinppang.domain.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DummyController {

    private final UserRepository userRepository;

    @GetMapping("/dummy")
    public ApiResponse<String> dummy() {
        return ApiResponse.createSuccess("dummy success");
    }
}
