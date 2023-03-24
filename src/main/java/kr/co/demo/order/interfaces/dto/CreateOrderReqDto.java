package kr.co.demo.order.interfaces.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateOrderReqDto {

    private String orderAmount;
    private String customerId;

}
