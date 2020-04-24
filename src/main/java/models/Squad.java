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
        this.mId=squads.size();
        this.mMaxSize = mMaxSize;
        this.mName = mName;
        this.mCause = mCause;
        this.heroes = heroes;
        squads.add(this);
    }

    public static ArrayList<Squad> getSquads() {
        return squads;
    }

    public static void clearAll(){
        squads.clear();
    }
}
