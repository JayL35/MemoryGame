import java.util.Scanner;

public class Memory {
    private Scanner scanner;
    private static Player player1;
    private static Player player2;
    public static  Player currentPlayer;
    private CardArea game;
    public static boolean end;

    public Memory()
    {
        player1 = null;
        player2 = null;
        currentPlayer = null;
        game = null;
        end = true;
    }

    public static Player getCurrentPlayer()
    {
        return currentPlayer;
    }

    public static Player getPlayer1()
    {
        return player1;
    }

    public static Player getPlayer2()
    {
        return player2;
    }

    public static void changePlayer()
    {
        if (currentPlayer == player1)
        {
            currentPlayer = player2;
        }
        else
        {
            currentPlayer = player1;
        }
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
        System.out.println("All set! Good Luck " + player1.getName() + " and " + player2.getName() + ".\nThe Game Begins!");
        currentPlayer = player1;
        game = new CardArea();
        play();
    }

    public void play()
    {
        game.setAnswers();
        while (game.checkFinish())
        {
            game.drawBoard();
            System.out.println(currentPlayer.getName() + "'s Turn.");
            game.flipCards();
        }
    }


}
