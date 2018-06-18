package rousche.botrandomevent.commands.Debug;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.commands.debugcommandsCore;

public class debugcommand extends debugcommandsCore {
    @Override
    public void action(String args[] , MessageReceivedEvent e){
        e.getTextChannel().sendMessage("fortnite good game").queue();

    }

}
