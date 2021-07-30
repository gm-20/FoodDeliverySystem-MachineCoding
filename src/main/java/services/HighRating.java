package services;

import exceptions.FDSExceptions;
import model.Item;
import model.Order;
import model.Restro;

import java.util.*;

public class HighRating implements Strategy{


    List<Order> orderList = new ArrayList<>();


    @Override
    public Restro selectRestro(List<Item> itemList, List<Restro> restroList) {

        RestroManager restroManager = new RestroManager();

        List<Restro> eligibleRestros = new ArrayList<>();

        //check Restro with given itemList
        for (Restro restro : restroList) {

            int count = 0;

            //Integer orderTotal = 0;

            for (Item item : itemList) {
                if (restro.getItems().containsKey(item.getName())) {
                    //orderTotal += item.getPrice();
                    count++;
                }
            }

            if (count == itemList.size()) {
                eligibleRestros.add(restro);
            }
        }

        if(eligibleRestros.size() != 0) {

            //Sort according to Rating

            Comparator<Restro> ratingComparator = Comparator.comparing(Restro::getRating);

            Collections.sort(eligibleRestros,Collections.reverseOrder(ratingComparator));

            return eligibleRestros.get(0);

        }


        throw new FDSExceptions("No Restro has Ordered Items");


    }
}
