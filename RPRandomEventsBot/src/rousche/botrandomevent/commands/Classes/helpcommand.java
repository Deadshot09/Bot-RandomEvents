package rousche.botrandomevent.commands.Classes;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Main;
import rousche.botrandomevent.commands.commandsCore;
import rousche.botrandomevent.resources.commandattributes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class helpcommand extends commandsCore {
    @Override
    public ArrayList<commandattributes> attrs() {
        return(new ArrayList<commandattributes>(Arrays.asList(new commandattributes("help", "", "Displays this"))));
    }
    @Override
    public void action(String args[] , MessageReceivedEvent e){
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Commands", null);
        eb.setColor(new Color(0x4CB1FF));

        eb.addBlankField(false);

        String text = "";
        Collection<String> keys = Main.commands.keySet();
        System.out.println(keys);
        for (String key : keys) {
            System.out.println("iteration");
            for(int i = 0; i<Main.commands.get(key).attrs().size();i++)
                text = text + "!" + Main.commands.get(key).attrs().get(i).name + " " + Main.commands.get(key).attrs().get(i).args + " - " + Main.commands.get(key).attrs().get(i).desc + "\n";
        }
        eb.setDescription(text);

        e.getChannel().sendMessage(eb.build()).queue();
    }

}
