package rousche.botrandomevent.resources;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Inventory implements Serializable {
    public Map<String, Float> items = new HashMap<String, Float>();

    public Inventory(){

    }
}
