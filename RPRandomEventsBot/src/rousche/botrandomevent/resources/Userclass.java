package rousche.botrandomevent.resources;

import java.io.Serializable;
import net.dv8tion.jda.core.entities.*;
import rousche.botrandomevent.Main;

public class Userclass implements Serializable {
    public String user;
    public String guild;
    public Inventory inventory;

    public Userclass(String usr, String guild){
        this.user = usr;
        this.guild = guild;
        this.inventory = new Inventory();

    }

    public User getUser(){
        return Main.jda.getUserById(this.user);
    }

}


