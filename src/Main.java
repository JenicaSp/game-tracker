import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        PlayerStatus player1;
        PlayerStatus player2;
        PlayerStatus player3;

        switch (testCase) {
            case 0:
                // Sanity check
                System.out.println("Sanity check");
                break;
            case 1:
                // Check fields, initializers, getters, setters
                player1 = new PlayerStatus();
                player1.initPlayer("player1");
                player1.initPlayer("player1", 1, 999999);
                player2 = new PlayerStatus();
                player2.initPlayer("player2", 1);
                player2.initPlayer("player2", 1, 9999999);
                player3 = new PlayerStatus();
                player3.initPlayer("player3", 2, 9999999);

                System.out.println(player1.getNickname());
                System.out.println(player2.getNickname());
                System.out.println(player3.getNickname());

                PlayerStatus.setGameName("World of DevMind");
                System.out.println(PlayerStatus.getGameName());
                PlayerStatus.setGameName("Call of DevMind");
                System.out.println(PlayerStatus.getGameName());

                player1.setWeaponInHand("knife");
                System.out.println(player1.getWeaponInHand());
                player1.setWeaponInHand("lightsaber");
                System.out.println(player1.getWeaponInHand());
                player2.setWeaponInHand("kalashnikov");
                System.out.println(player2.getWeaponInHand());
                player3.setWeaponInHand("sniper");
                System.out.println(player3.getWeaponInHand());
                break;
            case 2:
                // Test findArtifact for traps and player death
                player1 = new PlayerStatus();
                player1.initPlayer("player1", 1, 999999);

                player1.findArtifact(300);
                player1.findArtifact(300);
                player1.findArtifact(300);
                player1.findArtifact(300);
                player1.findArtifact(300);
                break;
            case 3:
                // Test findArtifact for traps and gaining lives
                player1 = new PlayerStatus();
                player1.initPlayer("player1", 1, 999999);

                player1.findArtifact(28);
                player1.findArtifact(300);
                player1.findArtifact(300);
                player1.findArtifact(300);
                player1.findArtifact(300);
                player1.findArtifact(300);

                System.out.println("empty");
                break;
            case 4:
                // Test findArtifact for gaining score and spending it on weapons
                player1 = new PlayerStatus();
                player1.initPlayer("player1", 1, 0);

                player1.findArtifact(5000);
                System.out.println(player1.setWeaponInHand("sniper"));
                player1.findArtifact(5000);
                System.out.println(player1.setWeaponInHand("sniper"));
                System.out.println(player1.setWeaponInHand("sniper"));
                player1.findArtifact(19000);
                System.out.println(player1.setWeaponInHand("kalashnikov"));
                player1.findArtifact(1000);
                System.out.println(player1.setWeaponInHand("kalashnikov"));
                System.out.println(player1.getWeaponInHand());
                break;
            case 5:
                // Test shouldAttackOpponent for close distance different weapon duel
                player1 = new PlayerStatus();
                player1.initPlayer("player1", 1, 999999999);

                player2 = new PlayerStatus();
                player2.initPlayer("player2", 1, 999999999);

                player1.movePlayerTo(0, 0);
                player2.movePlayerTo(100, 100);

                player1.setWeaponInHand("knife");
                player2.setWeaponInHand("sniper");
                System.out.println(player1.shouldAttackOpponent(player2));
                player2.setWeaponInHand("kalashnikov");
                System.out.println(player1.shouldAttackOpponent(player2));

                player1.setWeaponInHand("sniper");
                player2.setWeaponInHand("knife");
                System.out.println(player1.shouldAttackOpponent(player2));
                player2.setWeaponInHand("kalashnikov");
                System.out.println(player1.shouldAttackOpponent(player2));

                player1.setWeaponInHand("kalashnikov");
                player2.setWeaponInHand("knife");
                System.out.println(player1.shouldAttackOpponent(player2));
                player2.setWeaponInHand("sniper");
                System.out.println(player1.shouldAttackOpponent(player2));
                break;
            case 6:
                // Test shouldAttackOpponent for close distance different weapon duel
                player1 = new PlayerStatus();
                player1.initPlayer("player1", 1, 999999999);

                player2 = new PlayerStatus();
                player2.initPlayer("player2", 1, 999999999);

                player1.movePlayerTo(0, 0);
                player2.movePlayerTo(800, 800);

                player1.setWeaponInHand("knife");
                player2.setWeaponInHand("sniper");
                System.out.println(player1.shouldAttackOpponent(player2));
                player2.setWeaponInHand("kalashnikov");
                System.out.println(player1.shouldAttackOpponent(player2));

                player1.setWeaponInHand("sniper");
                player2.setWeaponInHand("knife");
                System.out.println(player1.shouldAttackOpponent(player2));
                player2.setWeaponInHand("kalashnikov");
                System.out.println(player1.shouldAttackOpponent(player2));

                player1.setWeaponInHand("kalashnikov");
                player2.setWeaponInHand("knife");
                System.out.println(player1.shouldAttackOpponent(player2));
                player2.setWeaponInHand("sniper");
                System.out.println(player1.shouldAttackOpponent(player2));
                break;
            case 7:
                // Test shouldAttackOpponent for same weapon duel
                player1 = new PlayerStatus();
                player1.initPlayer("player1", 1, 9999);

                player2 = new PlayerStatus();
                player2.initPlayer("player2", 1, 999999999);

                player1.movePlayerTo(0, 0);
                player2.movePlayerTo(10, 10);

                player1.setWeaponInHand("knife");
                player2.setWeaponInHand("knife");

                System.out.println(player1.shouldAttackOpponent(player2));
                player2.movePlayerTo(1000, 1000);
                System.out.println(player1.shouldAttackOpponent(player2));
                break;
            case 8:
                // Test shouldAttackOpponent for same weapon duel
                player1 = new PlayerStatus();
                player1.initPlayer("player1", 1, 999999999);

                player2 = new PlayerStatus();
                player2.initPlayer("player2", 1, 99999);

                player1.movePlayerTo(0, 0);
                player2.movePlayerTo(10, 10);

                player1.setWeaponInHand("sniper");
                player2.setWeaponInHand("sniper");

                System.out.println(player1.shouldAttackOpponent(player2));
                player2.movePlayerTo(1000, 1000);
                System.out.println(player1.shouldAttackOpponent(player2));
                break;
            case 9:
                // Test shouldAttackOpponent for same weapon duel with different health
                player1 = new PlayerStatus();
                player1.initPlayer("player1", 2, 999999);

                player2 = new PlayerStatus();
                player2.initPlayer("player2", 1, 999900);

                player1.movePlayerTo(0, 0);
                player2.movePlayerTo(10, 10);

                player1.setWeaponInHand("kalashnikov");
                player2.setWeaponInHand("kalashnikov");

                System.out.println(player1.shouldAttackOpponent(player2));
                player1.findArtifact(300);
                player2.movePlayerTo(1000, 1000);
                System.out.println(player1.shouldAttackOpponent(player2));
                break;
            case 10:
                // Test shouldAttackOpponent for same weapon duel with different health
                player1 = new PlayerStatus();
                player1.initPlayer("player1", 2, 999999);

                player2 = new PlayerStatus();
                player2.initPlayer("player2", 1, 999900);

                player1.movePlayerTo(0, 0);
                player2.movePlayerTo(10, 10);

                player1.setWeaponInHand("sniper");
                player2.setWeaponInHand("sniper");

                System.out.println(player1.shouldAttackOpponent(player2));

                player1.findArtifact(300);

                System.out.println(player1.shouldAttackOpponent(player2));

                player1.findArtifact(7);
                System.out.println(player1.shouldAttackOpponent(player2));

                player1.findArtifact(2000);
                System.out.println(player1.shouldAttackOpponent(player2));
                break;
        }
    }
}