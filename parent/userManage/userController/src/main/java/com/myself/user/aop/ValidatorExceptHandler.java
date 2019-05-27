package com.myself.user.aop;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myself.user.constant.CodeConstant;
import com.myself.user.vo.resp.BaseResponse;

@ControllerAdvice
@Component
public class ValidatorExceptHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResponse handle(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        if(null == message || "".equals(message)){
        	message = CodeConstant.ERRORCODE1;
        }
        return BaseResponse.getBaseResponse( message);
    }
}
