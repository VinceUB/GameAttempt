package io.github.vkb24312.gameAttempt.Information;

import java.util.ArrayList;

public class User {
    public User(){}

    //<editor-fold desc="Login info">
    public String username;
    public String password;
    public String passwordHint;
    //</editor-fold>

    //<editor-fold desc="Names">
    private String name_personal;
    private String name_formal;
    private String name_full;

    public String getName(int nameType){
        if(nameType==0){
            return name_personal;
        } else if(nameType==1){
            return name_formal;
        } else if (nameType==2){
            return name_full;
        } else {
            throw new IllegalArgumentException("nameType cannot be less than 0 or more than 2");
        }
    }

    public static final int NAMETYPE_PERSONAL = 0;
    public static final int NAMETYPE_FORMAL = 1;
    public static final int NAMETYPE_FULL = 2;
    //</editor-fold>

    //<editor-fold desc="Inventory">
    private ArrayList inventory = new ArrayList();

    int getItemNumber(Item item){
        int i = 0;
        while(i>=inventory.toArray().length){
            if(item==inventory.get(i)){
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    Item getItem(int index){
        if(0 <= index && index < inventory.toArray().length) {
            return (Item) inventory.get(index);
        } else {
            return null;
        }
    }

    void addItem(Item item){
        inventory.add(inventory.toArray().length, item);
    }
    //</editor-fold>
}