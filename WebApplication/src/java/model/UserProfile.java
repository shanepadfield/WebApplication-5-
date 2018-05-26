/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shane
 */
public class UserProfile {
    
    private User userID;
    private ArrayList<ItemRating> items = new ArrayList<>();
    
    public UserProfile()
    {
        userID = new User();
        items = new ArrayList<>();
    }
    
    public User getUserID(){
        return userID;
    }
    
    public UserProfile(User userID) {
        this.userID = userID;
    }
    
    public ArrayList<ItemRating> getItems(){
        return items;
    }
    
    public void setUserID(User userID){
        this.userID = userID;
    }
    
    public void addItem(ItemRating item){
        boolean alreadyExists = false;
        for (ItemRating i : items)
            if (i.getItem().getItemCode().equals(item.getItem().getItemCode()))
                alreadyExists = true;
        if (!alreadyExists)
            items.add(item);
    }
    
    public void removeItem(ItemRating item){
        if (items.contains(item))
            items.remove(item);
    }
    
    public void emptyProfile(){
        for(ItemRating i: items){
            if(items.contains(i)){
                items = null;
            }
        }
    }
    
    public double getItemRating(Item item) {
        double rating = -1;
        for (ItemRating i : items)
            if (i.getItem().getItemCode().equals(item.getItemCode()))
                rating = i.getRating();
        return rating;
    }
    
    public boolean getListened(Item item) {
        boolean purchased = false;
        for (ItemRating i : items)
            if (i.getItem().getItemCode().equals(item.getItemCode()))
                purchased = i.getMadeIt();
        return purchased;
    }
    
    public boolean containsItem(Item item) {
        boolean contains = false;
        for (ItemRating i : items)
            if (i.getItem().getItemCode().equals(item.getItemCode()))
                contains = true;
        return contains;
    }
}
