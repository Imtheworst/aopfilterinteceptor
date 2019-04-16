package xyz.tangzekk.afi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import xyz.tangzekk.afi.aop.Inc;
import xyz.tangzekk.afi.entity.User;
import xyz.tangzekk.afi.service.UserService;

/**
 * @program: aopfilterinteceptor
 * @description:
 * @author: tangzekai
 * @create: 2019-04-16 11:34
 **/
@RestController
public class TestController {

  @Autowired
  UserService userService;

  @GetMapping("all")
  public List<User> webMethodAll() {
    return userService.serviceMethodAll();
  }
  @Inc(value = "webMethodAll--value")
  @GetMapping("/id/{id}")
  public User webMethodAll(@PathVariable Integer id) {
    return userService.serviceMethodOne(id);
  }

}