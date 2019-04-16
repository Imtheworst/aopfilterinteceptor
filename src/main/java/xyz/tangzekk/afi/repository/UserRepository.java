package xyz.tangzekk.afi.repository;

import org.springframework.data.jpa.repository.*;
import xyz.tangzekk.afi.entity.User;

/**
 * @program: aopfilterinteceptor
 * @description:
 * @author: tangzekai
 * @create: 2019-04-16 13:02
 **/

public interface UserRepository extends JpaRepository<User,Integer> {

}