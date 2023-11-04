// Создаем enum для типов оружия
enum WeaponType {
    SWORD,
    AXE,
    BOW
}

// Создаем класс Weapon
class Weapon {
    private WeaponType weaponType;
    private String weaponName;

    public Weapon(WeaponType weaponType, String weaponName) {
        this.weaponType = weaponType;
        this.weaponName = weaponName;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
}

// Создаем класс GameEntity
class GameEntity {
    private int health;
    private int damage;

    public GameEntity(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

// Создаем класс Boss, наследующий GameEntity, с дополнительным полем Weapon
class Boss extends GameEntity {
    private Weapon weapon;

    public Boss(int health, int damage, Weapon weapon) {
        super(health, damage);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String printInfo() {
        return "Boss: " + "Health = " + getHealth() + ", Damage = " + getDamage() + ", Weapon Type = " + weapon.getWeaponType() + ", Weapon Name = " + weapon.getWeaponName();
    }
}

// Создаем класс Skeleton, унаследованный от Boss
class Skeleton extends Boss {
    private int arrowCount;

    public Skeleton(int health, int damage, Weapon weapon, int arrowCount) {
        super(health, damage, weapon);
        this.arrowCount = arrowCount;
    }

    public int getArrowCount() {
        return arrowCount;
    }

    public void setArrowCount(int arrowCount) {
        this.arrowCount = arrowCount;
    }

    @Override
    public String printInfo() {
        return "Skeleton: " + "Health = " + getHealth() + ", Damage = " + getDamage() + ", Weapon Type = " + getWeapon().getWeaponType() + ", Weapon Name = " + getWeapon().getWeaponName() + ", Arrow Count = " + arrowCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Weapon bossWeapon = new Weapon(WeaponType.AXE, "Executioner's Axe");
        Boss boss = new Boss(500, 50, bossWeapon);
        System.out.println(boss.printInfo());

        Weapon skeletonWeapon1 = new Weapon(WeaponType.SWORD, "Steel Sword");
        Skeleton skeleton1 = new Skeleton(80, 15, skeletonWeapon1, 20);

        Weapon skeletonWeapon2 = new Weapon(WeaponType.BOW, "Longbow");
        Skeleton skeleton2 = new Skeleton(100, 20, skeletonWeapon2, 30);

        System.out.println(skeleton1.printInfo());
        System.out.println(skeleton2.printInfo());
    }
}
