package services;

import model.Item;
import model.Restro;

import java.util.List;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Restro executeStrategy(List<Item> itemList, List<Restro> restroList){
        return strategy.selectRestro(itemList,restroList);
    }


}
