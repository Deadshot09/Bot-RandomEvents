package rousche.botrandomevent.commands;

import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Commands;
import rousche.botrandomevent.Main;
import rousche.botrandomevent.commands.Debug.*;

import static rousche.botrandomevent.Main.ignoreRoles;


public class debugcommandsCore implements Commands {

    public static void addCommands() {
        Main.commands.put("save", new savecommand());
        Main.commands.put("newacc", new newacccommand());
        Main.commands.put("listacc", new listacccommand());
        Main.commands.put("getroles", new getrolescommand());
    }

    public boolean isBotCommander(Member user){
        if(user.getRoles().contains(user.getGuild().getRoleById("455525914319519767"))||ignoreRoles)
            return true;
        return false;
    }

    @Override
    public boolean called (String args[] , MessageReceivedEvent e){
        if(isBotCommander(e.getMember()))
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
}
