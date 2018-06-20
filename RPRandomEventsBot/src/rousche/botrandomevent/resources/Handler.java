package rousche.botrandomevent.resources;

import net.dv8tion.jda.core.entities.User;
import rousche.botrandomevent.Main;

public class Handler {
    public static boolean hasUser(User usr){
        for(Userclass i : Main.users){
            if(i.user.equals(usr.getId()))
                return true;
        }
        return false;
    }





}
