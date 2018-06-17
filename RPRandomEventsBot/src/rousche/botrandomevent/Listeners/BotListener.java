package rousche.botrandomevent.Listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import rousche.botrandomevent.Main;

public class BotListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getMessage().getContentDisplay().equals("Hello")){
            e.getTextChannel().sendMessage("Hi!").queue();
        }
        else if (e.getMessage().getContentRaw().startsWith("!") && !e.getMessage().getAuthor().getId().equals(e.getJDA().getSelfUser().getId()))
        Main.handleCommand(Main.parser.parse(e.getMessage().getContentRaw().toLowerCase(), e));
        }
    }

