package Game;

public class DragonFightGame {
    public static final int MAX_ROUND = 10;
    public  static final int MAX_HP = 100;
    public  static final int MAX_ATTACK = 20;
    public  static final int HEAL_HP = 30;
    public  static final int INCREASE_ATTACK = 5;


    public  int round = 1;
    public  int dragonHp = MAX_HP;
    public  int heroHp = MAX_HP;
    public  int heroAttack = MAX_ATTACK;
    public  String dragonName;
    public  String heroName;

    public DragonFightGame(String dragonName, String heroName) {
        this.dragonName = dragonName;
        this.heroName = heroName;
    }

    public synchronized void dragonAttack() {
        if (round > MAX_ROUND) {
            return;
        }
        int damage = (int) (Math.random() * MAX_ATTACK);
        heroHp -= damage;
        System.out.println(dragonName + "对" + heroName + "造成了" + damage + "点伤害");
        if (heroHp <= 0) {
            System.out.println(heroName + "被" + dragonName + "击败了");
            return;
        }
        round++;
    }

    public synchronized void heroAttack() {
        if (round > MAX_ROUND) {
            return;
        }
        int damage = heroAttack;
        dragonHp -= damage;
        System.out.println(heroName + "对" + dragonName + "造成了" + damage + "点伤害");
        if (dragonHp <= 0) {
            System.out.println(dragonName + "被" + heroName + "击败了");
            return;
        }
        round++;
    }

    public synchronized void useHeal() {
        if (round > MAX_ROUND) {
            return;
        }
        heroHp += HEAL_HP;
        if (heroHp > MAX_HP) {
            heroHp = MAX_HP;
        }
        System.out.println(heroName + "使用了恢复道具，恢复了" + HEAL_HP + "点生命值");
        round++;
    }

    public synchronized void useAttackBoost() {
        if (round > MAX_ROUND) {
            return;
        }
        heroAttack += INCREASE_ATTACK;
        System.out.println(heroName + "使用了攻击力提升道具，攻击力增加了" + INCREASE_ATTACK);
        round++;
    }
}