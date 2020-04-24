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
    private static ArrayList<Hero> heroes=new ArrayList<Hero>();
    public Hero(String mName, int mAge, String mSpecialPower, String mWeakness, int mDefence, int mAttack) {

        this.mId=heroes.size()+1;
        this.mName = mName;
        this.mAge = mAge;
        this.mSpecialPower = mSpecialPower;
        this.mWeakness = mWeakness;
        this.mDefence = mDefence;
        this.mAttack = mAttack;
        heroes.add(this);
    }



}
