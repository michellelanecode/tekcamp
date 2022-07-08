package com.teksystems.bootcamp;

import com.teksystems.bootcamp.factories.*;
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

    @Test
    public void caseDoesntMatter(){
        assertTrue(santa.makeGift("nCE") instanceof Toy);
        assertTrue(santa.makeGift("nTy") instanceof Coal);
    }

    @Test
    public void checkName(){
        assertTrue(santa.makeGift(NaughtyNiceList.ROSEMARIE.status) instanceof Toy);
    }
}
