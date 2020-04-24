package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @After
    public void tearDown() throws Exception {
        Hero.clearAll();
    }

    @Test
    public void createInstanceOfHero_true() throws Exception{
        Hero hero=setUpNewHero();
        assertEquals(true,hero instanceof Hero);
    }

    @Test
    public void returnAllInstancesOfHero() throws Exception{
        Hero hero=setUpNewHero();
        Hero otherHero=new Hero("Abraxas",60,"Read Minds ","Gets tired fast",20,60);
        assertEquals(2,Hero.getHeroes().size());
    }

    @Test
    public void allInstancesAreContainedInHero() throws Exception{
        Hero hero=setUpNewHero();
        Hero otherHero=new Hero("Abraxas",60,"Read Minds ","Gets tired fast",20,60);
        assertTrue(Hero.getHeroes().contains(hero));
        assertTrue(Hero.getHeroes().contains(otherHero));
    }

    @Test
    public void findById() throws Exception{
        Hero hero=setUpNewHero();
        Hero otherHero=new Hero("Abraxas",60,"Read Minds ","Gets tired fast",20,60);
        Hero foundHero=Hero.findById(1);
        assertEquals(hero,foundHero);
    }


    //helper
    private Hero setUpNewHero() {
        return new Hero("Absorbing Man",30,"Absorbing ","Can Absorb evil thought",20,60);
    }

}