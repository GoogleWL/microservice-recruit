package com.stalary.pf.outside.data;

import com.stalary.pf.outside.exception.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @model ResponseMessage
 * @description 返回对象
 * @field code 状态码
 * @field msg 信息
 * @field success 是否成功
 * @field data 数据
 **/
@Data
public class ResponseMessage<T> {

    private int code;

    private String msg;

    private boolean success;

    private T data;

    public ResponseMessage(int code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public ResponseMessage(int code, String msg, boolean success, T data) {
        this.code = code;
        this.msg = msg;
        this.success = success;
        this.data = data;
    }

    public ResponseMessage() {
    }

    public static ResponseMessage enumError(ResultEnum resultEnum) {
        return new ResponseMessage(resultEnum.getCode(), resultEnum.getMsg(), false);
    }

    public static ResponseMessage error(int code, String msg) {
        return new ResponseMessage<>(code, msg, false);
    }

    public static <T>ResponseMessage successMessage(T data) {
        return new ResponseMessage<>(0, "success", true, data);
    }

    public static ResponseMessage successMessage() {
        return new ResponseMessage<>(0, "success", true, null);
    }

    public static ResponseMessage failedMessage(String message) {
        return new ResponseMessage<>(1, message, false, null);
    }

    public static ResponseMessage failedMessage() {
        return new ResponseMessage<>(1, "failed", false, null);
    }

}