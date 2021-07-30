package model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Customer {


    private String cId;
    private String name;
    private List<Item> itemList;
    private String orderId;

}
