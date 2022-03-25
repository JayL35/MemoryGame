import java.util.Scanner;

public class Memory {
    private Scanner scanner;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Memory()
    {
        player1 = null;
        player2 = null;
        currentPlayer = null;
    }

    public void start()
    {
        scanner = new Scanner(System.in);
        System.out.println("Welcome to a Mutiplayer Memory Game!");
        System.out.println("The theme for this game would be Pokemons!");
        System.out.println("Pokemon Gotta Catch Em All...");
        System.out.println("Anyways first input player names");
        System.out.print("Name Of Player1: ");
        String playerName1 = scanner.nextLine();
        player1 = new Player(playerName1);
        System.out.print("Name of Player2: ");
        String playerName2 = scanner.nextLine();
        player2 = new Player(playerName2);
        System.out.println("All set! Good Luck " + player1.getName() + " and " player2.getName() + ".\nThe Game Begins!");
        currentPlayer = player1;
        play();
    }

    public void play()
    {

    }
}
