/*
 * You are strictly prohibited to copy, disclose, distribute, modify, or use this program in part
 * or as a whole without the prior written consent of Starbucks Coffee Company.
 * Starbucks Coffee Company owns the intellectual property rights in and to this program.
 *
 * (Copyright (c) 2022 Starbucks Coffee Company. All Rights Reserved | Confidential)
 */

package kr.co.demo.common.exception;

import kr.co.demo.common.constants.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static kr.co.demo.common.constants.StaticValues.RESULT_CODE;
import static kr.co.demo.common.constants.StaticValues.RESULT_MESSAGE;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private HttpHeaders setHeaders(String resultCode, String resultMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(RESULT_CODE, resultCode);
        headers.add(RESULT_MESSAGE, resultMessage);

        return headers;
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Object> handle(Exception ex, WebRequest req) {
        ResultCode resultCode = ResultCode.SERVER_ERROR;
        HttpHeaders headers = setHeaders(resultCode.getCode(), resultCode.getUrlEncodingMessage());

        log.error("Exception", ex);

        return new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<Object> handle(ApiException ex, WebRequest req) {
        String encodedResultMessage = URLEncoder.encode(ex.getResultMessage(), StandardCharsets.UTF_8);

        HttpHeaders headers = setHeaders(ex.getResultCode(), encodedResultMessage);

        log.error("ApiException Code ={}, Message={}, HttpStatus={} Exception={}",
                ex.getResultCode(),
                ex.getResultMessage(),
                ex.getHttpStatus(),
                ExceptionUtils.getStackTrace(ex));

        return new ResponseEntity<>(headers,ex.getHttpStatus());
    }

}