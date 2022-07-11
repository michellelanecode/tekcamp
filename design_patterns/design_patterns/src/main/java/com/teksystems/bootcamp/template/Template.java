package com.teksystems.bootcamp.template;

public abstract class Template {

    public final void tellMeAStory() {
        System.out.println(getCharacter() + " went to" + setLocation() + "to get" + setItem() + "and ended up " + setAction() + ".");
    }
    String setLocation(){
        return " the library ";
    };
    String setItem(){
       return " computer ";
    }
    public abstract String getCharacter();

    public abstract String setAction();

}
