package xyz.tangzekk.afi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @program: aopfilterinteceptor
 * @description:
 * @author: tangzekai
 * @create: 2019-04-16 13:01
 **/
@Data@Entity
public class User {
  @Id
  private Integer id;
  private String name;
}