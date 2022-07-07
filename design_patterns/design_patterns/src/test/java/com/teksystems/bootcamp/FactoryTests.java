package com.teksystems.bootcamp;

import com.teksystems.bootcamp.factories.SantasFactory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Unit test for simple App.
 */
public class FactoryTests
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldReturnCoal()
    {
        SantasFactory factory = new SantasFactory();
        assertTrue(factory.checkList("nty").equals("Coal") );
    }

    @Test
    public void shouldReturnToy(){
        SantasFactory factory = new SantasFactory();
        assertTrue(factory.checkList("nce").equals("Toy") );
    }

    @Test
    public void shouldReturnNull(){
        SantasFactory factory = new SantasFactory();
        assertTrue(factory.checkList("nt").equals("status not found") );
    }
}
