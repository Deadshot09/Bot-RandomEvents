package rousche.botrandomevent.commands.Admin.locationcommands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.resources.Location;
import rousche.botrandomevent.resources.Travel;

public class locationremove {
    public static void handle(String args[] , MessageReceivedEvent e) {
        Location loc = null;
        for(Location loca : Travel.locations){
            if(loca.name.toLowerCase().equals(args[1].toLowerCase())) {
                loc = loca;
            }
        }
        if (loc == null) {
            e.getChannel().sendMessage("Location not found!").queue();
            return;
        }
        Travel.locations.remove(loc);
        e.getChannel().sendMessage("Location deleted!").queue();
    }
}
