package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class album {
    private String nameofalbum;
    private String artist;
    private ArrayList<song> songs;
    public album(String nameofalbum, String artist ){
        this.nameofalbum=nameofalbum;
        this.artist=artist;
        this.songs=new ArrayList<song>();
    }
    public album(){
        //Empty Constructor
    }
    public song findsong(String name){
        for(song checked: songs){
            if(checked.getName().equals(name)){
                return checked;
            }
        }
        return null;
    }
    public boolean addsong(String name, double duration){
        if(findsong(name)!=null){
            songs.add(new song(name,duration));
       //     System.out.println(name+"Successfully added");
            return true;
            //Will check if song exist in list or not
        }
        else{
        //    System.out.println(name+"Already exist");
            return false;
        }
    }
    public boolean addtoplaylist(int tracknumber, LinkedList<song> Playlist){
        int index= tracknumber-1;//Index starts from 0 while tracknumber starts from 1
        if(index>0&&index<=this.songs.size()){
            Playlist.add(this.songs.get(index));//Will add song
            return true;
        }
    //    System.out.println("This album does not have song with tarcknumber "+tracknumber);
        return false;

    }
    public boolean addtoplaylist(String name, LinkedList<song> Playlist){
        for(song checked: this.songs){
            if(checked.getName().equals(name)){
               Playlist.add(checked);
               return true;
            }
        }
        //User can add song using songname or its tracknumber, that's whu two methods with same name but different parameters
      //  System.out.println("There is no such song");
        return false;
    }

}
