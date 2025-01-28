package kg.geeks.game.players;

import kg.geeks.game.players.interfaces.Fighter;

import java.util.Random;

public class Antman extends Hero implements Fighter {

    public Antman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.INCREASE_DECREASE);
    }

    @Override
    public void attack(GameEntity entity) {
        entity.setHealth(entity.getHealth() - getDamage());
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random random = new Random();
        boolean increase = random.nextBoolean();
        int sizeChange = random.nextInt(20) + 5;

        if (increase) {
            setHealth(getHealth() + sizeChange);
            setDamage(getDamage() + sizeChange / 2);
            System.out.println(getName() + " увеличился на " + sizeChange + " и теперь имеет здоровье " + getHealth() + " и урон " + getDamage());
        } else {
            setHealth(Math.max(getHealth() - sizeChange, 1));
            setDamage(Math.max(getDamage() - sizeChange / 2, 1));
            System.out.println(getName() + " уменьшился на " + sizeChange + " и теперь имеет здоровье " + getHealth() + " и урон " + getDamage());
        }
    }
}

