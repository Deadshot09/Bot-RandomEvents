package rousche.botrandomevent.commands.Multi;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Main;
import rousche.botrandomevent.commands.Admin.locationcommands.*;
import rousche.botrandomevent.commands.Classes.locationcommands.*;
import rousche.botrandomevent.commands.admincommandsCore;
import rousche.botrandomevent.commands.commandsCore;
import rousche.botrandomevent.resources.Handler;
import rousche.botrandomevent.resources.Userclass;
import rousche.botrandomevent.resources.commandattributes;

import java.util.ArrayList;
import java.util.Arrays;


public class locationcommand extends commandsCore {
    @Override
    public ArrayList<commandattributes> attrs() {
         return(new ArrayList<commandattributes>(Arrays.asList(new commandattributes("location list", "", "Returns all locations.s"),
                new commandattributes("location detail", "[Name]", "Returns a longer description of a location."),
                new commandattributes("location add", "[Name] [Short desc] [Long desc]", "Adds a location to the database."),
                new commandattributes("location remove", "[Name]", "Removes a location from the database."),
                new commandattributes("location change", "[name] <name/short/long> [New value]", "Changes a value of a location."))));
    }
    @Override
    public void action(String args[] , MessageReceivedEvent e){
        String x = args[0].toLowerCase();

        if(x.equals("list") && calledCmds(e)){
            locationlist.handle(args, e);
        }else if(x.equals("detail") && calledCmds(e)) {
            locationdetail.handle(args, e);
        }else if(x.equals("add") && calledAdminCmds(e)){
            locationadd.handle(args, e);
        }else if(x.equals("remove") && calledAdminCmds(e)){
            locationremove.handle(args, e);
        }else if(x.equals("change") && calledAdminCmds(e)){
            locationchange.handle(args, e);
        }else{
            e.getChannel().sendMessage("Unknown argument!").queue();
        }
    }
    public boolean calledAdminCmds (MessageReceivedEvent e){
        if(admincommandsCore.isAdmin(e.getMember()))
            return true;
        else {
            e.getTextChannel().sendMessage("Denied").queue();
            return false;
        }
    }
    public boolean calledCmds (MessageReceivedEvent e) {
        if (!Handler.hasUser(e.getAuthor())){
            e.getTextChannel().sendMessage("You do not have an account! Creating...").queue();
            Main.users.add(new Userclass(e.getAuthor().getId(), e.getGuild().getId()));
        }
        return true;
    }
}
