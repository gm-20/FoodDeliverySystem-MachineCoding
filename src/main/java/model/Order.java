package model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Builder
public class Order {

    private String orderId;
    private OrderLifeCycle status;
    private List<Item> itemList;
    private Integer orderTotal;
    private Integer restroId;

}
