package Game;

public class DragonFightGameThread extends Thread {
    private DragonFightGame game;
    private String name;

    public DragonFightGameThread(DragonFightGame game, String name) {
        this.game = game;
        this.name = name;
    }

    @Override
    public void run() {
        while (game.round <= DragonFightGame.MAX_ROUND && game.dragonHp > 0 && game.heroHp > 0) {
            int action = (int) (Math.random() * 4);
            switch (action) {
                case 0:
                    game.dragonAttack();
                    break;
                case 1:
                    game.heroAttack();
                    break;
                case 2:
                    game.useHeal();
                    break;
                case 3:
                    game.useAttackBoost();
                    break;
            }
        }
        System.out.println(name + "结束了游戏");
    }
}
