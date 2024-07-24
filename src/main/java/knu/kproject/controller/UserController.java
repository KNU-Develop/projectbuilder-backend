package knu.kproject.controller;

import knu.kproject.dto.UserDto.UserDto;
import knu.kproject.global.code.ApiResponse;
import knu.kproject.entity.User;
import knu.kproject.global.code.SuccessCode;
import knu.kproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    //내 정보 조회
    @GetMapping
    public ResponseEntity<?> getUserInfo() {
        User user = userService.getMyInfo();
        ApiResponse<User> response = ApiResponse.<User>builder()
                .code(SuccessCode.SELECT_SUCCESS.getStatus())
                .msg(SuccessCode.SELECT_SUCCESS.getMessage())
                .result(user)
                .build();
        return ResponseEntity.ok().body(response);
    }
    //내 정보 수정
    @PutMapping
    public ResponseEntity<?> updateUserInfo(@RequestBody UserDto userDto) {
        User user = userService.updateMyInfo(userDto);
        ApiResponse<User> response = ApiResponse.<User>builder()
                .code(SuccessCode.UPDATE_SUCCESS.getStatus())
                .msg(SuccessCode.UPDATE_SUCCESS.getMessage())
                .result(user)
                .build();
        return ResponseEntity.ok().body(response);
    }
}
