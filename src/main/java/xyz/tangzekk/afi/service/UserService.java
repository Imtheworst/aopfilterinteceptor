package xyz.tangzekk.afi.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import xyz.tangzekk.afi.KeyContent;
import xyz.tangzekk.afi.aop.Aop;
import xyz.tangzekk.afi.entity.User;
import xyz.tangzekk.afi.repository.UserRepository;

/**
 * @program: aopfilterinteceptor
 * @description:
 * @author: tangzekai
 * @create: 2019-04-16 13:03
 **/
@Service@Slf4j
public class UserService {

  @Autowired
  KeyContent keyContent;
  @Autowired
  UserRepository userRepository;

  public List<User> serviceMethodAll() {
    List<User> all = userRepository.findAll();
    return all;
  }
  @Aop(value = "serviceMethodOne--value")
  public User serviceMethodOne(Integer id) {

    log.info(keyContent.legalRid);
//    log.info(legalRid);
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("哈哈哈哈"));
    return user;
  }
}