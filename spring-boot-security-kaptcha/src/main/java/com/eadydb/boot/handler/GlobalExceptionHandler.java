package com.eadydb.boot.handler;

import com.eadydb.boot.vo.ArgumentInvalid;
import com.eadydb.boot.vo.ErrorCode;
import com.eadydb.boot.vo.ResultMsg;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
* @Author eadydb {dengbin1201@163.com}
* @Date 17-5-6 上午10:13
* <p>
* @Description 全局异常处理
**/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {


    /**
     * 参数校验异常
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object methodArgumentNotValidHandler(HttpServletRequest request, MethodArgumentNotValidException ex){

        List<ArgumentInvalid> argumentInvalids = new ArrayList<>();

        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for(FieldError err : ex.getBindingResult().getFieldErrors()){
            ArgumentInvalid invalid = new ArgumentInvalid();
            invalid.setField(err.getField());
            invalid.setMessage(err.getDefaultMessage());
            invalid.setRejectedValue(err.getRejectedValue());
            argumentInvalids.add(invalid);
        }
        ResultMsg resultMsg = new ResultMsg(ErrorCode.ARGUMENT_INVALID_ERROR.getCode(),ErrorCode.ARGUMENT_INVALID_ERROR.getError(),argumentInvalids);
        return resultMsg;
    }


    // TODO 其他异常处理
}
