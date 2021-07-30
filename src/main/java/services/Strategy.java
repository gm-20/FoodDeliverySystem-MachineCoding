package services;

import model.Item;
import model.Restro;

import java.util.List;

public interface Strategy {

    Restro selectRestro(List<Item> itemList,List<Restro> restroList);

}
