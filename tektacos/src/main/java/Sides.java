public class Sides  {

    public enum sideChoices {
        CHIPSANDQUESO(2.50),
        CHIPSANDSALSA(2.50),
        FRIES(2.00),

        NOSIDE(0.00);

        public final double cost;

        sideChoices(double cost){
            this.cost = cost;
        }

    }

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
