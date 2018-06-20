package rousche.botrandomevent.commands.Debug;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.commands.debugcommandsCore;
import rousche.botrandomevent.resources.commandattributes;

import java.util.ArrayList;
import java.util.Arrays;

public class getrolescommand extends debugcommandsCore {
    @Override
    public ArrayList<commandattributes> attrs() {
        return(new ArrayList<commandattributes>(Arrays.asList(new commandattributes("getroles", "[Mention user]", "Returns all role IDs possessed by this user."))));
    }
        @Override
    public void action(String args[] , MessageReceivedEvent e){
        for(Member member : e.getMessage().getMentionedMembers()){
            e.getTextChannel().sendMessage(member.getRoles().toString()).queue();
        }

    }

}
