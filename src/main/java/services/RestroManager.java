package services;

import model.Item;
import model.Restro;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestroManager {


    private static final List<Restro> restroList = new ArrayList<>();


    public void createRestro(Integer resId, Map<String,Item> itemList,Float rating){

        Restro restro = Restro.builder()
                .resId(resId)
                .noOfOrders(0)
                .items(itemList)
                .rating(rating)
                .build();

        restroList.add(restro);
    }

    public Restro getRestroList(Integer resId) {

//        restroList.stream().forEach(x ->
//                x.getItems().forEach
//                                (item -> System.out.println(item.getName())));

        return restroList.stream().filter(restro -> restro.getResId().equals(resId))
                .collect(Collectors.toList()).get(0);
    }

    public List<Restro> getAllRestroList() {
        return restroList;
    }


}
