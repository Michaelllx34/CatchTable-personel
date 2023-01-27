package com.catchmind.catchtable.domain.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Header<T> {
    private LocalDateTime transactionTime;
    private String resultCode;  // 정상적으로 호출했는지
    private T data;
    private String description; // 에러에 대한 설명



    public static <T> Header<T> Ok(){
        return (Header<T>)Header.builder().transactionTime(LocalDateTime.now())
                .resultCode("OK").description("정상").build();
    }

    public static <T> Header<T> OK(T data){
        return (Header<T>)Header.builder().transactionTime(LocalDateTime.now()).resultCode("OK")
                .description("정상").data(data).build();
    }

    public static <T> Header<T> ERROR(String description){
        return (Header<T>)Header.builder().transactionTime(LocalDateTime.now()).resultCode("OK")
                .description("에러!").build();
    }


}
