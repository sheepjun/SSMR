package com.ssmr.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
/*
 * 기능 : 응답 공통 DTO 생성
 * 작성자: 김채연
 * 내용:
 * 비고:
 */
public class ResponseDto<T> {

    private final ResponseStatus status;
    private final String message;
    private final T data;

}
