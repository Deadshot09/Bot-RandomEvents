package rousche.botrandomevent.commands.Classes;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.commands.Classes.inventorycommands.*;
import rousche.botrandomevent.commands.commandsCore;

public class inventorycommand extends commandsCore {


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
