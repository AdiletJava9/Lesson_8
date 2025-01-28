package kg.geeks.game.players;


import kg.geeks.game.players.interfaces.Fighter;

import java.util.Random;

public class Samurai extends Hero implements Fighter {
    public Samurai(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.SHURIKEN);
    }

    @Override
    public void attack(GameEntity entity) {
        entity.setHealth(entity.getHealth() - this.getDamage());
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random random = new Random();
        boolean isVirus = random.nextBoolean();
        int shurikenEffect = random.nextInt(30) + 10;

        if (isVirus) {
            boss.setHealth(boss.getHealth() - shurikenEffect);
            System.out.println(getName() + " бросил ВИРУС-сюрикен, нанеся боссу " + shurikenEffect + " урона!");
            System.out.println("----------------------------------------------------");
        } else {
            boss.setHealth(boss.getHealth() + shurikenEffect);
            System.out.println(getName() + " бросил ВАКЦИНА-сюрикен, восстановив боссу " + shurikenEffect + " здоровья!");
            System.out.println("----------------------------------------------------");

        }
    }

}
