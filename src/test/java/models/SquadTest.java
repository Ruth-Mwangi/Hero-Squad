package models;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SquadTest {

    @After
    public void tearDown() throws Exception {
        Squad.clearAll();
    }
    @Test
    public void createInstanceOfSquad() throws Exception{
        Squad squad= setUpNewSquad();
        assertEquals(true,squad instanceof Squad);
    }

    @Test
    public void returnAllInstances_true() throws Exception {
        Squad squad=setUpNewSquad();
        Squad otherSquad=setUpNewSquad();
        assertEquals(2,Squad.getSquads().size());
    }

    @Test
    public void allSquadsContainedInSquad() throws Exception {
        Squad squad=setUpNewSquad();
        Squad otherSquad=setUpNewSquad();
        assertTrue(Squad.getSquads().contains(squad));
        assertTrue(Squad.getSquads().contains(otherSquad));
    }

    @Test
    public void findById() throws Exception {
        Squad squad=setUpNewSquad();
        Squad otherSquad=setUpNewSquad();
        Squad foundSquad=Squad.findById(1);
        assertEquals(squad,foundSquad);
    }

    @Test
    public void deleteHeroFromSquad() {
        Squad squad=setUpNewSquad();
        Squad otherSquad=setUpNewSquad();
        ArrayList<Hero> formerHero=squad.getHeroes();
        squad.deleteHero(1);
        assertEquals(1,formerHero.size());
        assertEquals(formerHero.get(0).getmId(),2);


    }

    @Test
    public void deleteAllHeroes() {
        Squad squad=setUpNewSquad();
        Squad otherSquad=setUpNewSquad();
        ArrayList<Hero> formerHero=squad.getHeroes();
        squad.deleteAllHeroes();
        assertEquals(0,formerHero.size());

    }

    //helper
    private Squad setUpNewSquad() {
        ArrayList<Hero> heroes=new ArrayList<Hero>();
        Hero hero=new Hero("Absorbing Man",30,"Absorbing ","Can Absorb evil thought",20,60);
        Hero otherHero=new Hero("Abraxas",60,"Read Minds ","Gets tired fast",20,60);
        heroes.add(hero);
        heroes.add(otherHero);
        return new Squad(10,"queen","sexism",heroes);
    }
}