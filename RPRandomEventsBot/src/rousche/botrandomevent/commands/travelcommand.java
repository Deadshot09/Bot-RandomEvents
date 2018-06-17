package rousche.botrandomevent.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Commands;

public class travelcommand implements Commands {

    @Override
    public boolean called (String args[] , MessageReceivedEvent e){
        return true;
    }
    @Override
    public void action(String args[] , MessageReceivedEvent e){
        String event = "";
        int random = (int) (Math.random() * ((100 - 1)+1)) + 1;
        if (random <= 50){
            event = "You hear wolves howling somewhere close behind you. You look behind and see you see a pack of direwolves sprinting toward you !";
        }
        else {
            event = "You can hear the sounds of a raging battle in front of you. You hurry toward the sounds and there you see a caravan being attacked by bandits!";
        }
        e.getTextChannel().sendMessage(event).queue();
    }
    @Override
    public void exe(boolean success , MessageReceivedEvent e){

    }


}
