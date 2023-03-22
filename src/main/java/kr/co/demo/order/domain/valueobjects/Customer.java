package kr.co.demo.order.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 고객 정보
 * */
@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class Customer {
    // 고객 아이디(userId)
    @Column(name = "cust_id")
    protected String customerId;
    // 고객명
    @Column(name = "cust_nm")
    protected String customerName;
    // 고객휴대폰 번호
    @Column(name = "cust_cpno", length = 2000)
    protected String customerMobileNumber;

}
