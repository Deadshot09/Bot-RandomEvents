package rousche.botrandomevent.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Commands;
import rousche.botrandomevent.Main;

import rousche.botrandomevent.commands.Classes.*;

import rousche.botrandomevent.commands.Multi.locationcommand;
import rousche.botrandomevent.resources.Handler;
import rousche.botrandomevent.resources.Userclass;

public class commandsCore implements Commands {

    public static void addCommands(){
        Main.commands.put("travel", new travelcommand());
        Main.commands.put("inventory", new inventorycommand());
        Main.commands.put("location", new locationcommand());
    }

    @Override
    public boolean called (String args[] , MessageReceivedEvent e) {
        if (!Handler.hasUser(e.getAuthor())){
            e.getTextChannel().sendMessage("You do not have an account! Creating...").queue();
            Main.users.add(new Userclass(e.getAuthor().getId(), e.getGuild().getId()));
        }
        return true;
    }

    @Override
    public void exe(boolean success , MessageReceivedEvent e){}

    @Override
    public void action(String args[] , MessageReceivedEvent e){}
}
