package jp.co.siam.restapi.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = ValidationException.class)
    public ResponseResult handle(ValidationException e){
        logger.error(e.getMessage(),e);
        return new ResponseResult(ResponseCode.FAIL, e.getMessage(),null);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseResult handle(Exception e){
        logger.error(e.getMessage(),e);
        return new ResponseResult(ResponseCode.FAIL, e.getMessage(),null);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult handle2(MethodArgumentNotValidException e){
            logger.error(e.getMessage(),e);
            return new ResponseResult(ResponseCode.FAIL, e.getMessage(),null);
    }
}
