package com.company;

public class song {
    String name;
    Double duration;
    public song(String name, double duration){
        this.name = name;
        this.duration=duration;
    }
    public song(){
        //Empty Constructor
    }
    public String getName(){
        return name;
    }
    public double getduration(){
        return duration;
    }

    @Override
    public String toString() {
        return "song{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
        //Will print whatever we have in this class
    }

}
