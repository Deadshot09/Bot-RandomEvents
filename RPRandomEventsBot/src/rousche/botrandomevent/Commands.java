package rousche.botrandomevent;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface Commands {

    boolean called (String args[] , MessageReceivedEvent e);
    void action(String args[] , MessageReceivedEvent e);
    void exe(boolean success , MessageReceivedEvent e);
}
