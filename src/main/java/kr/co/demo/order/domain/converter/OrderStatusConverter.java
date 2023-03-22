package kr.co.demo.order.domain.converter;

import kr.co.demo.order.domain.constants.OrderStatus;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter
public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {
    @Override
    public String convertToDatabaseColumn(OrderStatus attribute) {
        return Objects.isNull(attribute) ? null : attribute.getValue();
    }

    @Override
    public OrderStatus convertToEntityAttribute(String dbData) {
        return StringUtils.isEmpty(dbData) ? null : OrderStatus.find(dbData);
    }
}
