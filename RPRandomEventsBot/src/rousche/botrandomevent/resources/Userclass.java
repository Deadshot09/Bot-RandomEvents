package rousche.botrandomevent.resources;

import net.dv8tion.jda.core.entities.Member;

public class Userclass {
    public Member user;
    public Inventory inventory;

    public void Userclass(Member user){
        this.user = user;
        this.inventory = new Inventory();
    }

}


