package model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Item {

    private String name;
    private Integer price;

}
