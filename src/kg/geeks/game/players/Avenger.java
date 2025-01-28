package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;
import kg.geeks.game.players.interfaces.Fighter;

public class Avenger extends Hero implements Fighter {
    private static final int SHIELD_CHANCE = 20;
    private boolean shieldActive = false;

    public Avenger(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BLOCK);
    }

    @Override
    public void attack(GameEntity entity) {
        entity.setHealth(entity.getHealth() - this.getDamage());
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.random.nextInt(100) < SHIELD_CHANCE) {
            activateShield(heroes);
        }
    }

    private void activateShield(Hero[] heroes) {
        if (!shieldActive) {
            shieldActive = true;
            System.out.println(getName() + " ACTIVE BLOCK WITH ALL HEROES  1 раунд!");
        }
    }


    public boolean isShieldActive() {
        return shieldActive;
    }

    public void deactivateShield() {
        shieldActive = false;
    }


}
