package models;

import java.util.ArrayList;

public class Hero {
    private String mName;
    private int mId;
    private int mAge;
    private String mSpecialPower;
    private  String mWeakness;
    private int mDefence;
    private int mAttack;
    private boolean mOccupied;
    private static ArrayList<Hero> heroes=new ArrayList<Hero>();
    public Hero(String mName, int mAge, String mSpecialPower, String mWeakness, int mDefence, int mAttack) {

        this.mId=heroes.size();
        this.mName = mName;
        this.mAge = mAge;
        this.mSpecialPower = mSpecialPower;
        this.mWeakness = mWeakness;
        this.mDefence = mDefence;
        this.mAttack = mAttack;
        this.mOccupied=false;
        heroes.add(this);
    }

    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void updateHero(boolean occupied){
        this.mOccupied=occupied;
    }

    public static Hero findById(int id){

        return heroes.get(id-1);
    }


    public static void clearAll(){
        heroes.clear();
    }

}
