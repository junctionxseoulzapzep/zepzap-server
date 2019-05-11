package com.example.zepzep.controller;

import com.example.zepzep.domain.User;
import com.example.zepzep.dto.ResponseDto;
import com.example.zepzep.dto.TokenDto;
import com.example.zepzep.dto.UserDto;
import com.example.zepzep.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/users/join")
    public ResponseDto<TokenDto> join(@RequestBody UserDto userDto){
        TokenDto tokenDto = TokenDto.of(this.userService.createUser(userDto));
        return ResponseDto.of(HttpStatus.OK,"success create user!",tokenDto);
    }

    @RequestMapping(value = "/users/{id}", method=RequestMethod.GET)
    public ResponseDto<User> getUserById(@PathVariable("id") long id){
        User user = userService.getUserById(id);
        return ResponseDto.of(HttpStatus.OK, "success get user by id", user);
    }

}
