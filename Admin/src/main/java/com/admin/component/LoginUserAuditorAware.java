package com.admin.component;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class LoginUserAuditorAware implements AuditorAware<String> { // 로그인한 사용자를 감시하는 역할로 사용

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Admin_Lee");
        
    } // @CreatedBy : 작성자,  @LastModifiedBy : 수정자 발생할때 Admin_Lee 이름을 반환
    
}
