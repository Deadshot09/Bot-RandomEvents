package rousche.botrandomevent.commands.Admin.locationcommands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Main;
import rousche.botrandomevent.resources.Location;
import rousche.botrandomevent.resources.Travel;
import rousche.botrandomevent.resources.Userclass;

public class locationadd {
    public static void handle(String args[] , MessageReceivedEvent e) {
        Location loc = null;
        for(Location loca : Travel.locations){
            if(loca.name.toLowerCase().equals(args[1].toLowerCase())) {
                e.getChannel().sendMessage("Location with this name already exists!").queue();
                return;
            }
        }
        Travel.locations.add(new Location(args[1], args[2], args[3]));

        e.getTextChannel().sendMessage("Location added!").queue();
    }
}
