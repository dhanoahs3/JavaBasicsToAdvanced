package com.regularexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {
    public static void main(String[] args) {
        String challenge1 = "I want a bike.";

        /*Match the exact  above expression */
        System.out.println(challenge1.matches("I want a bike."));

        /*regExp for I want a and then anything after that.*/
        String regExp  = "I want a \\w+.";
        System.out.println(challenge1.matches(regExp));
        String challenge2 =  "I want a ball.";
        System.out.println(challenge2.matches(regExp));

        /*reg expression to match I want a bike or| I want a baLL*/
        String regExp1 = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regExp1));

        String regExp2 = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regExp2));

        /*Matching I want a bike or I I want a ball using Pattern matchers*/

        String regExp3 = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regExp3);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());
        /*Please note we dont have to compile the pattern again here.*/
        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());


        String challenge3 = "Replace all blanks with underscore";
        /*Replace all blanks with an underscore*/
        System.out.println(challenge3.replaceAll(" ","_"));

        /*To be more precise replace all white spaces with a underscore*/

        System.out.println(challenge3.replaceAll("\\s","_"));

        String challenge5 = "aaabccccccccdddefffg";
        /*Below is used to match one or more occurences of letters from a to g */
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5.matches("[a-g]+"));

        /*If we need to match the String in challenge 5 enternity we can use something like below*/
         /*We have used quantifiers below.we use carrot character ^ i.e start with 3 a's nothing before
         * the 3 a's then one b then 8 c's then 3 d's then 3 then 3 f's then 1 g then $ to make sure
         * there is nothing after the g*/
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));

         /*To verify the above works fine  we can do something like this*/

        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$","REPLACED"));


        System.out.println("-------------------------------------------------");

       String challenge6 = "abcd.12";
       /*Below is to check we have anything between A-z (notice the small z here) or a-z then a
       . then any digits
       * and then end the String.
       //And since . means any character but we actually want to test an actual . we use escape character
       //like this //.
       if we only want to test 0 or 1 digits after . we can use * instead of +
          //if we want minimum of 1 digit at least we use \\d+*/
        System.out.println(challenge6.matches("^[A-z][a-z]+\\.\\d*$"));

        /*Write code to print all digits in the below code*/
        String challenge7 = "abcd.135uvqz.7tzik.999";
        /*Here we did just one group [A-Za-z] rather than two groups as above[A-z][a-z]
        * Then we use \\. for the . and then we put \\d+ in paranthesis() .ie we are looking
        * for groups of digits*/
        Pattern pattern7 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher7 =  pattern7.matcher(challenge7);
        //Another way to the above is put abcd. or uvqz. in one group i.e in braces as below so it becomes group 1
        //Pattern pattern7 = Pattern.compile("([A-Za-z]+\\.)(\\d+)");
        //Then the digits \\d i.e 135 etc will become group 2 and can be accessed as below
        //            System.out.println("Occurences "+matcher7.group(2));

        while(matcher7.find()){
            /*Here we are printing group1 for all occurrences of digits.
            * keep in mind group 0 is the entire String and group 1 is the digits*/
            System.out.println("Occurences "+matcher7.group(1));
        }

        String challenge8 = "abcd.135\tuvqz.7\tzik.999\n";
        /*In the below reg expression all we are doing is putting \\s in the end to catch all white
        * spaces after the digits and we are putting the digits in a group using (\\d+)*/
        Pattern pattern8 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher8 =  pattern8.matcher(challenge8);
        while(matcher8.find()){
            System.out.println("Occurences "+matcher8.group(1));
        }
        System.out.println("---------------------------------------------------------------------------------------");


        /*Below we using Pattern to print the indexes for the start and end of group
         * and not the printing the groups itself as above
         * The end method returns the index of letter after the group ends so in order to print
         * the last digit of group we have to use end(1)-1*/
        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher9 =  pattern9.matcher(challenge8);
        while(matcher9.find()){
            System.out.println("Occurrences start = "+matcher9.start(1)+" end = "+(matcher9.end(1)-1));
        }

        System.out.println("---------------------------------------------------------------------------------------");

           String challenge10= "{0,2},{0,5},{1,3},{2,5}";
        /*Here what we do is we want something that starts with { then we group something using ()
        * and in group we put a . to match anything then + for more than one occurrences and then
        * ? to stop at first occurences of } otherwise it will print everything from 0 till 2,5}
        * . means any character ,+ means at least one character and ? turns it to a lazy quantifier */
        Pattern pattern10 = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher10 =  pattern10.matcher(challenge10);
        while(matcher10.find()){
            System.out.println("Occurences "+matcher10.group(1));
        }

        System.out.println("=====================================================");


        String challenge10a= "{0,2},{0,5},{1,3},{2,5},{x,y},{5,10},{20,25}";
        /*Below is used to print curly braces then any no of digits in it followed by ,
        * then again any digits after that and then closing curls braces*/
        Pattern pattern10a = Pattern.compile("\\{(\\d+,\\d+)\\}");
        Matcher matcher10a =  pattern10a.matcher(challenge10a);
        while(matcher10a.find()){
            System.out.println("Occurences "+matcher10a.group(1));
        }

        //if we don't to print the comma , in between the digits we can further divide our groups
        //i.e define first group with n number of digits then comma and then second group again with
        //n number of digits.
        System.out.println("-------------------------------------------------------------------");
        Pattern pattern10b = Pattern.compile("\\{(\\d+),(\\d+)\\}");
        Matcher matcher10b =  pattern10b.matcher(challenge10a);
        while(matcher10b.find()){

       // Then we print both groups 1 and 2 as we defined two groups above
            System.out.println("Occurences "+matcher10b.group(1)+" "+matcher10b.group(2));
        }

        System.out.println("----------?????-------------");

        String challenge11 = "11111";
         /*Below reg expression matches any 5 digits. we put Carrot ^ at the begenning and $ in the end
         * to make sure that it is only and only 5 digits nothing else*/
        System.out.println(challenge11.matches("^\\d{5}$"));

        //or instead of //d we can use [0-9]

        System.out.println(challenge11.matches("^[0-9]{5}$"));

        /*Below reg expression matches any 5 digits then a - and then another 5 digits. we put Carrot ^ at the begenning and $ in the end
         * to make sure that it is only and only 5 digits nothing else*/
        System.out.println("----------???????????????????-------------");

        String challenge12 = "11111-1111";
        System.out.println(challenge12.matches("^\\d{5}-\\d{4}$"));

        //or instead of //d we can use [0-9]

        System.out.println(challenge12.matches("^[0-9]{5}-[0-9]{4}$"));

        /*Below is the req expression to match 5 digits and then we put () and inside those braces we
        * put - then 4 digits and a ? after the braces .This ? is very imp
        * it means either 1 group of -1111 or 0 groups
        * So either 1 group 11111-1111
        * or 0 groups will hold true 1111
        *
        * if we want to check for more than 1 groups like 2 groups or 3 groups
        * like 11111-1111-1111 then we have to either use * or plus after the group
        *         System.out.println(challenge12.matches("^\\d{5}(-\\d{4})*$"));
         */

        System.out.println("----------??-------------");


        System.out.println(challenge11.matches("^\\d{5}(-\\d{4})?$"));


        System.out.println(challenge12.matches("^\\d{5}(-\\d{4})?$"));



        String challenge13 = "11111-1111-1111-1111";

        System.out.println(challenge13.matches("^\\d{5}(-\\d{4})+$"));


        //Reg expression for canadian postal code
        //Any letter than digit then another letter then space or - although space or -
        // is optional that's why we use ? i.e 0 or 1 spaces or 1 dash - and since it is 0 or 1 dash
        // so what we are doing here is instead of putting then in brackets( -)? we are putting them in square brackets
        // to satisfy the OR condition ,so [ -]?
        // and then we have a digit, then letter and digit again.
        System.out.println("===========================================================");
        String regExpPostalCode = "^[A-za-z]\\d[A-za-z][ -]?\\d[A-za-z]\\d$";

        System.out.println("H3H 2P1".matches(regExpPostalCode));
        System.out.println("H3H-2P1".matches(regExpPostalCode));
        System.out.println("H3H_2P1".matches(regExpPostalCode));
        System.out.println("H3H2P1".matches(regExpPostalCode));
        System.out.println("33H 2P1".matches(regExpPostalCode));
        System.out.println("H3H 2Pp".matches(regExpPostalCode));
        System.out.println("h3H 2p1".matches(regExpPostalCode));
        System.out.println("h3h 2P1".matches(regExpPostalCode));
        System.out.println("h3h2p1".matches(regExpPostalCode));
        System.out.println("h3h-2p1".matches(regExpPostalCode));
        System.out.println("h3h_2p1".matches(regExpPostalCode));



        System.out.println("-------------------------------------------------------");

        String REGEX = "\\d+";
        String INPUT = "The dog number is 99. " + "All dogs say 99.";
        String REPLACE = "XX";

        Pattern p = Pattern.compile(REGEX);

        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }

}
