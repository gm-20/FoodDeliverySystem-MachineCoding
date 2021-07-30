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


    public String createOrder(List<Item> itemList,Context strategy) throws FDSExceptions {

        RestroManager restroManager = new RestroManager();


        List<Restro> restroList = restroManager.getAllRestroList();

        Restro selectedRestro = strategy.executeStrategy(itemList, restroList);

        System.out.println("Order created from Restro ID: " + selectedRestro.getResId());
        Order order = Order.builder()
                .orderId(UUID.randomUUID().toString())
                .status(OrderLifeCycle.CREATED)
                .itemList(itemList)
                .restroId(selectedRestro.getResId())
                .build();

        orderList.add(order);
        return order.getOrderId();


    }

}