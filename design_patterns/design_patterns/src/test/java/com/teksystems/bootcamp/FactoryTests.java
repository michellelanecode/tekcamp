package com.teksystems.bootcamp;

import com.teksystems.bootcamp.factories.Coal;
import com.teksystems.bootcamp.factories.Gift;
import com.teksystems.bootcamp.factories.SantasFactory;
import com.teksystems.bootcamp.factories.Toy;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Unit test for simple App.
 */
public class FactoryTests
{
    SantasFactory santa = new SantasFactory();
    Gift gift;
    @Test
    public void shouldReturnCoal()
    {
        assertTrue(santa.makeGift("nty") instanceof Coal);
    }

    @Test
    public void shouldReturnToy(){
        assertTrue(santa.makeGift("nce") instanceof Toy);
    }


}
