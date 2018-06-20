package rousche.botrandomevent.commands.Admin;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import rousche.botrandomevent.Main;
import rousche.botrandomevent.commands.admincommandsCore;
import rousche.botrandomevent.commands.debugcommandsCore;
import rousche.botrandomevent.resources.Userclass;

import java.util.ArrayList;
import java.util.List;

import static rousche.botrandomevent.Main.users;

public class delacccommand extends admincommandsCore {
    @Override
    public void action(String args[] , MessageReceivedEvent e) {
        List<Userclass> todel = new ArrayList<Userclass>();
        for (Member mem : e.getMessage().getMentionedMembers()) {
            for (Userclass user : users) {
                if (user.user.equals(mem.getUser().getId())) {
                    todel.add(user);
                }
            }
        }
        for(Userclass user : todel) {
            e.getTextChannel().sendMessage(Main.jda.getUserById(user.user).getName() + "'s account has been removed!").queue();
            users.remove(user);
        }
    }
}
