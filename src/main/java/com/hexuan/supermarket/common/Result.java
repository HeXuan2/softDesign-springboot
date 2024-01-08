package com.hexuan.supermarket.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author hexuan
 * @Date 2023/9/4 12:43
 * @PackageName:com.hexuan.common
 * @ClassName: Result
 * @Description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;
    private String message;
    private T data;
    public static <T> Result<T> success(){
        return new Result<>(Code.SUCCESS_CODE, Code.SUCCESS_MESSAGE,null);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(Code.SUCCESS_CODE,Code.SUCCESS_MESSAGE,data);
    }

    public static <T> Result<T> success(T data,String message){
        return new Result<>(Code.SUCCESS_CODE,message,data);
    }

    public static <T> Result<T> success(String message){
        return new Result<>(Code.SUCCESS_CODE,message,null);
    }

    public static<T>  Result<T> fail(){
        return new Result<>(Code.FAIL_CODE,Code.FAIL_MESSAGE,null);
    }

    public static<T>  Result<T> fail(Integer code){
        return new Result<>(code,Code.FAIL_MESSAGE,null);
    }

    public static<T>  Result<T> fail(Integer code, String message){
        return new Result<>(code,message,null);
    }

    public static<T>  Result<T> fail( String message){
        return new Result<>(Code.FAIL_CODE,message,null);
    }

}
