package rousche.botrandomevent;

import rousche.botrandomevent.commands.admincommandsCore;
import rousche.botrandomevent.commands.commandsCore;
import rousche.botrandomevent.commands.debugcommandsCore;
import rousche.botrandomevent.resources.Location;
import rousche.botrandomevent.resources.Travel;
import rousche.botrandomevent.resources.Userclass;

import java.io.*;
import java.util.List;

public class Load {
    public static void loadAll(){
        System.out.print("Loading user data...");
        if(load())
            System.out.println("User data loaded successfully!");
        else
            System.out.println("User data loading failed!");
        System.out.print("Loading locations...");
        if(loadLocations())
            System.out.println("Locations loaded successfully!");
        else
            System.out.println("Locations loading failed!");
        System.out.print("Loading map...");
        if(loadMap())
            System.out.println("Map loaded successfully!");
        else
            System.out.println("Map loading failed!");
        System.out.print("Loading commands...");
        commandsCore.addCommands();
        System.out.println("Commands loaded successfully!");
        System.out.print("Loading debug commands...");
        debugcommandsCore.addCommands();
        System.out.println("Debug commands loaded successfully!");
        System.out.print("Loading admin commands...");
        admincommandsCore.addCommands();
        System.out.println("Admin commands loaded successfully!");
    }
    public static void saveAll(){
        System.out.print("Saving data...");
        if(save())
            System.out.println("Save successful!");
        else
            System.out.println("Save failed!");
        System.out.print("Saving locations...");
        if(saveLocations())
            System.out.println("Save successful!");
        else
            System.out.println("Save failed!");
        System.out.print("Saving map...");
        if(saveMap())
            System.out.println("Save successful!");
        else
            System.out.println("Save failed!");
    }
    public static boolean load() {
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream("data/userdata.dat");
            objectinputstream = new ObjectInputStream(streamIn);
            List<Userclass> readCase = null;

            readCase = (List<Userclass>) objectinputstream.readObject();
            if (readCase != null)
                Main.users = readCase;
            return true;
        } catch (EOFException e) {
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Save file not found!");
            return false;
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
        try {
            new FileWriter("data/userdata.dat").close();
        }catch(IOException e){
        }catch(Exception e){
            return false;
        }
        try(
                FileOutputStream fout = new FileOutputStream("data/userdata.dat", true);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
        ){
            oos.writeObject(Main.users);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean loadLocations() {
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream("data/locations.dat");
            objectinputstream = new ObjectInputStream(streamIn);
            List<Location> readCase = null;
            readCase = (List<Location>) objectinputstream.readObject();
            if (readCase != null)
                Travel.locations = readCase;
            return true;
        } catch (EOFException e) {
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Locations file not found!");
            return false;
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
    public static boolean loadMap() {
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream("data/map.dat");
            objectinputstream = new ObjectInputStream(streamIn);
            Object[] readCase = null;
            readCase = (Object[]) objectinputstream.readObject();
            if (readCase != null)
                Travel.map = readCase;
            return true;
        } catch (EOFException e) {
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Map file not found!");
            return false;
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
    public static boolean saveLocations(){
        try {
            new FileWriter("data/locations.dat").close();
        }catch(IOException e){
        }catch(Exception e){
            return false;
        }
        try(
                FileOutputStream fout = new FileOutputStream("data/locations.dat", true);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
        ){
            oos.writeObject(Travel.locations);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean saveMap(){
        try {
            new FileWriter("data/map.dat").close();
        }catch(IOException e){
        }catch(Exception e){
            return false;
        }
        try(
                FileOutputStream fout = new FileOutputStream("data/map.dat", true);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
        ){
            oos.writeObject(Travel.map);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
