package xyz.tangzekk.afi;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

/**
 * @program: aopfilterinteceptor
 * @description:
 * @author: tangzekai
 * @create: 2019-04-16 14:39
 **/
@PropertySource("classpath:prop.properties")
@Component
public class KeyContent {

  @Value("${legal.rid}")

  public String legalRid;
  @Value("${legal.sid}")

  public String legalSid;
  @Value("${person.rid}")

  public String personRid;
  @Value("${person.sid}")

  public String personSid;
  @Value("${person.key}")

  public String persongKey;
  @Value("${legal.key}")

  public String legalKey;


}