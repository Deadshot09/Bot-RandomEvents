package rousche.botrandomevent.commands;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Commands;
import rousche.botrandomevent.Main;
import rousche.botrandomevent.commands.Admin.*;
import rousche.botrandomevent.resources.commandattributes;

import java.util.ArrayList;
import java.util.Arrays;

import static rousche.botrandomevent.Main.ignoreRoles;


public class admincommandsCore implements Commands {
    public static void addCommands() {
        Main.commands.put("delacc", new delacccommand());
    }

    public static boolean isAdmin(Member user){
        if(user.getRoles().contains(user.getGuild().getRoleById("455188844657246220"))||ignoreRoles)
            return true;
        return false;
    }

    @Override
    public boolean called (String args[] , MessageReceivedEvent e){
        if(isAdmin(e.getMember()))
            return true;
        else {
            e.getTextChannel().sendMessage("Denied").queue();
            return false;
        }
    }

    @Override
    public void action(String args[] , MessageReceivedEvent e){
    }

    @Override
    public void exe(boolean success , MessageReceivedEvent e){}

    @Override
    public ArrayList<commandattributes> attrs(){
        return(new ArrayList<commandattributes>(Arrays.asList(new commandattributes("","",""))));
    }
}
