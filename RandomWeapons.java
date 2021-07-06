import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
public class RandomWeapons{
    private static Random RNG = new Random();
    private static Scanner scanner = new Scanner(System.in);
    private static HashSet<Weapon> usedWeapons = new HashSet<>();

    public static Weapon pickRandomWeapon(ArrayList<Weapon> weapons){
        int randomNum = RNG.nextInt(weapons.size());
        Weapon w = weapons.get(randomNum);
        while(usedWeapons.contains(w)){
            randomNum = RNG.nextInt(weapons.size());
            w = weapons.get(randomNum);
        }
        usedWeapons.add(w);
        return weapons.get(randomNum);
    }

    public static void main(String[] args){
        ArrayList<Weapon> weaponLst = new ArrayList<>();

        String[] weaponNames = new String[]{"Engraved Arming Sword", "Rokari Keenblade",
            "Heartsplitter", "Vestal's Wrath", "Spellsword's Charm", "Duelist's Edge", 
            "Mistcutter", "Gemini Stranded", "Gemini Esper", "Ritual Dagger", "High Arcanist's Blade", 
            "Knight-blooded Crest"};
        String[] weaponPicLocations = new String[]{"images/Arming-Sword.png", "images/Keenblade.png", 
            "images/Heartsplitter.png", "images/Vestalswrath.png", "images/Spellswordschart.png", "images/DuelistsEdge.png",
            "images/Mistcutter.png", "images/GeminiStranded.png", "images/GeminiEsper.png", "images/RitualDagger.png", 
            "images/HighArcanistsBlade.png", "images/Knightbloodedcrest.png"};
        for(int i = 0; i < weaponNames.length; i++){
            weaponLst.add(new Weapon(weaponPicLocations[i], weaponNames[i]));
        }

        System.out.print("Hello! Press Enter to get your first 2 weapons: ");
        scanner.nextLine();

        Weapon w1 = pickRandomWeapon(weaponLst);
        Weapon w2 = pickRandomWeapon(weaponLst);

        System.out.println(w1 + " and " + w2);

        for(int i = 0; i < 3; i++){
            int reroll = -1;
           
            System.out.print("Enter 1 or 2 to reroll weapon 1 or 2, 3 to reroll both, 4 restart, or 'Enter' to Quit: ");
            try{
                reroll = Integer.parseInt(scanner.nextLine());
            }catch(NumberFormatException nfe){
                reroll = -1;
                i = 4;
                break;
            }
            
            if(reroll == 4){
                usedWeapons = new HashSet<>();
                i = 0;
                w1 = pickRandomWeapon(weaponLst);
                w2 = pickRandomWeapon(weaponLst);
            }
            else if(reroll == 3){
                w1 = pickRandomWeapon(weaponLst);
                w2 = pickRandomWeapon(weaponLst);
            }else if(reroll == 2){
                w2 = pickRandomWeapon(weaponLst);
            }else if(reroll == 1){
                w1 = pickRandomWeapon(weaponLst);
            }
            System.out.println("\n" + w1 + " and " + w2);
        }
        System.out.println("Enjoy your randomized weapons, Champion!");
    }
}