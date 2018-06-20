package rousche.botrandomevent.commands.Debug;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.commands.debugcommandsCore;

public class getrolescommand extends debugcommandsCore {
    @Override
    public void action(String args[] , MessageReceivedEvent e){
        for(Member member : e.getMessage().getMentionedMembers()){
            e.getTextChannel().sendMessage(member.getRoles().toString()).queue();
        }

    }

}
