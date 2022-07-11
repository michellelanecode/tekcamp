package com.teksystems.bootcamp.template;

public class RandomStory extends Template{

    private String[] characters = new String[] {"Amerie", "Jessica", "Amber", "Justice"};

    private String[] actions = new String[] {"jumping the broom", "playing tic-tac toe", "reading tarot cards", "playing video games", "reading a book"};
    @Override
    String getCharacter() {
       return getRandom(characters);
    }

    @Override
    String setAction() {
        return getRandom(actions);
    }

    String getRandom(String[] arrayList){
        int index = (int) Math.floor(Math.random() * arrayList.length);
        return arrayList[index];
    }
}
