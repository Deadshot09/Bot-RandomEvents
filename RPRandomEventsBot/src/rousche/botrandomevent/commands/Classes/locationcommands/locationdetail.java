package rousche.botrandomevent.commands.Classes.locationcommands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.resources.Location;
import rousche.botrandomevent.resources.Travel;

import java.awt.*;
import java.util.Collection;

public class locationdetail {
    public static void handle(String args[] , MessageReceivedEvent e){
        Location loc = new Location("null","null","null");
        for(Location loca : Travel.locations){
            if(loca.name.toLowerCase().equals(args[1].toLowerCase())) {
                loc = loca;
                break;
            }

        }
        if(loc.name.equals("null")){
            e.getChannel().sendMessage("Invalid location!").queue();
            return;
        }

        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(loc.name, null);
        eb.setColor(new Color(0xFFFFFF));

        eb.addBlankField(false);

        eb.setDescription(loc.desc);

        e.getTextChannel().sendMessage(eb.build()).queue();

    }

}
