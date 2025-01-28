package kg.geeks.game.general;

import kg.geeks.game.players.*;
import kg.geeks.game.players.interfaces.Fighter;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN_BACKGROUND = "\u001B[42m";

    public static int getRoundNumber() {
        return roundNumber;
    }

    public static void startGame() {
        Boss boss = new Boss(4000, 50, "Saruman");
        Warrior warrior1 = new Warrior(290, 20, "Bob");
        Warrior warrior2 = new Warrior(280, 20, "James");
        Magic magic = new Magic(270, 20, "Anton");
        Berserk berserk = new Berserk(260, 20, "Ragnar");
        Medic doc = new Medic(250, "Alex", 15);
        Medic assistant = new Medic(320, "Sultan", 5);
        Antman antman = new Antman(200, 20, "BOLT");
        Samurai samurai = new Samurai(200, 20, "COBRA");
        Avenger avenger = new Avenger(200, 50, "IRON_MAN");
        Hero[] heroes = {warrior1, doc, magic, warrior2, berserk, assistant, antman, samurai, avenger};

        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();

        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0) {
                if (!(hero instanceof Avenger && ((Avenger) hero).isShieldActive())) {
                    boss.attack(hero);
                }

                if (boss.getDefence() != hero.getAbility()) {
                    if (hero instanceof Fighter) {
                        ((Fighter) hero).attack(boss);
                    }
                    hero.applySuperPower(boss, heroes);
                }
            }
        }

        for (Hero hero : heroes) {
            if (hero instanceof Avenger) {
                ((Avenger) hero).deactivateShield();
            }
        }

        printStatistics(boss, heroes);
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println(GREEN_BACKGROUND + "Heroes won!!!" + RESET);
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println(RED + "Boss won!!!" + RESET);
            return true;
        }
        return false;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println(GREEN_BACKGROUND + "ROUND --------------------------> " + RESET + roundNumber);
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
