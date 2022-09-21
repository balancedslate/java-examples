package com.example.notificationtest;

import java.util.ArrayList;
import java.util.List;

public class PlantArray extends PlantData{

    List<PlantData> ourArray = new ArrayList<PlantData>(30);
    List<PlantData> defaultArray = new ArrayList<PlantData>(30);

    public PlantArray(){
        initializePlantArray();
    }

    public void initializePlantArray(){
        // Plants we support the choice of
        PlantData carrot = new PlantData("Carrot", 60, 2);
        PlantData radish = new PlantData("Radish", 60, 2);
        PlantData hotPepper = new PlantData("Chili Pepper", 60, 2);
        PlantData bellPepper = new PlantData("Bell Pepper", 60, 2);
        PlantData squash = new PlantData("Squash", 60, 2);
        PlantData pumpkin = new PlantData("Pumpkin", 60, 2);
        PlantData zucchini = new PlantData("Zucchini", 60, 2);
        PlantData tomato = new PlantData("Tomato", 60, 2);
        PlantData potato = new PlantData("Potato", 60, 2);
        PlantData basil = new PlantData("Basil", 60, 2);
        PlantData mint = new PlantData("Mint", 60, 2);
        PlantData oregano = new PlantData("Oregano", 60, 2);
        PlantData cilantro = new PlantData("Cilantro", 60, 2);
        PlantData thyme = new PlantData("Thyme", 60, 2);
        PlantData rosemary = new PlantData("Rosemary", 60, 2);
        PlantData strawberries = new PlantData("Strawberries", 60, 2);
        PlantData blueberries = new PlantData("Blueberries", 60, 2);
        PlantData blackberries = new PlantData("Blackberries", 60, 2);
        PlantData lemon = new PlantData("Lemon", 60, 2);
        PlantData lime = new PlantData("Lime", 60, 2);
        PlantData orange = new PlantData("Orange", 60, 2);
        PlantData apple = new PlantData("Apple", 60, 2);
        PlantData wheat = new PlantData("Wheat", 60, 2);
        PlantData cucumber = new PlantData("Cucumber", 60, 2);
        PlantData eggplant = new PlantData("Eggplant", 60, 2);
        //add plants to the array
        defaultArray.add(carrot);
        defaultArray.add(radish);
        defaultArray.add(hotPepper);
        defaultArray.add(bellPepper);
        defaultArray.add(squash);
        defaultArray.add(pumpkin);
        defaultArray.add(zucchini);
        defaultArray.add(tomato);
        defaultArray.add(potato);
        defaultArray.add(basil);
        defaultArray.add(orange);
        defaultArray.add(oregano);
        defaultArray.add(mint);
        defaultArray.add(cilantro);
        defaultArray.add(thyme);
        defaultArray.add(rosemary);
        defaultArray.add(strawberries);
        defaultArray.add(blackberries);
        defaultArray.add(blueberries);
        defaultArray.add(lemon);
        defaultArray.add(lime);
        defaultArray.add(apple);
        defaultArray.add(wheat);
        defaultArray.add(cucumber);
        defaultArray.add(eggplant);
    }

    public void addPlant(PlantData plant){
        ourArray.add(plant);
    }

    public List<PlantData> getOurPlants() {
        return ourArray;
    }

    public List<PlantData> getDefaultArray() {
        return defaultArray;
    }


}
