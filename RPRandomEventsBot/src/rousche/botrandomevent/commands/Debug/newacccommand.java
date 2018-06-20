package rousche.botrandomevent.commands.Debug;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Main;
import rousche.botrandomevent.commands.debugcommandsCore;
import rousche.botrandomevent.resources.Userclass;

public class newacccommand extends debugcommandsCore {
    @Override
    public void action(String args[] , MessageReceivedEvent e){
        e.getTextChannel().sendMessage("Creating account").queue();
        Main.users.add(new Userclass(e.getMember().getUser().getId(),e.getGuild().getId()));
    }

}
