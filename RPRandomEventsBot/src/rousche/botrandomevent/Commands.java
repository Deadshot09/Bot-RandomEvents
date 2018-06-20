package rousche.botrandomevent;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.resources.commandattributes;

import java.util.ArrayList;
import java.util.Arrays;

public interface Commands {
    public ArrayList<commandattributes> attrs();

    boolean called (String args[] , MessageReceivedEvent e);
    void action(String args[] , MessageReceivedEvent e);
    void exe(boolean success , MessageReceivedEvent e);

}
