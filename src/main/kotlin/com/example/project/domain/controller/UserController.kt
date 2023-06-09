package com.example.project.domain.controller

import com.example.project.domain.form.UserForm
import com.example.project.domain.service.UserService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
class UserController(private val userService: UserService) {
  /**
   * 新規登録API
   */
  @PostMapping("/signup")
  fun signup(@RequestBody userForm: UserForm) {
    userService.createUser(userForm)
  }
}