package kr.co.demo.order.interfaces.mapper;

import kr.co.demo.config.MapstructConfig;
import kr.co.demo.order.domain.aggregates.Order;
import kr.co.demo.order.domain.commands.OrderCreateCommand;
import kr.co.demo.order.interfaces.dto.CreateOrderReqDto;
import kr.co.demo.order.interfaces.dto.CreateOrderRspDto;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfig.class)
@Slf4j
public abstract class CreateOrderMapper {

    public abstract OrderCreateCommand toCommand(CreateOrderReqDto reqDto);

    public abstract CreateOrderRspDto toRspDto(Order order);

}