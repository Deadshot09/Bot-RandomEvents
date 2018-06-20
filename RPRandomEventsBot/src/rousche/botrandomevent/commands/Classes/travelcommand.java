package rousche.botrandomevent.commands.Classes;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.commands.commandsCore;

public class travelcommand extends commandsCore {


    @Override
    public void action(String args[] , MessageReceivedEvent e){
        String event = "";
        int random = (int) (Math.random() * ((100 - 1)+1)) + 1;
        if(args[0].toLowerCase().equals("forest")) {
            if (random <= 50) {
                event = "You hear wolves howling somewhere close behind you. You look behind and see you see a pack of direwolves sprinting toward you !";
            } else {
                event = "You can hear the sounds of a raging battle in front of you. You hurry toward the sounds and there you see a caravan being attacked by bandits!";
            }
        }else if (args[0].toLowerCase().equals("sea")){
            if (random <= 50) {
                event = "Your mast gets snapped by the almighty kraken!";
            } else {
                event = "You see a ship getting raided by pirates in the distance!";
            }
        }
        e.getTextChannel().sendMessage(event).queue();

    }



}
