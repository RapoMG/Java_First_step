import java.util.Random;
import java.util.Scanner;

public class walka_05 {

        public static void main(String []args){
            Random gen = new Random();
            Scanner sc = new Scanner(System.in);

            System.out.print("Your Attack Points: ");
            int yourAttack = gen.nextInt(6)+5;
            System.out.println(yourAttack);
            System.out.print("Your Defense Points: ");
            int yourDefense = gen.nextInt(10)+6;
            System.out.println(yourDefense);
            System.out.print("Your Damage: ");
            int yourDamage = gen.nextInt(3)+2;
            System.out.println(yourDamage);
            System.out.print("Your Life Points: ");
            int yourLife = gen.nextInt(20)+25;
            System.out.println(yourLife);
            System.out.println();

            for (int i = 0; i<3; i++) {

                String monsterName;
                int num = gen.nextInt(5);
                switch (num) {
                    case 0:
                        monsterName = "Black Daemon";
                        break;
                    case 1:
                        monsterName = "Królik";
                        break;
                    case 2:
                        monsterName = "Silver raven";
                        break;
                    case 3:
                        monsterName = "Mountain Troll";
                        break;
                    case 4:
                        monsterName = "Alien";
                        break;
                    default:
                        monsterName = "N/A";
                        break;
                }

                System.out.print("Attack Points of " + monsterName + ": ");
                int monsterAttack = gen.nextInt(8) + 1;
                System.out.println(monsterAttack);
                System.out.print("Defense Points of " + monsterName + ": ");
                int monsterDefense = gen.nextInt(10) + 3;
                System.out.println(monsterDefense);
                System.out.print("Damage of " + monsterName + ": ");
                int monsterDamage = gen.nextInt(3) + 1;
                System.out.println(monsterDamage);
                System.out.print("Life Points of " + monsterName + ": ");
                int monsterLife = gen.nextInt(20) + 15;
                System.out.println(monsterLife);

                //sc.nextLine(); // nowa linia aby nie losowało dwa razy, bo pamięta ostatni Enter
                boolean runaway = false;

                do {
                    boolean attacker = gen.nextBoolean();
                    if (attacker) {
                        System.out.println("You attack");
                        int dice = gen.nextInt(6) + 1 + gen.nextInt(6) + 1;
                        int attackValue = yourAttack + dice;
                        System.out.println("Rolled values: " + dice);
                        System.out.println("Your attack value: " + attackValue);
                        if (attackValue > monsterDefense) {
                            System.out.println("Your attack was successful.");
                            monsterLife = monsterLife - yourDamage;
                            System.out.println( monsterName + " remaining Life Points: " + monsterLife);
                        } else {
                            System.out.println("Your attack was not successful.");
                        }
                    } else {
                        System.out.println(monsterName + " attacks.");
                        int dice = gen.nextInt(6) + 1 + gen.nextInt(6) + 1;
                        int attackValue = monsterAttack + dice;
                        System.out.println("Rolled values: " + dice);
                        System.out.println(monsterName + " attack value: " + attackValue);
                        if (attackValue > yourDefense) {
                            System.out.println(monsterName + " attack was successful.");
                            yourLife = yourLife - monsterDamage;
                            System.out.println("Your remaining Life Points: " + yourLife);
                        } else {
                            System.out.println(monsterName + " attack was not successful.");
                        }
                    }
                    System.out.println("Press [Enter] to continue or type /'run/' to avoid monster.");
                    String command = sc.nextLine();
                    switch (command) {
                        case "run":
                            System.out.println("You ran away, but you where hurt in the process. You lose 4 pts.");
                            yourLife -= 4;
                            runaway = true;
                            break;
                        default:
                    }
                } while (monsterLife > 0 && yourLife > 0 && !runaway);
                if (yourLife <= 0) {
                    System.out.println("You lost. " + monsterName + " has " + monsterLife + " points left.");
                    break;
                }
                if (monsterLife <= 0) {
                    System.out.println("You win. You have " + yourLife + " points left. " + monsterName + " is defeted!");
                }
            }
        }
    }
