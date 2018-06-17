package rousche.botrandomevent;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import rousche.botrandomevent.Listeners.BotListener;
import rousche.botrandomevent.commands.Debug.DebugCommand;
import rousche.botrandomevent.commands.travelcommand;
import rousche.botrandomevent.resources.Userclass;

import javax.security.auth.login.LoginException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public class Main {

    public static JDA jda;

    public static final CommandParser parser = new CommandParser();
    public static HashMap<String, Commands> commands = new HashMap<String, Commands>();

    public static List<Userclass> users = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("Loading data...");
        if(load())
            System.out.print("Data loaded successfully!");
        else
            System.out.print("Data loading failed!");

        JDABuilder builder = new JDABuilder(AccountType.BOT);

        builder.setToken(token.token);
        builder.setAutoReconnect(true);
        builder.setGame(Game.watching("YOU"));
        builder.addEventListener(new BotListener());

        commands.put("travel", new travelcommand());
        commands.put("debug", new DebugCommand());
        try {
            jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public static boolean load() {
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream("data.dat");
            objectinputstream = new ObjectInputStream(streamIn);
            Userclass readCase = null;
            do {
                readCase = (Userclass) objectinputstream.readObject();
                if (readCase != null) {
                    users.add(readCase);
                }
            } while (readCase != null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectinputstream != null) {
                try {
                    objectinputstream.close();
                }catch(Exception e){}
            }
        }
        return false;
    }
}

