package com.genericschallenge;

import com.generictypes.Player;

import java.util.ArrayList;

/*We are adding NewTeam<T> as generic type to the interface Comparable. Here NewTeam is a type of Class NewTeam and T
is another  type .T basically means Baseball Team or football Team etc. So what we are doing here is creating the ability
that when we implement method compareTo of interface Comparable it should only accept parameters of NewTeam
and tha too of a typical NewTeam like baseball team or football team as it makes no sense if we compare football team to
basefall team */

public class NewTeam<T extends Player> implements Comparable<NewTeam<T>> {

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    public NewTeam(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private ArrayList<T> members = new ArrayList<>();

    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println(player.getName() +" is already on the team");
            return false;
        }
        else{
            members.add(player);
            System.out.println(player.getName()+ " picked for team " + this.name);
            return true;
        }
    }
    public int numPlayers(){
        return this.members.size();
    }
    public void matchResult(NewTeam<T> opponent , int ourScore , int theirScore){
        String message;
        if(ourScore > theirScore){
            message = " beat ";
            won++;
        }
        else if(ourScore==theirScore){
            tied++;
            message = " tied to ";
        }
        else {
            lost++;
            message = " lost to ";
        }
        played++;
        if(opponent!=null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null,theirScore,ourScore);
        }
    }
    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(NewTeam<T> team) {
        if(this.ranking()>team.ranking()){
            return -1;
        }
        if(this.ranking()<team.ranking()) {
        return 1;
        }
        else
            return 0;
    }
}
