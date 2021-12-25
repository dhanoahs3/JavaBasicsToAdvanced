package com.generictypes;

public class ChallengeRunner {
    /*And since in Team class we defined that our class is of type T we can now make an object of class Team of the
    * type FootballPlayer or BaseBallPlayer etc by doing like this
    *        Team<FootballPlayer> adelaideCross = new Team<>("Adelaide Cross");
    * And please note once we do that ,i.e once we instantiate the team object to be of type FootballPlayer we can't
    * add other objects to it like BaseBallPlayer etc as for that we either have to define Team object like this
    *         Team adelaideCross = new Team("Adelaide Cross"); that is add any objects to addPlayer when using
    *  this Team object
    * But we have solved the problem of defining a Team of a particular type and then we can only add objects of that type
    * to that Class but it also adds another problem and that problem is we can still define an object of class Team af any
    * type and that will throw an error at runtime
    * Team<String> brokenTeam = new Team<>("This wont work ");
        brokenTeam.addPlayer("no-one");
      So will will get an error at runtume as    we cant type case
      * Player to type String  so this will throw an error
      *           System.out.println(((Player)player).getName()+ " picked for team " + this.name);
      * So to solve the issue we use bounded type parameters like in our case we use upper bounded types
      * Like we defined the class NewTeam
      * public class NewTeam<T extends Player> {
      * that is Type T can be just any class that extends the class Player that is only classes that are child of Player

         * So few things to note argument passed for Top paramter T can be class like in our case it is Player
         * or an Interface
         * And we can add multiple bounds .i.e one class and multiple Interfaces something like this
         * public class NewTeam<T extends Player & Coach & Manager>
         where Coach and Manager can be two interfaces
         *Also note if we don't define the type parameter in matchResult method then we can literally pass different
         * teams to it like baseball team and football teams but in real world that doesnt make sense as we can't get result
         * between football team and baseball team
         *         perthCross.matchResult(ontarioCubs,15,10); here perthCross is football team and opponent team ontatioCubs
         * is football team so it doesn't make any sense To fix this we do like this.
         *     public void matchResult(NewTeam<T> opponent , int ourScore , int theirScore)
         * i.e pass <T> along with arguments for NewTeam and then the above line of code will throw compile time error
         * i.e perthCross and ontarioCubs are different types of teams.


         */
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("beckham");
        Team<FootballPlayer> adelaideCross = new Team<>("Adelaide Cross");
        adelaideCross.addPlayer(joe);
      //  adelaideCross.addPlayer(pat);
       // adelaideCross.addPlayer(beckham);
        System.out.println("The total no of players are " +adelaideCross.numPlayers());

        Team<BaseballPlayer> chicagoCubs = new Team<>("ChicagoCubs");
        chicagoCubs.addPlayer(pat);

      //  Team<String> brokenTeam = new Team<>("This wont work ");
       // brokenTeam.addPlayer("no-one");

        Team<SoccerPlayer> brokenTeam1 = new Team<>("This wont work ");
        brokenTeam1.addPlayer(beckham);
        NewTeam<FootballPlayer> melbourne = new NewTeam<>("Melbourne");
        FootballPlayer gordon = new FootballPlayer("Gordon");
        melbourne.addPlayer(gordon);

        System.out.println("------------Testing with new team---------------------------------------------");

        NewTeam<FootballPlayer> haythorn = new NewTeam<>("Haythorn");
        NewTeam<FootballPlayer> freemantle = new NewTeam<>("Freemantle");

        NewTeam<FootballPlayer> perthCross = new NewTeam<>("Perth Cross");
        perthCross.addPlayer(joe);


        NewTeam<BaseballPlayer> ontarioCubs = new NewTeam<>("Ontariocubs");
        ontarioCubs.addPlayer(pat);

        haythorn.matchResult(freemantle,1,0);
        haythorn.matchResult(perthCross,3,8);

        perthCross.matchResult(freemantle,3,1);
      //  perthCross.matchResult(ontarioCubs,15,10);
        perthCross.matchResult(haythorn,3,1);

        System.out.println(haythorn.getName()+" : "+ haythorn.ranking());
        System.out.println(freemantle.getName()+" : "+ freemantle.ranking());
        System.out.println(perthCross.getName()+" : "+ perthCross.ranking());
        System.out.println(ontarioCubs.getName()+" : "+ ontarioCubs.ranking());
        System.out.println(haythorn.compareTo(freemantle));
        System.out.println(freemantle.compareTo(haythorn));
        System.out.println(freemantle.compareTo(perthCross));
        System.out.println(perthCross.compareTo(freemantle));
        System.out.println(haythorn.compareTo(perthCross));
        System.out.println(perthCross.compareTo(haythorn));






















    }
}
