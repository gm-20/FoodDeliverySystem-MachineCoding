import model.Customer;
import model.Item;
import services.*;

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
        restroManager.createRestro(1,itemList,4.5F);


        itemList = new HashMap<>();
        itemList.put("RICE",Item.builder().name("RICE").price(20000).build());
        itemList.put("DAL",Item.builder().name("DAL").price(50000).build());
        restroManager.createRestro(2,itemList,5F);


        itemList = new HashMap<>();
        itemList.put("RICE",Item.builder().name("RICE").price(200).build());
        itemList.put("DAL",Item.builder().name("DAL").price(500).build());
        restroManager.createRestro(3,itemList,10F);



        //Customer ordering
        CustomerManager customerManager = new CustomerManager();

        List<Item> items = new ArrayList<>();
        items.add(Item.builder()
                        .name("RICE")
                .build());
        items.add(Item.builder()
                        .name("DAL")
                .build());


        Context context = new Context(new LowCost());

        Customer customer = Customer.builder()
                .cId("1")
                .name("Customer-1")
                .itemList(items)
                .orderId(customerManager.createOrder(items,context))
                .build();


    }
}
