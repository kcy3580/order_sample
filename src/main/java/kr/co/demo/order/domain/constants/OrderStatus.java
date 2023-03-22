package kr.co.demo.order.domain.constants;

import com.google.common.collect.ImmutableMap;
import kr.co.demo.common.constants.ResultCode;
import kr.co.demo.common.exception.ApiException;
import lombok.Getter;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum OrderStatus {
    //주문처리중
    ORDER_PROGRESS("OP"),
    //주문성공
    ORDER_SUCCESS("OS"),
    //주문실패
    ORDER_FAIL("OF"),
    //주문취소 처리중
    ORDER_CANCEL_PROGRESS("CP"),
    //주문취소 성공
    ORDER_CANCEL_SUCCESS("CS"),
    //주문취소 실패
    ORDER_CANCEL_FAIL("CF"),
    ;
    //09-선계산, 10-결제 요청, 11-결제 완료, 12-결제 취소, 13-결제 취소 실패(이력)
    //14-결제 취소 부분 실패, 15-결제 실패, 16-결제 취소 처리중, 20-주문 요청, 21-주문승인
    //22-주문 취소, 23-주문 취소 실패(이력), 24-주문 매출 확정(이력)
    //25-취소 매출 확정(이력), 30-주문 완료-nonBDS, 31-제조 완료-BDS Call, 32-픽업 완료(이력)-BDS Done

    private static final ImmutableMap<String, OrderStatus> codes = ImmutableMap.copyOf(
            Stream.of(values()).collect(Collectors.toMap(OrderStatus::getValue, Function.identity())));

    @Getter
    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public static OrderStatus find(final String value) {
        if (!codes.containsKey(value)) {
            throw new ApiException(ResultCode.SERVER_ERROR);
        }
        return codes.get(value);
    }

}