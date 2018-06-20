package rousche.botrandomevent.commands.Debug;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Load;
import rousche.botrandomevent.commands.debugcommandsCore;
import rousche.botrandomevent.resources.commandattributes;

import java.util.ArrayList;
import java.util.Arrays;

public class savecommand extends debugcommandsCore {
    @Override
    public ArrayList<commandattributes> attrs() {
        return (new ArrayList<commandattributes>(Arrays.asList(new commandattributes("save", "", "Saves data to files."))));
    }
    @Override
    public void action(String args[], MessageReceivedEvent e) {
        e.getTextChannel().sendMessage("Attempting save...").queue();
        Load.saveAll();

    }
}