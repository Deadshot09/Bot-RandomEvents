package rousche.botrandomevent.commands.Admin.locationcommands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.commands.Classes.locationcommands.locationdetail;
import rousche.botrandomevent.commands.Classes.locationcommands.locationlist;
import rousche.botrandomevent.resources.Location;
import rousche.botrandomevent.resources.Travel;

public class locationchange {
    public static void handle(String args[] , MessageReceivedEvent e) {
        Location loc = null;
        for(Location loca : Travel.locations){
            if(loca.name.toLowerCase().equals(args[1].toLowerCase())) {
                loc = loca;
            }
        }
        if (loc==null) {
            e.getChannel().sendMessage("Location not found!").queue();
            return;
        }
        if(args[2].toLowerCase().equals("name")){
            loc.name = args[3];
        }else if(args[2].toLowerCase().equals("short")) {
            loc.shortdesc = args[3];
        }else if(args[2].toLowerCase().equals("long")) {
            loc.desc = args[3];
        }else{
            e.getChannel().sendMessage("Unknown statistic!").queue();
            return;
        }
        e.getChannel().sendMessage("Location updated!").queue();
    }
}
