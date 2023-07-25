package com.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.admin.model.network.Header;

@RestController
@RequestMapping("/api") // 메서드는 똑같은 주소를 매핑시킬수 없지만 클래스는 상관없다
public class GetController {
    
    @GetMapping("/header")
    public Header getHeader() {
        return Header.builder()
        		  .resultCode("OK")
        		  .description("OK")
        		  .build();
        
    }

}
