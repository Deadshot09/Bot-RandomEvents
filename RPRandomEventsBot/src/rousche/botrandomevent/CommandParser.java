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

        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(args));
        ArrayList<String> arrayListOutput = new ArrayList<String>();
        Integer o = 0;
        Boolean inString = false;
        while(o <= args.length-1) {
            if (arrayList.get(o).startsWith(Character.toString('"')) && arrayList.get(o).endsWith(Character.toString('"'))){
                arrayListOutput.add(arrayList.get(o).substring(1, arrayList.get(o).length()-1));
            }else if (arrayList.get(o).startsWith(Character.toString('"')) && !inString){
                inString = true;
                arrayListOutput.add(arrayList.get(o).substring(1));
            }else if(!inString)
                arrayListOutput.add(arrayList.get(o));
            else if (arrayList.get(o).endsWith(Character.toString('"'))){
                inString = false;
                arrayListOutput.set(arrayListOutput.size()-1, arrayListOutput.get(arrayListOutput.size()-1) + " " + arrayList.get(o).substring(0, arrayList.get(o).length() - 1));
            }else if (inString)
                arrayListOutput.set(arrayListOutput.size()-1, arrayListOutput.get(arrayListOutput.size()-1) + " " + arrayList.get(o));
            o++;
        }
        args = arrayListOutput.toArray(new String[0]);
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
