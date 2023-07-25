package com.admin.model.network;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header<T> {
	// api 통신시간
    private LocalDateTime transactionTime; 
    
    // api 응답 코드
    private String resultCode;

    // api 부가 설명
    private String description;
    
    // 계속 바뀌는 부분
 	// Data == Body 부분
    private T data;
    
    // 정상 통신 OK
    public static <T> Header<T> OK() {
        return (Header<T>) Header.builder() // (Header<T>) 형변환
                					.transactionTime(LocalDateTime.now())
                					.resultCode("OK")
                					.description("OK")
                					.build();
        
    }

    // 데이터가 있을 때는 DATA OK
    public static <T> Header<T> OK(T data) {
        return (Header<T>) Header.builder() // (Header<T>) 형변환
        							.transactionTime(LocalDateTime.now())
        							.resultCode("DATA OK")
        							.description("DATA OK")
        							.data(data)
        							.build();
        
    }

    // 비정상 통신 ERROR
    public static <T> Header<T> ERROR(String description) {
        return (Header<T>) Header.builder() // (Header<T>) 형변환
                					.transactionTime(LocalDateTime.now())
                					.resultCode("ERROR")
                					.description(description) // 상황마다 바뀔 수 있기 때문에 변수로 받는다.
                					.build();
        
    }
    
}
