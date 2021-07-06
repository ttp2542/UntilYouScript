public class Weapon {
    private String weaponPicLocation;
    private String weaponName;

    public Weapon(String weaponPicLocation, String weaponName){
        this.weaponPicLocation = weaponPicLocation;
        this.weaponName = weaponName;
    }

    public String getWeaponName(){
        return this.weaponName;
    }

    public String toString(){
        return this.weaponName;
    }
}
