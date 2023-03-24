package kr.co.demo.order.domain.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
@Builder
public class OrderCreateCommand {

    private final String orderAmount;
    private final String customerId;

}
