package rousche.botrandomevent;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;

public class CommandParser {

    public CommandContainer parse(String rw,MessageReceivedEvent e){
        ArrayList<String> split = new ArrayList<>();
        String raw = rw;
        String bh = raw.replace("!","");
        String[] splitbh = bh.split(" ");
        for(String s : splitbh){
            split.add(s);
        }
        String invoke = split.get(0);
        String[] args = new String[split.size() - 1];
        split.subList(1,split.size()).toArray(args);

        return new CommandContainer(raw, bh,splitbh,invoke,args,e);
    }


    public class CommandContainer{
        public final String raw;
        public final String bh;
        public final String[] splitbh;
        public final String invoke;
        public final String[] args;
        public final MessageReceivedEvent e;

        public CommandContainer(String rw,String bh,String[] splitbh,String invoke,String[] args,MessageReceivedEvent e){
            this.raw = rw;
            this.bh = bh;
            this.splitbh = splitbh;
            this.invoke = invoke;
            this.args = args;
            this.e = e;


        }
    }


}
