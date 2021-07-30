package services;

import exceptions.FDSExceptions;
import lombok.Getter;
import model.Item;
import model.Restro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
class Pair{
    Restro r;
    Integer total;

    Pair(Restro r,Integer t){
        this.r = r;
        this.total = t;
    }
}


public class LowCost implements Strategy{
    @Override
    public Restro selectRestro(List<Item> itemList, List<Restro> restroList) {

        RestroManager restroManager = new RestroManager();

        List<Pair> eligibleRestros = new ArrayList<>();

        //check Restro with given itemList
        for (Restro restro : restroList) {

            int count = 0;

            Integer orderTotal = 0;

            for (Item item : itemList) {
                if (restro.getItems().containsKey(item.getName())) {
                    orderTotal += restro.getItems().get(item.getName()).getPrice();
                    count++;
                }
            }

            if (count == itemList.size()) {
                eligibleRestros.add(new Pair(restro,orderTotal));
            }
        }

        if(eligibleRestros.size() != 0) {

            //Sort according to Less Cost

            Comparator<Pair> costComparator = Comparator.comparing(Pair::getTotal);

            Collections.sort(eligibleRestros,costComparator);

            return eligibleRestros.get(0).r;

        }

        throw new FDSExceptions("No Restro has Ordered Items");

    }
}
