package rousche.botrandomevent.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.json.JSONObject;
import rousche.botrandomevent.Commands;
import rousche.botrandomevent.Main;

import javax.swing.text.html.parser.Parser;
import java.io.FileReader;

public class inventorycommand implements Commands {


    @Override
    public void action(String args[] , MessageReceivedEvent e){


        if(false) { //Add checking whether user already has an inventory

            //Do stuff
        }
    }







    @Override
    public boolean called (String args[] , MessageReceivedEvent e){ return true; }

    @Override
    public void exe(boolean success , MessageReceivedEvent e){ }
}
