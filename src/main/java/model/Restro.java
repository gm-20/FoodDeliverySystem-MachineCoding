package model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;


@Getter
@Builder
public class Restro {

    private Integer resId;
    private Map<String,Item> items;
    private Integer noOfOrders;
    private Float rating;
}
