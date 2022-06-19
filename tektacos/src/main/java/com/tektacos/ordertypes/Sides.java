package com.tektacos.ordertypes;

public class Sides  {

    public sideChoices returnSide(String side){
        switch (side){
            case "cq":

              return sideChoices.CHIPSANDQUESO;

            case "cs":

                return  sideChoices.CHIPSANDSALSA;

            case "f":

                return  sideChoices.FRIES;

        }
        return sideChoices.NOSIDE;
    }

}
