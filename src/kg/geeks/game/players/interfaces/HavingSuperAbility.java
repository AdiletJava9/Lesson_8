package kg.geeks.game.players.interfaces;

import kg.geeks.game.general.RPG_Game;
import kg.geeks.game.players.Boss;
import kg.geeks.game.players.Hero;

public interface HavingSuperAbility {
    void applySuperPower(Boss boss, Hero[] heroes);
}
