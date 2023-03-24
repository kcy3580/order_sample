package kr.co.demo.order.application.commandservices;

import kr.co.demo.order.domain.aggregates.Order;
import kr.co.demo.order.domain.commands.OrderCreateCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    /**
     * 주문을 생성한다.
     * @param command
     */
    public Order create(OrderCreateCommand command){

        return null;
    }

    /**
     * 주문을 진행한다.
     */
    public Order process(String orderNo){

        return null;
    }

    /**
     * 주문을 완료한다.
     */
    public Order complete(String orderNo){
        return null;
    }

}
