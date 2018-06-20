package rousche.botrandomevent.commands.Debug;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Load;
import rousche.botrandomevent.commands.debugcommandsCore;

public class savecommand extends debugcommandsCore {
    @Override
    public void action(String args[], MessageReceivedEvent e) {
        e.getTextChannel().sendMessage("Attempting save...").queue();
        Load.saveAll();

    }
}