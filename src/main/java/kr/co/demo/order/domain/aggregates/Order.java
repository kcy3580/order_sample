package kr.co.demo.order.domain.aggregates;

import kr.co.demo.order.domain.constants.OrderStatus;
import kr.co.demo.order.domain.converter.OrderStatusConverter;
import kr.co.demo.order.domain.valueobjects.Customer;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Order extends AbstractAggregateRoot<Order> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ord_id")
    private Long orderId;

    @Column(name="ord_no")
    private String orderNo;

    @Embedded
    protected Customer customer;

    //주문 상태코드 (OP: 주문 처리중, OS: 주문성공, OF: 주문실패, CP: 주문 취소 처리중, CS: 주문취소 성공, CF: 주문취소실패)
    @Column(name = "ord_st_code")
    @Convert(converter = OrderStatusConverter.class)
    protected OrderStatus status;

}
