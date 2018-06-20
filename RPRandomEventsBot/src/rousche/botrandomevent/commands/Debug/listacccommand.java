package rousche.botrandomevent.commands.Debug;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Main;
import rousche.botrandomevent.commands.debugcommandsCore;
import rousche.botrandomevent.resources.Userclass;
import rousche.botrandomevent.resources.commandattributes;

import java.util.ArrayList;
import java.util.Arrays;

public class listacccommand extends debugcommandsCore {
    @Override
    public ArrayList<commandattributes> attrs() {
        return(new ArrayList<commandattributes>(Arrays.asList(new commandattributes("listacc", "", "Lists all saved accounts."))));
    }
        @Override
    public void action(String args[] , MessageReceivedEvent e){
        for(Userclass i : Main.users){
            e.getTextChannel().sendMessage(i.user).queue();
        }
        System.out.println(Main.users);
    }
}
