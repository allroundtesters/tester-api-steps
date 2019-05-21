package io.allroundtester.chaos;

import lombok.Data;

/**
 * @author patrick
 */
@Data
public class BaseResponse<T> {
    private static  final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL" ;
    private int code;
    private String msg;
    private T data;

    public BaseResponse code(int code){
        this.code=code;
        return this;
    }

    public BaseResponse msg(String msg){
        this.msg=msg;
        return this;
    }


    public BaseResponse data(T data){
        this.data=data;
        return this;
    }

    public static <T> BaseResponse<T> builder(){
        return new BaseResponse<>();
    }

    public static BaseResponse OK(){
       return builder().code(200).msg(SUCCESS);
    }
    public static BaseResponse FAIL(){
        return builder().code(-1).msg(FAIL);
    }
}
