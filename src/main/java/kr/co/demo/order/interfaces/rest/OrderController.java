package kr.co.demo.order.interfaces.rest;

import kr.co.demo.order.application.commandservices.OrderService;
import kr.co.demo.order.domain.aggregates.Order;
import kr.co.demo.order.domain.commands.OrderCreateCommand;
import kr.co.demo.order.interfaces.dto.CompleteOrderRspDto;
import kr.co.demo.order.interfaces.dto.CreateOrderReqDto;
import kr.co.demo.order.interfaces.dto.CreateOrderRspDto;
import kr.co.demo.order.interfaces.dto.ProcessOrderRspDto;
import kr.co.demo.order.interfaces.mapper.CompleteOrderMapper;
import kr.co.demo.order.interfaces.mapper.CreateOrderMapper;
import kr.co.demo.order.interfaces.mapper.ProcessOrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static kr.co.demo.order.constant.OrderApiUrl.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = ORDER_BASE_URL)
@Validated
@RestController
public class OrderController extends BaseController{

    private final OrderService orderService;
    private final CreateOrderMapper createOrderMapper;
    private final ProcessOrderMapper processOrderMapper;
    private final CompleteOrderMapper completeOrderMapper;

    @PostMapping(ORDER_CREATE_URL)
    public ResponseEntity<CreateOrderRspDto> createOrder(CreateOrderReqDto reqDto) {
        OrderCreateCommand command = createOrderMapper.toCommand(reqDto);
        Order order = orderService.create(command);
        CreateOrderRspDto rspDto = createOrderMapper.toRspDto(order);

        return new ResponseEntity<CreateOrderRspDto>(rspDto, getSuccessHeaders(), HttpStatus.OK);
    }

    @PutMapping(ORDER_PROCESS_URL)
    public ResponseEntity<ProcessOrderRspDto> processOrder(String orderNo) {
        Order order = orderService.process(orderNo);
        ProcessOrderRspDto rspDto = processOrderMapper.toRspDto(order);

        return new ResponseEntity<ProcessOrderRspDto>(rspDto, getSuccessHeaders(), HttpStatus.OK);
    }

    @PutMapping(ORDER_COMPLETE_URL)
    public ResponseEntity<CompleteOrderRspDto> completeOrder(String orderNo) {
        Order order = orderService.complete(orderNo);
        CompleteOrderRspDto rspDto = completeOrderMapper.toRspDto(order);

        return new ResponseEntity<CompleteOrderRspDto>(rspDto, getSuccessHeaders(), HttpStatus.OK);
    }

}
