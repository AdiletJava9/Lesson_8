package kg.geeks.game.players;

import kg.geeks.game.players.interfaces.HavingSuperAbility;

public abstract class Hero extends GameEntity
        implements HavingSuperAbility {
    private SuperAbility ability;

    public Hero(int health, int damage, String name, SuperAbility ability) {
        super(health, damage, name);
        this.ability = ability;
    }

    public SuperAbility getAbility() {
        return ability;
    }
}
