import java.util.Scanner;
import static java.lang.Math.sqrt;
class PlayerStatus {

    private static String gameName;
    private String nickname;
    private int score;
    private int lives;
    private int health;
    private String weaponInHand;
    private double positionX;
    private double positionY;

    public PlayerStatus() {
        this.lives = 3;
        this.health = 100;
        this.score = 0;
        this.weaponInHand = "knife";
    }

    public static String getGameName() {
        return gameName;
    }

    public static void setGameName(String name) {
        gameName = name;
    }

    public void initPlayer(String nickname) {
        this.nickname = nickname;
    }

    public void initPlayer(String nickname, int lives) {
        this.nickname = nickname;
        this.lives = lives;
    }

    public void initPlayer(String nickname, int lives, int score) {
        this.nickname = nickname;
        this.lives = lives;
        this.score = score;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void movePlayerTo(double newPositionX, double newPositionY) {
        this.positionX = newPositionX;
        this.positionY = newPositionY;
    }


    public void findArtifact(int artifactCode) {
        if (isPerfectNumber(artifactCode)) {
            score += 5000;
            lives++;
            health = 100;
        } else if (isPrimeNumber(artifactCode)) {
            score += 1000;
            lives += 2;
            health = Math.min(health + 25, 100);
        } else if (parSiSumaDiv3(artifactCode)) {
            score -= 3000;
            health -= 25;

            if (health <= 0) {
                lives--;
                health = 100;

                if (lives == 0) {
                    System.out.println("Game Over");
                }
            }
        } else {
            score += artifactCode;
        }
    }


    public boolean setWeaponInHand(String weapon) {
        int weaponPrice = getWeaponPrice(weapon);

        if (weaponPrice == -1) return false;

        if (score >= weaponPrice) {
            this.weaponInHand = weapon;
            this.score -= weaponPrice;
            return true;
        }

        return false;
    }


    public String getWeaponInHand() {
        return this.weaponInHand;
    }


    public boolean shouldAttackOpponent(PlayerStatus opponent) {
        if (this.weaponInHand.equals(opponent.weaponInHand)) {
            double thisProbability = (3.0 * this.health + this.score / 1000.0) / 4.0;
            double opponentProbability = (3.0 * opponent.health + opponent.score / 1000.0) / 4.0;

            return thisProbability > opponentProbability;
        } else {
            double distance1 = distance(this.positionX, opponent.positionX,this.positionY, opponent.positionY);
            return weaponPower(opponent, distance1);
        }
    }

    private double distance(double x1, double x2,double y1,double y2 ) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1 - y2, 2));
    }


    private boolean weaponPower(PlayerStatus opponent, double distance) {
        if (distance>1000){
            if (this.weaponInHand.equals("sniper")) {
                return true;
            } else if (this.weaponInHand.equals("kalashnikov") && opponent.weaponInHand.equals("knife")) {
                return true;
            }
        }
        if (distance <= 1000) {
            if (this.weaponInHand.equals("kalashnikov")) {
                return true;
            } else if (this.weaponInHand.equals("sniper") && opponent.weaponInHand.equals("knife")) {
                return true;
            }
        }
        return false;
    }



    private int getWeaponPrice(String weapon) {
        return switch (weapon) {
            case "knife" -> 1000;
            case "sniper" -> 10000;
            case "kalashnikov" -> 20000;
            default -> -1;
        };
    }

    private boolean isPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) sum += i;
        }
        return sum == number;
    }


    private boolean isPrimeNumber(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }


    private boolean parSiSumaDiv3(int number) {
        return number % 2 == 0 && getDigitSum(number) % 3 == 0;
    }


    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}


