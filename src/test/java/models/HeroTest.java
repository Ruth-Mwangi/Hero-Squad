package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void createInstanceOfHero_true() throws Exception{
        Hero hero=setUpNewHero();
        assertEquals(true,hero instanceof Hero);
    }
    //helper
    private Hero setUpNewHero() {
        return new Hero("Absorbing Man",30,"Absorbing ","Can Absorb evil thought",20,60);
    }

}