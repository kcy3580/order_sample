package kr.co.demo.order.interfaces.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static kr.co.demo.order.constant.OrderApiUrl.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = ORDER_BASE_URL)
@Validated
@RestController
public class OrderController {

    @PostMapping(ORDER_CREATE_URL)
    public ResponseEntity<Object> createOrder() {
        return null;
    }

    @PostMapping(ORDER_PROCESS_URL)
    public ResponseEntity<Object> processOrder() {
        return null;
    }

    @PostMapping(ORDER_COMPLETE_URL)
    public ResponseEntity<Object> completeOrder() {
        return null;
    }

}
