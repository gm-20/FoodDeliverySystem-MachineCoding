package services;

import exceptions.FDSExceptions;
import model.Item;
import model.Order;
import model.OrderLifeCycle;
import model.Restro;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerManager {


    List<Order> orderList = new ArrayList<>();


    public String createOrder(List<Item> itemList) throws FDSExceptions {

        RestroManager restroManager = new RestroManager();

        //check Restro with given itemList
        List<Restro> restroList = restroManager.getAllRestroList();
        for (Restro restro : restroList) {

            int count = 0;

            for (Item item : itemList) {
                if (restro.getItems().containsKey(item.getName())) {
                    count++;
                }
            }

            if (count == itemList.size()) {
                System.out.println("Order created");
                Order order = Order.builder()
                        .orderId(UUID.randomUUID().toString())
                        .status(OrderLifeCycle.CREATED)
                        .itemList(itemList)
                        .build();

                orderList.add(order);
                return order.getOrderId();

            }
        }
        throw new FDSExceptions("No Restro has Ordered Items");
    }

}