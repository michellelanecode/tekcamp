package com.teksystems.bootcamp;

import com.teksystems.bootcamp.template.OriginalStory;
import com.teksystems.bootcamp.template.RandomStory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class TemplateTests {

    OriginalStory orignalStory = new OriginalStory();
    RandomStory randomStory = new RandomStory();



    @Test
    public void testStory(){
        assertEquals(orignalStory.getCharacter(), "Prince Charming");
        assertEquals(orignalStory.setAction(), "gallantly saving the princess");
    }

    @Test
    public void returnFalse(){
        assertFalse(orignalStory.getCharacter().equals("Amerie"));
        assertFalse(randomStory.getCharacter().equals("Prince Charming"));
    }


}
