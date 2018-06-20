package rousche.botrandomevent.commands.Classes;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.commands.Classes.inventorycommands.*;
import rousche.botrandomevent.commands.commandsCore;
import rousche.botrandomevent.resources.commandattributes;

import java.util.ArrayList;
import java.util.Arrays;

public class inventorycommand extends commandsCore {
    @Override
    public ArrayList<commandattributes> attrs() {
        return (new ArrayList<commandattributes>(Arrays.asList(new commandattributes("list", "", "Displays list of all inventory items."),
                new commandattributes("add", "[Item] [Amount]", "Adds x amount of an item to your inventory."),
                new commandattributes("remove", "[Item] [Amount]", "Removes x amount of an item to your inventory."))));
    }
    @Override
    public void action(String args[] , MessageReceivedEvent e){
        String x = args[0];
        if(x.equals("list")){
            inventorylist.handle(args, e);
        }else if(x.equals("add")){
            inventoryadd.handle(args, e);
        }else if(x.equals("remove")){
            inventoryremove.handle(args, e);
        }

    }
}
