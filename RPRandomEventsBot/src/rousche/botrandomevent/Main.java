package rousche.botrandomevent;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import rousche.botrandomevent.Listeners.BotListener;
import rousche.botrandomevent.commands.commandsCore;
import rousche.botrandomevent.commands.debugcommandsCore;
import rousche.botrandomevent.resources.Userclass;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public class Main {

    public static JDA jda;

    public static final CommandParser parser = new CommandParser();
    public static HashMap<String, Commands> commands = new HashMap<String, Commands>();

    public static List<Userclass> users = new ArrayList<>();

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

        System.out.print("Loading data...");
        if(load())
            System.out.println("Data loaded successfully!");
        else
            System.out.println("Data loading failed!");

        System.out.print("Loading commands...");
        commandsCore.addCommands();
        System.out.println("Commands loaded successfully!");
        System.out.print("Loading debug commands...");
        debugcommandsCore.addCommands();
        System.out.println("Debug commands loaded successfully!");
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
            List<Userclass> readCase = null;

                readCase = (List<Userclass>) objectinputstream.readObject();
                if (readCase != null)
                    users = readCase;

            return true;
        } catch (EOFException e) {
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

    public static boolean save(){
        try(
                FileOutputStream fout = new FileOutputStream("data.dat", true);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
        ){
            oos.writeObject(users);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}

