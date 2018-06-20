package rousche.botrandomevent.commands.Classes.locationcommands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.resources.Location;
import rousche.botrandomevent.resources.Travel;

import java.awt.*;

public class locationlist {
    public static void handle(String args[] , MessageReceivedEvent e){

        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Locations", null);
        eb.setColor(new Color(0xFFFFFF));

        eb.addBlankField(false);

        String text = "";
        for (Location loc : Travel.locations) {
            text = text + loc.name + " : " + loc.shortdesc + "\n";
        }
        eb.setDescription(text);

        e.getTextChannel().sendMessage(eb.build()).queue();
    }

}
