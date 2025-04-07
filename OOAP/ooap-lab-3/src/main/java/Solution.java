import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Player subzero = new Player("SubZero", 200, 15);
        Player scorpion = new Player("Scorpion", 250, 13);
        RemoteControl remoteControl = new RemoteControl();

        System.out.println("Press 1 to subzero attack scorpion, 2 to scorpion attack subzero or 0 to undo any attack");
        Scanner scanner = new Scanner(System.in);

        System.out.println(subzero);
        System.out.println(scorpion);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    remoteControl.pressExecute(new AttackCommand(subzero, scorpion));
                    break;
                case 2:
                    remoteControl.pressExecute(new AttackCommand(scorpion, subzero));
                    break;
                case 0:
                    remoteControl.pressUndo();
                    break;
                default:
                    System.out.println("Invalid command");
            }
            System.out.println(subzero);
            System.out.println(scorpion);
        }
    }
}
