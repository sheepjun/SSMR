package com.ssmr.util;

/*
 * 기능 : 응답 공통 Util 생성
 * 작성자: 김채연
 * 내용: 응답 상태 -> ResponseStatus , 응답 메세지 -> message, 전해 줄 데이터 -> data
 * 비고:
 */
public class ResponseUtil {
    public static <T>ResponseDto<T> SUCCESS (String message, T data) {
        return new ResponseDto(ResponseStatus.SUCCESS, message, data);
    }
    public static <T>ResponseDto<T> FAILURE (String message, T data) {
        return new ResponseDto(ResponseStatus.FAILURE, message, data);
    }
    public static <T>ResponseDto<T> ERROR (String message, T data) {
        return new ResponseDto(ResponseStatus.ERROR, message, data);
    }
}
