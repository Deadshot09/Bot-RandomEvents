package rousche.botrandomevent.commands.Classes.inventorycommands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Main;
import rousche.botrandomevent.resources.Userclass;

import static rousche.botrandomevent.Main.users;

public class inventoryremove {
    public static void handle(String args[] , MessageReceivedEvent e) {
        Userclass user = null;
        for (Userclass i : users) {
            if (i.user.equals(e.getAuthor().getId()))
                user = i;
        }
        if (user.equals(null))
            return;
        if(Float.parseFloat(args[2]) <= 0){
            e.getTextChannel().sendMessage("Failed: Please use a positive value!").queue();
            return;
        }
        if(user.inventory.items.containsKey(args[1]))
            user.inventory.items.put(args[1], user.inventory.items.get(args[1]) - Float.parseFloat(args[2]));
        else
            user.inventory.items.put(args[1], 0f - Float.parseFloat(args[2]));
        if(user.inventory.items.get(args[1]) <= 0f)
            user.inventory.items.remove(args[1]);
        e.getTextChannel().sendMessage("Item removed!").queue();
    }
}
