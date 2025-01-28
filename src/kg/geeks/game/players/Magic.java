package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;
import kg.geeks.game.players.interfaces.Fighter;

public class Magic extends Hero implements Fighter {
    private static final int BOOST_ROUNDS = 4;
    private static final int BOOST_AMOUNT = 10;


    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void attack(GameEntity entity) {
        entity.setHealth(entity.getHealth() - this.getDamage());
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int currentRound = RPG_Game.getRoundNumber();
        if (currentRound <= BOOST_ROUNDS) {
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0) {
                    hero.setDamage(hero.getDamage() + BOOST_AMOUNT);
                    System.out.println(getName() + " усилил атаку " + hero.getName() + " на " + BOOST_AMOUNT + " урона!");
                }
            }
        }
    }

}
