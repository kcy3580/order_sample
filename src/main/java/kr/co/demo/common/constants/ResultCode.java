package kr.co.demo.common.constants;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 앱연동 응답 규격
 * */
@Getter
public enum ResultCode {

    /** 공통 */
    SUCCESS("0000","정상", HttpStatus.OK),
    SERVER_ERROR("9999","서버에러가 발생했습니다. 잠시 후 다시 요청해주세요", HttpStatus.OK),
    ;
    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ResultCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getUrlEncodingMessage(){
        return URLEncoder.encode(this.message, StandardCharsets.UTF_8);
    }

}