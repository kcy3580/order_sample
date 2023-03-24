package kr.co.demo.order.constant;

public class OrderApiUrl {

    private OrderApiUrl(){}

    /** Order 기본 URL */
    public static final String ORDER_BASE_URL = "/order/v1.0";

    /** 주문 생성 */
    public static final String ORDER_CREATE_URL = "/orders";

    /** 주문 진행 */
    public static final String ORDER_PROCESS_URL = "/orders";

    /** 주문 완료 */
    public static final String ORDER_COMPLETE_URL = "/orders";

}