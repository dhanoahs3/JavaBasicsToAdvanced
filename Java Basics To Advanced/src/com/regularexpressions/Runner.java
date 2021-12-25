package com.regularexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        String myString = "Its going to rain today";
        System.out.println(myString);
        String yourString = myString.replace("Its", "Is it");
        System.out.println(yourString);
        String alphanumeric = "abcdefghiiiiiiiiiiik991";
        // . is a wild card for any character. so all characters will be replaced by .
        System.out.println(alphanumeric.replaceAll(".", "Y"));

        /*Carrot boundary matcher which we can type using shift + 6
        * It basically means start looking at the start of the String due to ^. and match is exaclty
        * abcdef*/
        System.out.println(alphanumeric.replaceAll("^abcdef", "ABC"));

        String newAlphanumeric = "abcdefghijiiabcdefiiiiiiiik991";
        /*^ replace only if starting of String is exact match to abcdef
        * so the second occurence of abcdef will not be replaced.*/
        System.out.println(newAlphanumeric.replaceAll("^abcdef", "ABC"));

        /*The below will return false as for the matches class the entire String has to match
        * not just the beginning of the String*/
        System.out.println(alphanumeric.matches("^abcdef"));

        /*The below will return true as we are matching the entire String*/
        System.out.println(alphanumeric.matches("abcdefghiiiiiiiiiiik991"));

        /*===================Impt thing to note =================================*/
        /*replaceAll method can replace a part of the String with req expression like in the below example
        * we can replace 991 in a  String which ends with 991
        * For matches method the entire String has to match regular expression and just 991 in the end will
        * return false*/

        /*$ replace only if end of String is exact match to 991*/

        System.out.println(newAlphanumeric.replaceAll("991$", "ABC"));

        /*replace occurrence of ghi in String with X*/


        System.out.println(newAlphanumeric.replaceAll("ghi", "X"));

        /*replace occurrence of every a ,e and i in String with AC*/


        System.out.println(newAlphanumeric.replaceAll("[aei]", "AC"));

        /*replace occurrence of every a ,e and i in String with "the rain"*/


        System.out.println(newAlphanumeric.replaceAll("[aei]", "the rain"));

        /*replace occurence of every a ,e and i in String only if a e and i is either followed by
         f or g i.e look for occurrence of af ,ag , ef,eg or  if,ig with AC*/


        System.out.println(newAlphanumeric.replaceAll("[aei][fg]", "the rain"));

        /*Below replaces any Harry or harry with tommy*/


        System.out.println("Harry".replaceAll("[Hh]arry", "Tommy"));

        /*Below we have carrot character but it is inside the square bracket. So it is not the same
         * as ^ we discussed above which looks fo something at beginning of String.
         * The one below will replace any thing other than b,h,i or 5 with X */

        System.out.println("abcdefghijklmnopqrstuvwxyz5".replaceAll("[^bhi5]", "X"));


        /*Below replaces any occurences of a to f or 3-7  with x
         * Please note  it does not have to be continous i.e we can have something like
         * adfeg or 43756 or even repetitive like 3452333 etc and it will replace them all*/

        System.out.println("abcdeFGHaaa123456789555".replaceAll("[abcdef34567]", "X"));

        /*Below does the same as above*/

        System.out.println("abCdeFGHaa123456789".replaceAll("[a-f3-7]", "X"));

        /*Above only looks for lower case a-f as regular expressions are case sensitive
         For upper case we can do something like A-F*/

        System.out.println("abCdeFGH123456789".replaceAll("[a-fA-F3-7]", "X"));

        /*Or we can do both upper and lower case using (?i) in the before reg expression
        * So the construct (?i) turns the case senstivity off*/
        System.out.println("abCdeFGH123456789".replaceAll("(?i)[a-f3-7]", "X"));

        /*replaces any numbers with x*/
        System.out.println("abCdeFGH123456789".replaceAll("[0-9]", "X"));

        /*or use this to replace any numbers with x*/

        System.out.println("abCdeFGH123456789".replaceAll("\\d", "X"));

        /*Replaces anything other than digits*/
        System.out.println("abCdeFGH123456789".replaceAll("\\D", "X"));

        /*trim method to remove white spaces from beginning and end of String*/
        /*\\s removes whitespaces from within the String*/

        String whiteSpace = "I have spaces and\ttabs in this line before going to new line\n";

        System.out.println(whiteSpace);

        System.out.println(whiteSpace.replaceAll("\\s", "-"));

        /*replaces just the tab and not all white spaces like new line \\n etc*/
        System.out.println(whiteSpace.replaceAll("\\t", "-"));


        whiteSpace = "I have spaces and\ttabs and a _ in this line before going to new line\n";

        System.out.println(whiteSpace);

        /*w replaces all alphabets from a-z lower case and upper case , all numbers from 0-9 and underscore_*/
        System.out.println(whiteSpace.replaceAll("\\w", "X"));


        /*b surround  all alphabets from a-z and all numbers from 0-9 and underscore_ with X
         * i.e put a X in the beginning and at end of each alphabet and/or letter*/
        System.out.println(whiteSpace.replaceAll("\\b", "X"));


        System.out.println("==========================Quantifiers=================================");

        /*Quantifiers are used to match how many times a character an item is present in the String*/

        String alphaNumeric = "abcdeee1234545";
        /*replaces anything that starts with(^) abcd and has 3 es i.e abcdeee*/
        System.out.println(alphaNumeric.replaceAll("^abcde{3}", "X"));

        /*replaces anything that starts with(^) abcd and has n number of  e s i.e
          1 or more es abcdeee*.So + means we need atleast one e./

        System.out.println(alphaNumeric.replaceAll("^abcde+", "X"));

        alphaNumeric = "abcdkfgfgf1234545";

        /*replaces anything that starts with abcd and contains anything after that i.e can contain 0 e
        * or 1 e or 2 e or  anything else as well.So below ecpression will also replace with X even if 0 e is present
        i.e if String jusr starts with abcd the replaceAll will still match*/


        System.out.println("=============================================");
        System.out.println(alphaNumeric.replaceAll("^abcde*", "X"));

        alphaNumeric = "abcdeeeee1234545";

        /*replaces anything that starts with abcd and then 2 to 5 es*/


        System.out.println(alphaNumeric.replaceAll("^abcde{2,5}", "X"));

        alphaNumeric = "abcdefghhhij";

        /*This one is tricky.Replace anything that contains 1 or more h and then 1 or more i and then a j
        * Note i* here means 0 or more i */

        System.out.println(alphaNumeric.replaceAll("h+i*j", "X"));


        System.out.println("=======================Pattern matchers=================================");
        /*Matchers are used with String , String Buffers ,String Builders etc
        * Matchers are used to find more than one occurrence of a pattern in a String
        * If we are looking at just one Pattern we can just use the above methods.*/
        StringBuilder htmlText = new StringBuilder("<h1>My heading </h1>");
        htmlText.append("<h2> Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph of text </p>");
        htmlText.append("<p>This is second paragraph of text</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>This is the summary</p>");

        /*Regular expression to match anything before or after <h2>*/
        // String h2Pattern = ".*<h2>.*";

        String h2Pattern = "<h2>";


        /*Create a instance of Pattern class*/

        Pattern pattern = Pattern.compile(h2Pattern);
        /*Or if we want the pattern to be case insenstive that is look for both upper and lower case characters*/
        // Pattern pattern1 = Pattern.compile(h2Pattern,Pattern.CASE_INSENSITIVE|Pattern.UNICODE_CASE);

        /*Create an instance of Matcher */
        Matcher matcher = pattern.matcher(htmlText);

        /*call the matches method to look for the pattern */
        System.out.println("The result is " + matcher.matches());


        /*Please note that we have to reset the matcher once we have used it i.e once we called the matcher.matches method.
         * like we used it above with matcher.matches then we have to reset it to use with
         * matcher.reset*/
        matcher.reset();
        int counter = 0;
        while (matcher.find()) {
            counter++;
            System.out.println("Occurrence " + counter + " : " + matcher.start() + " to " + matcher.end());
        }
              /*Important things to consider
              * 1. if we use reg expression String h2Pattern = ".*<h2>.*";
               matcher.matches will print true as for matches entire String has to match
               *  but matcher.start and matcher.end will print
               * starting and end point of entire String and not just <h2> tag as  ".*<h2>.*"
               * represent the entire String and not just h2 tag
               * if we want to print only the occurring indexes of <h2> we have to use the
               * below reg expression
               * String h2Pattern = "<h2>";
               * this expression will print the exact occurrences ,but for this expression
               * matcher.matches will print false*/


        /*---------------------------------------------------------------------------------*/
        /*If we are looking into finding the multiple occurrences of a pattern there is an easy way
         * to use it using group pattern .Please note that it wil start looking for reg expression only
         * in the paranthesis ()*/

      //  String h2GroupPattern = "(<h2>)";

        /*To Print everything between <h2> and </h2>*/

      //  String h2GroupPattern = "(<h2.*</h2>)";
        /*The issue with above expression is that it uses greedy quantifier .Greedy quantifiers won't stop
        * at the first occurence of </h2> but will keep looking for other </h2> and will only stop once the
        * last </h2> tag is found
        * so it will find everything in between the first <h2> and the very last</h2>
        * The solution to this is a lazy quantifier
        * it will look for the first <h2> and stop once the first </h2> is found
        * To convert a greedy quantifier to lazy quantifier all we have to do is add a ? after the
        *
        * Also note that if we were not interested in  printing empty h2 tags i.e the ones that don't contain
        * anything  between h2 tags we have to use + instead of * i.e .+ as + will only print one or more occurrences
        * and * prints 0 or more occurrences**/
         String h2GroupPattern = "(<h2.*?</h2>)";

        /*Create a instance of Pattern class*/

        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            /*group 0  contains the entire String and group 1  means the the group that contains h2 tags
            * This will print all h2's in the String* if our h2Group Pattern is just <h2>*/
            System.out.println("Occurrence: " + groupMatcher.group(1));

        }
        System.out.println("========================Group2=================================");
        /*If we just want to print the text within h2 tags and not the tags itself we use the below
        * i.e we define 3 groups <h2> the text after h2 and </h2>*/
         String h2TextGroup = "(<h2>)(.*?)(</h2>)";
       //Another intersting point is if we remove braces from around h2 and /h2 that means we are looking for a pattern
        //that has h2 and then a group .*? and then /h2 in the end do we are just looking for one group .*?
        //so for that we just need group no 1 woth group 0 the entire string
       // String h2TextGroup = "<h2>(.*?)</h2>";
       // h2TextMatcher.group(1))

        Pattern h2TextPattern = Pattern.compile(h2TextGroup);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);
        while(h2TextMatcher.find()){
            /*Here we define group 2 i.e not group 1 i.e <h2> and not group 3 i.e </h2>*/
            System.out.println("Occurrence:----------> " +h2TextMatcher.group(2));
        }

        /*Logical operators
        * We have already seen the Or operator above
        *         System.out.println("Harry".replaceAll("[Hh]arry", "Tommy"));
            i.e replace Harry or harry  with Tommy
            * And for AND operator we have "abc" i.e a followed by b followed by c
            * We also know that if we put carrot character in square brackets it becomes a not operator
            * [^]
            * Lets see an example of it below
            * */
            String tvTest = "tstvtkt";
        String tNotVRegExp = "t[^v]"; //find all t that are  not followed by v
        //Please note using the above method the last t will never get printed as [^v] is actually looking
        // for an element i.e any element other than v but atleast some element .but last t is not followed by
        // any element so it will not be added.
        //  String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);
        counter = 0;
        while (tNotVMatcher.find()){
            counter++;
            System.out.println("Occurences "+counter +" : "+tNotVMatcher.start()+" to "+tNotVMatcher.end());
        }
        /*Please note the above will only print all t that are not followed by v
        * it will not print the last t i.e t not followed by anything. the reason for that is the
        * reg expression has to be a exact match i.e t followed by something that is not v
        * The reason fo that is carrot character ^ inside square braces [] always look for some character
        * to solve this we use the not operator i.e t not followed by v but can be also
        * not followed by anything else example
        * The below is a negative look ahead expression i.e a t then ? and negative v i.e either something
        * other than v or nothing at all as we have put ? there.
        *         String tNotVRegExp = "t(?!v)";
        * if we only want ts followed by v we use equal sign
        *          String tNotVRegExp = "t(?=v)"; */


        /*Other reg expression examples*/
        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        //Start with an ( so the carrot character ^
        //Then we should have a ( as a first character [\(] . \ is used as an escape character for (
        //Then {1} quantifier means there can be only 1 (
        //Then there will be 3 nos from 1-9 . so we use quantifier {3}
        //The there should be only 1 closing parenthesis [\)]{1}
        //Then there should be only one blank space [ ]{1}
        //And then 3 nos from 1 to 9 }[0-9]{3}
        //Then one - .[\-]{1}
        //Another 4 nos from 1-9 [0-9]{4}
        //And it should end after that. that is nothing after that so we close the bracket
        //that we started right after the carrot character ^ in the very beginning and put dollar sign $

        String phoneNumber1 = "1234567890";
        String phoneNumber2= "(123) 456-7890";
        String phoneNumber3 = "123 456-7890";
        String phoneNumber4 = "(123)456-7890";


        System.out.println("phone1 "+ phoneNumber1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 "+ phoneNumber2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 "+ phoneNumber3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 "+ phoneNumber4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));


        /*Visa card validation
        * must start with a 4 then 12 digits between 0-9.this one is for a 13 digit visa card
        * Then 3 optional digits between 0-9. optional hence the ? in the end
        * ([0-9]{3})?
        * this is for 16 digit card numbers*/

        //^4[0-9]{12}([0-9]{3})?$
        String visaCard1 = "4444444444444";
        String visaCard2 = "444444444444444";
        String visaCard3 = "4444444444444444";
        String visaCard4 = "4444";

        System.out.println("visa1 "+ visaCard1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 "+ visaCard2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 "+ visaCard3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 "+ visaCard4.matches("^4[0-9]{12}([0-9]{3})?$"));







    }

}
