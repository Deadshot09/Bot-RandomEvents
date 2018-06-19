package rousche.botrandomevent;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.Arrays;

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

        System.out.println(Arrays.toString(args));
        try {
            if (!args[0].contains(Character.toString('"')))
                return new CommandContainer(raw, bh, splitbh, invoke, args, e);
        }catch(IndexOutOfBoundsException ex){
            return new CommandContainer(raw, bh, splitbh, invoke, args, e);
        }

        String[] agrs = (String.join(" ", args)).split(Character.toString('"'));
        System.out.println(Arrays.toString(agrs));
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i = 0; i<agrs.length;i++) {
            if(i%2!=0) //value is odd
                arrayList.add(agrs[i]);
        }
        args = arrayList.toArray(new String[0]);
        System.out.println(Arrays.toString(args));
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
