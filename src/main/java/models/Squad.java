package models;

import java.util.ArrayList;

public class Squad {

    private int mId;
    private int mMaxSize;
    private String mName;
    private String mCause;
    private ArrayList<Hero> heroes;
    public static ArrayList<Squad> squads=new ArrayList<Squad>();

    public Squad(int mMaxSize, String mName, String mCause, ArrayList<Hero> heroes) {

        this.mMaxSize = mMaxSize;
        this.mName = mName;
        this.mCause = mCause;
        this.heroes = heroes;
        squads.add(this);
        this.mId=squads.size();
    }

    public static ArrayList<Squad> getSquads() {
        return squads;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void deleteHero(int id){
        heroes.remove(id-1);
    }
    public void deleteAllHeroes(){
        heroes.clear();
    }
    public void deleteSquad(int id){
        squads.remove(id-1);
    }
    public void deleteAllSquads(){
        squads.clear();
    }


    public static void clearAll(){
        squads.clear();
    }

    public static Squad findById(int id){
        return squads.get(id-1);
    }
}
