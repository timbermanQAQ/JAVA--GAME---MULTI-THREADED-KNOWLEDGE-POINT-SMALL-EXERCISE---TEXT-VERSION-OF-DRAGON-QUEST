package Game;

public class DragonFightGameDemo {
    public static void main(String[] args) {
        DragonFightGame game = new DragonFightGame("黑龙", "勇者");
        DragonFightGameThread dragonThread = new DragonFightGameThread(game, "黑龙线程");
        DragonFightGameThread heroThread = new DragonFightGameThread(game, "勇者线程");
        dragonThread.start();
        heroThread.start();
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
        if(game.dragonHp<=0){
            System.out.println();
            System.out.println("勇者讨伐成功，成功救出公主\n");
        }
        else{
            System.out.println();
            System.out.println("勇者讨伐失败，公主被恶龙掳走\n");
        }
    }

}