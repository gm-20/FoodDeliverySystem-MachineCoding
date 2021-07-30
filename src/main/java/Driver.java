import model.Customer;
import model.Item;
import services.CustomerManager;
import services.RestroManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {

    public static void main(String[] args) {


        RestroManager restroManager = new RestroManager();

        //Adding Restro
        Map<String,Item> itemList = new HashMap<>();
        itemList.put("IDLI",Item.builder().name("IDLI").price(20).build());
        itemList.put("DOSA",Item.builder().name("DOSA").price(50).build());
        restroManager.createRestro(1,itemList);


        itemList = new HashMap<>();
        itemList.put("CHICKEN",Item.builder().name("CHICKEN").price(20).build());
        itemList.put("FISH",Item.builder().name("FISH").price(50).build());
        restroManager.createRestro(2,itemList);


        itemList = new HashMap<>();
        itemList.put("RICE",Item.builder().name("RICE").price(20).build());
        itemList.put("DAL",Item.builder().name("DAL").price(50).build());
        restroManager.createRestro(3,itemList);



        //Customer ordering
        CustomerManager customerManager = new CustomerManager();

        List<Item> items = new ArrayList<>();
        items.add(Item.builder()
                        .name("RICE")
                .build());
        items.add(Item.builder()
                        .name("DAL")
                .build());

        Customer customer = Customer.builder()
                .cId("1")
                .name("Customer-1")
                .itemList(items)
                .orderId(customerManager.createOrder(items))
                .build();

    }
}
