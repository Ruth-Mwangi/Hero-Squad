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


        this.mName = mName;
        this.mAge = mAge;
        this.mSpecialPower = mSpecialPower;
        this.mWeakness = mWeakness;
        this.mDefence = mDefence;
        this.mAttack = mAttack;
        this.mOccupied=false;
        heroes.add(this);
        this.mId=heroes.size();
    }

    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void updateHero(boolean occupied){
        this.mOccupied=occupied;
    }

    public void deleteHero(int id){
        heroes.remove(id-1);
    }
    public void deleteAll(){
        heroes.clear();
    }

    public static Hero findById(int id){

        return heroes.get(id-1);
    }

    public static void clearAll(){
        heroes.clear();
    }

    public String getmName() {
        return mName;
    }

    public int getmId() {
        return mId;
    }

    public int getmAge() {
        return mAge;
    }

    public String getmSpecialPower() {
        return mSpecialPower;
    }

    public String getmWeakness() {
        return mWeakness;
    }

    public int getmDefence() {
        return mDefence;
    }

    public int getmAttack() {
        return mAttack;
    }

    public boolean ismOccupied() {
        return mOccupied;
    }
}
