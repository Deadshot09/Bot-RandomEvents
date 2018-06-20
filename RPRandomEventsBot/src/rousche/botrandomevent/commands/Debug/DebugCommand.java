package rousche.botrandomevent.commands.Debug;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.commands.debugcommandsCore;
import rousche.botrandomevent.resources.commandattributes;

import java.util.ArrayList;
import java.util.Arrays;

public class debugcommand extends debugcommandsCore {
    @Override
    public ArrayList<commandattributes> attrs() {
        return(new ArrayList<commandattributes>(Arrays.asList(new commandattributes("debug", "", "Does nothing in particular"))));
    }
    @Override
    public void action(String args[] , MessageReceivedEvent e){
        e.getTextChannel().sendMessage("fortnite good game").queue();

    }

}
