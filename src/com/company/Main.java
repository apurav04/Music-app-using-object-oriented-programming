package com.company;

import java.util.*;

public class Main {
    private static ArrayList<album> albums = new ArrayList<>();//Defined as property of class

    public static void main(String[] args) {


	album Album = new album("Album1","Weekend");
    Album.addsong("Less than zero",4.5);
    Album.addsong("Call out my name",3.08);
    Album.addsong("Take my breath",3.05);
    albums.add(Album);

    Album = new album("Album 2","Eminem");
    Album.addsong("Rapgod",6.7);
    Album.addsong("Stan",8.07);
    Album.addsong("Love the way you lie",5.5);
    albums.add(Album);

    LinkedList<song> playlist1 = new LinkedList<>();
    albums.get(0).addtoplaylist("Stan",playlist1);
    albums.get(0).addtoplaylist("Take my breath",playlist1);
    albums.get(1).addtoplaylist("Less than zero",playlist1);
    albums.get(1).addtoplaylist("Call out my name",playlist1);
    System.out.println(playlist1.size());

    play(playlist1);
    printmenu();



    }
    private static void play(LinkedList<song> playlist){
        Scanner s = new Scanner(System.in);
        boolean quit = false;
        boolean forward= true;
        ListIterator<song> listIterator=playlist.listIterator();

        if(playlist.size()==0){
            System.out.println("This playlist is empty");
        }
        else{
            System.out.println("Now playing"+listIterator.next().toString());//Wil print current song
            printmenu();
        }
        while(!quit){
            int action = s.nextInt();
            printmenu();
            switch(action){
                case 0:
                    System.out.println("Playlist complete");
                    quit =true;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("now playing"+listIterator.next().toString());
                    }
                    else{
                        System.out.println("Reached to end of playlist");
                        forward = false;

                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing"+listIterator.previous().toString());
                        }
                        else{
                            System.out.println("We are at first song");
                        }


                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing"+listIterator.previous().toString());
                            forward=false;
                        }
                        else{
                            System.out.println("We are at first song");
                        }

                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing"+listIterator.next().toString());
                            forward = true;
                        }
                        else{
                            System.out.println("We are at end of list");
                        }
                    }
                    break;
                case 4:
                    printlist(playlist);
                    break;
                case 5:
                    printmenu();
                    break;
                case 6:
                    if(playlist.size()>0){
                        listIterator.remove();
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing"+listIterator.next().toString());
                       // forward=true;
                    }
                    else{
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing"+listIterator.previous().toString());
                        }

                    }

            }
        }



    }

    private static void printmenu (){
        System.out.println("Available optons");
        System.out.println("0-Quit\n"+"1-Play next song\n"+
                "2-Play Previous song\n"+
                "3- Replay current song\n"+
                "4-List of all songs\n"+
                "5-Print all available options\n"
                +"6=Delete current song");
    }
    private static void printlist(LinkedList<song> playlist){
        Iterator<song> iterator= playlist.iterator();
        System.out.println("------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------------");
    }

}
