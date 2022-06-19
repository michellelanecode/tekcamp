package com.tektacos.ordertypes;
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
