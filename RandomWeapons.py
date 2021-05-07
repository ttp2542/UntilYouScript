import random

weaponLst = ["Engraved Arming Sword", "Rokari Keenblade", "Heartsplitter", "Vestal's Wrath", "Spellsword's Charm", "Duelist's Edge", "Mistcutter", "Gemini Stranded", "Gemini Esper", "Ritual Dagger", "High Arcanist's Blade", "Knight-blooded Crest"]
usedWeapons = set()

def getWeapon():
    w = random.randint(0, len(weaponLst) - 1)
    while w in usedWeapons:
        w = random.randint(0, len(weaponLst) - 1)

    usedWeapons.add(w)
    return w

input("Hello! Press Enter to get your first 2 weapons: ")
w1 = getWeapon()
w2 = getWeapon()
print(weaponLst[w1] + " and " + weaponLst[w2])

for i in range(3):
    reroll = ""
    while True:
        try:
            reroll = input("Enter 1 or 2 to reroll weapon 1 or 2, 3 to reroll both, 4 restart, or 'Enter' to Quit: ")
            if reroll == "":
                quit()
            else:
                reroll = int(reroll)
            break
        except(ValueError):
            print("Please enter a valid input")
    if reroll == 4:
        usedWeapons = set()
        i = 0
        w1 = getWeapon()
        w2 = getWeapon()
    if reroll == 3:
        w1 = getWeapon()
        w2 = getWeapon()
    elif reroll == 2:
        w2 = getWeapon()
    elif reroll == 1:
        w1 = getWeapon()
    print()
    print(weaponLst[w1] + " and " + weaponLst[w2])
