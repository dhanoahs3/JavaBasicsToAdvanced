package com.generictypes;

import java.util.ArrayList;
/*Here we have defined the Class Team of type T and also defined the array list of parameterised type T
*    private ArrayList<T> members = new ArrayList<>();

Then we pass ArrayList to the method ArrayList like this      public boolean addPlayer(T player){
* But now there is a problem player.getName will throw an compile time error as now we don't know what is the type for T
* until the class in instantiated.
* so we have to type cast player.getName to Player like this
*             System.out.println(((Player)player).getName() +" is already on the team");
*
* Basically we are saying class Team is of type T and so is the ArrayList of Type T
* And then in addPlayer we are passing parameter of type T as well ,but since we don't know what type T
* would be till runtime so we have to type cast the  getName method.
* ((Player)player).getName()


 */
public class Team<T> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    public Team(String name) {
        this.name = name;
    }

    private ArrayList<T> members = new ArrayList<>();

    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println(((Player)player).getName() +" is already on the team");
            return false;
        }
        else{
            members.add(player);
            System.out.println(((Player)player).getName()+ " picked for team " + this.name);
          return true;
        }
    }
    public int numPlayers(){
        return this.members.size();
    }
    public void matchResult(Team opponent , int ourScore , int theirScore){
        if(ourScore > theirScore){
            won++;
        }
        else if(ourScore==theirScore){
            tied++;
        }
        else {
            lost++;
        }
        played++;
        if(opponent!=null){
            opponent.matchResult(null,theirScore,ourScore);
        }
    }
    public int ranking() {
        return (won * 2) + tied;
    }
}
