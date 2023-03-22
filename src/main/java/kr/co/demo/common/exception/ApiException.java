/*
 * You are strictly prohibited to copy, disclose, distribute, modify, or use this program in part
 * or as a whole without the prior written consent of Starbucks Coffee Company.
 * Starbucks Coffee Company owns the intellectual property rights in and to this program.
 *
 * (Copyright (c) 2022 Starbucks Coffee Company. All Rights Reserved | Confidential)
 */

package kr.co.demo.common.exception;

import kr.co.demo.common.constants.ResultCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    @Getter
    private final String resultCode;
    @Getter
    private final String resultMessage;
    @Getter
    private final HttpStatus httpStatus;

    public ApiException(ResultCode resultCode) {
        super("[" + resultCode + "] " + resultCode.getMessage());
        this.resultCode = resultCode.getCode();
        this.resultMessage = resultCode.getMessage();
        this.httpStatus = resultCode.getHttpStatus();
    }

}