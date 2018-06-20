package rousche.botrandomevent.commands.Classes.inventorycommands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Main;
import rousche.botrandomevent.resources.Userclass;
import java.util.Collection;
import net.dv8tion.jda.core.EmbedBuilder;
import java.awt.Color;

public class inventorylist {
    public static void handle(String args[] , MessageReceivedEvent e){
        Userclass user = null;
        for(Userclass i : Main.users){
            if(i.user.equals(e.getAuthor().getId()))
                user = i;
        }



        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(e.getAuthor().getName() + "'s Inventory", null);
        eb.setColor(new Color(0xFFD389));

        eb.addBlankField(false);

        String text = "";
        Collection<String> keys = user.inventory.items.keySet();
        for (String key : keys) {
            text = text + key + ", " + ((user.inventory.items.get(key).intValue()==user.inventory.items.get(key)) ? user.inventory.items.get(key).intValue() : user.inventory.items.get(key).toString()) + "\n";
        }
        eb.setDescription(text);

        e.getChannel().sendMessage(eb.build()).queue();

    }

}
