package com.genericschallenge;

public class Runner {

    public static void main(String[] args) {
        League<NewTeam<FootballPlayer>> footballLeague = new League<>("AFL");
        NewTeam<FootballPlayer> adelaideCross = new NewTeam<>("adelaideCross");
        NewTeam<FootballPlayer> haythorn = new NewTeam<>("Haythorn");
        NewTeam<FootballPlayer> melbourne = new NewTeam<>("melbourne");
        NewTeam<FootballPlayer> freemantle = new NewTeam<>("freemantle");
        NewTeam<BaseballPlayer> baseballTeam = new NewTeam<>("baseball team");
        haythorn.matchResult(freemantle,1,0);
        haythorn.matchResult(adelaideCross,3,8);

        adelaideCross.matchResult(freemantle,3,1);

        footballLeague.add(adelaideCross);
        footballLeague.add(haythorn);
        footballLeague.add(melbourne);
        footballLeague.add(freemantle);
       //this will throw a compile time error as we can't add baseballTeam to footballLeague
        // footballLeague.add(baseballTeam);
         footballLeague.showLeagueTable();





    }
}
