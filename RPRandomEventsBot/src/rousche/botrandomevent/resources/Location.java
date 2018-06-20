package rousche.botrandomevent.resources;

import java.io.Serializable;

public class Location implements Serializable {
    public String name;
    public String shortdesc;
    public String desc;
    public Location(String name, String shortdesc, String desc){
        this.name = name;
        this.shortdesc = shortdesc;
        this.desc = desc;
    }
}
