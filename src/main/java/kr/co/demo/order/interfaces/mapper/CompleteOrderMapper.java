package kr.co.demo.order.interfaces.mapper;

import kr.co.demo.config.MapstructConfig;
import kr.co.demo.order.domain.aggregates.Order;
import kr.co.demo.order.interfaces.dto.CompleteOrderRspDto;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfig.class)
@Slf4j
public abstract class CompleteOrderMapper {

    public abstract CompleteOrderRspDto toRspDto(Order order);

}