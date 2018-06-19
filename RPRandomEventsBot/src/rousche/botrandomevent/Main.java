package rousche.botrandomevent;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import rousche.botrandomevent.Listeners.BotListener;
import rousche.botrandomevent.resources.Userclass;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public class Main {

    public static JDA jda;

    public static final CommandParser parser = new CommandParser();
    public static HashMap<String, Commands> commands = new HashMap<String, Commands>();

    public static List<Userclass> users = new ArrayList<>();


    public static final boolean ignoreRoles = true;


    public static void main(String[] args) {

        JDABuilder builder = new JDABuilder(AccountType.BOT);

        builder.setToken(token.token);
        builder.setAutoReconnect(true);
        builder.setGame(Game.watching("YOU"));
        builder.addEventListener(new BotListener());

        try {
            jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Load.loadAll();
    }

    public static void handleCommand(CommandParser.CommandContainer cmd) {
        if (commands.containsKey(cmd.invoke)) {
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.e);
            if (safe) {
                commands.get(cmd.invoke).action(cmd.args, cmd.e);
                commands.get(cmd.invoke).exe(safe, cmd.e);
            } else {
                commands.get(cmd.invoke).exe(safe, cmd.e);
            }
        }
    }


}

