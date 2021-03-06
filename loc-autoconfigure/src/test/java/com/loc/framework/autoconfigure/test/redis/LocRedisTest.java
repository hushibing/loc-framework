package com.loc.framework.autoconfigure.test.redis;

import static org.assertj.core.api.Assertions.assertThat;

import com.loc.framework.autoconfigure.redis.RedisCacheAutoConfiguration;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created on 2017/12/19.
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@DirtiesContext
public class LocRedisTest {

  @Autowired
  private RedisCacheManager redisCacheManager;

  @Test
  public void testRedisCacheConfiguration() {
    assertThat(redisCacheManager).isNotNull();
  }


  @Target(ElementType.TYPE)
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  @Configuration
  @Import({
      ServletWebServerFactoryAutoConfiguration.class,
      JacksonAutoConfiguration.class,
      RedisAutoConfiguration.class,
      RedisCacheAutoConfiguration.class
  })
  protected @interface MinimalWebConfiguration {

  }
}
