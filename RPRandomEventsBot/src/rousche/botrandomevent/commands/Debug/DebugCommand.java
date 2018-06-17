package rousche.botrandomevent.commands.Debug;

import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Commands;
import rousche.botrandomevent.Main;


public class DebugCommand implements Commands {
    public void DebugCommand(){
        //Main.commands.put("")

    }

    public boolean isBotCommander(Member user){
        if(user.getRoles().contains(user.getGuild().getRoleById("455525914319519767")))
            return true;
        return false;
    }

    @Override
    public boolean called (String args[] , MessageReceivedEvent e){
        return true;
    }
    @Override
    public void action(String args[] , MessageReceivedEvent e){
    }
    @Override
    public void exe(boolean success , MessageReceivedEvent e){}
}
