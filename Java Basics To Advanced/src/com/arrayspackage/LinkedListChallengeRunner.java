
package com.arrayspackage;
import java.util.*;

public class LinkedListChallengeRunner {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {


        Album album = new Album("Toronto", "Sidhu moosewala");
        album.addSong("Toronto sher", 4.30);
        album.addSong("old skool", 4.40);
        album.addSong("tibeyan da putt", 4.50);
        album.addSong("pal pal ve", 5.20);
        album.addSong("mulakat", 5.15);
        albums.add(album);

        album = new Album("Nindran", "Babbu mann");
        album.addSong("Snapchat", 4.30);
        album.addSong("Mitran di chattri", 4.40);
        album.addSong("gypsy kalli", 4.50);
        album.addSong("pyaas", 5.20);
        album.addSong("clickan", 5.15);
        albums.add(album);


        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("Toronto sher",playList);
        albums.get(0).addToPlayList("tibeyan da putt",playList);
        albums.get(0).addToPlayList("old skool",playList);
        albums.get(1).addToPlayList("clickan",playList);


        albums.get(1).addToPlayList(2,playList);
        albums.get(1).addToPlayList(1,playList);
        albums.get(0).addToPlayList(10,playList); //not in the album
        albums.get(1).addToPlayList(15,playList); //not in the album

        System.out.println("About to play playlist");

        play(playList);
    }

    private static void play(LinkedList<Song>playList){
        Scanner scanner =  new Scanner(System.in);
        boolean quit =false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size()==0){
            System.out.println("No songs in the playlist");
            return;
        }
        else
        {System.out.println("Now playing "+listIterator.next().toString());}
       while(!quit){
           int action = scanner.nextInt();
           scanner.nextLine();
           switch (action){
               case 0:
                   System.out.println("Playlist complete");
               case 1:

                   if(!forward) {
                       if (listIterator.hasNext()) {
                          listIterator.next();
                       }
                       forward = true;
                   }
                       if(listIterator.hasNext()){
                           System.out.println("Now playing "+listIterator.next().toString());
                       }
                       else{
                           System.out.println("You have reached the end of the playlist");
                           forward = false;
                       }
                       break;

               case 2:

                   if(forward) {

                       if (listIterator.hasPrevious()) {
                             listIterator.previous();
                       }
                       forward = false;

                   }
                   if(listIterator.hasPrevious()){
                       System.out.println("Now playing "+listIterator.previous().toString());
                   }
                   else{
                       System.out.println("You have reached the start of the playlist");
                       forward = true;
                   }
                   break;
               case 3:
                   if(forward){
                       if(listIterator.hasPrevious()){
                          System.out.println("Now playing "+listIterator.previous().toString());
                          forward = false;
                       }
                       else {
                           System.out.println("You are at the start of the list");

                        }
                   }
                   else
                   {
                       if(listIterator.hasNext()){
                           System.out.println("Now playing "+listIterator.next().toString());
                           forward = true;
                       }
                       else{
                           System.out.println("You have reached the end of the list");
                       }
                   }
                       break;
               case 4:
                   printList(playList);
                   break;
               case 5:
                   printMenu();
                   break;
               case 6:
                   if(playList.size()>0){
                       listIterator.remove();
                       if(listIterator.hasNext()){
                           System.out.println("Now playing "+listIterator.next());
                           forward = true;
                       }
                       else if(listIterator.hasPrevious()){
                           System.out.println("Now playing "+listIterator.previous());
                           forward = false;
                       }
                   }
                   break;
           }
       }

    }


    private static void printMenu(){
        System.out.println("Available actions \n press");
        System.out.println("0 -to quit\n"+
                "1- to play the next song\n"+
                "2- to play previous songs \n"+
                "3 - to replay the current song \n"+
                "4 - list songs in the playlist\n"+
                "5 - print available actions.\n"+
                "6 - delete a song");
    }

    private static void printList(LinkedList<Song>playList){
        Iterator<Song> myIterator = playList.iterator();
        System.out.println("===================================================");
        while(myIterator.hasNext()){
            System.out.println(myIterator.next());
        }
    }


}
