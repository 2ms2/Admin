package com.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // 이 페이지는 설정 파일에 대한것이 들어간다
@EnableJpaAuditing // JPA에 대해서 감시를 활성시키겠다.
public class JpaConfig {

}
