import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CardArea {

    private String[][] board;
    private String[] cardNames;
    private ArrayList<String> pokemons;
    private int highest;
    private Scanner scan;
    private ArrayList<Integer> usedNum;

    public CardArea ()
    {
        importPokemonNames();
        board = new String[6][6];
        cardNames = new String[36];
        highest = 0;
        scan = new Scanner(System.in);
        usedNum = new ArrayList<Integer>();
    }

    public void setAnswers()
    {
        for (int i = 0; i < cardNames.length / 2; i++)
        {
            int random = (int) (Math.random() * pokemons.size());
            cardNames[i] = pokemons.get(random);
            cardNames[i + 18] = cardNames[i];
            if (cardNames[i].length() > highest)
            {
                highest = cardNames[i].length();
            }
        }
        for (int i = 0; i < cardNames.length; i++)
        {
            int random1 = (int) (Math.random() * cardNames.length);
            int random2 = (int) (Math.random() * cardNames.length);
            String temp = cardNames[random1];
            cardNames[random1] = cardNames[random2];
            cardNames[random2] = temp;
        }
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                board[row][col] = "";
            }
        }

    }

    public void drawBoard() {
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (!board[row][col].equals(cardNames[count])) {
                    count++;
                    for (int i = 0; i < highest - 1; i++) {
                        System.out.print(" ");
                    }
                    System.out.print(" " + count);
                } else {
                    for (int i = 0; i < 5; i++) {
                        System.out.print(" ");
                    }
                    System.out.print(cardNames[count]);
                    count++;
                }
                System.out.print("|");
            }

            // print a horizontal divider after each row
            System.out.println();

            int numDashes = 8 * highest; //determined based on visually seeing what looked best
            for (int j = 0; j < numDashes; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void flipCards()
    {
        int row1 = 0;
        int row2 = 0;
        int col1 = 0;
        int col2 = 0;
        System.out.print("Enter a number: ");
        int number = scan.nextInt();
        while (usedNum.contains(number) || number > 36)
        {
            System.out.print("Invalid number, please enter another number: ");
            number = scan.nextInt();
        }
        usedNum.add(number);
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (count == number - 1)
                {
                    for (int i = 0; i < 5; i++) {
                        System.out.print(" ");
                    }
                    board[row][col] = cardNames[count];
                    row1 = row;
                    col1 = col;
                    System.out.print(cardNames[count]);
                    count++;
                }
                else if (!board[row][col].equals(cardNames[count]))
                {
                    count++;
                    for (int i = 0; i < highest - 1; i++) {
                        System.out.print(" ");
                    }
                    System.out.print(" " + count);
                }
                else
                {
                    for (int i = 0; i < highest - cardNames[count].length(); i++) {
                        System.out.print(" ");
                    }
                    System.out.print(cardNames[count]);
                    count++;
                }
                System.out.print("|");
            }

            // print a horizontal divider after each row
            System.out.println();

            int numDashes = 8 * highest; //determined based on visually seeing what looked best
            for (int j = 0; j < numDashes; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println((Memory.getPlayer1()).getName() + "'s Cards: " + (Memory.getPlayer1()).getPlayerCards());
        System.out.println((Memory.getPlayer2()).getName() + "'s Cards: " + (Memory.getPlayer2()).getPlayerCards());

        System.out.print("Enter another number: ");
        int number2 = scan.nextInt();
        while (usedNum.contains(number2) || number2 > 36)
        {
            System.out.print("Invalid number, please enter another number: ");
            number2 = scan.nextInt();
        }
        usedNum.add(number2);
        int count2 = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (count2 == number2 - 1)
                {
                    for (int i = 0; i < 5; i++) {
                        System.out.print(" ");
                    }
                    board[row][col] = cardNames[count2];
                    row2 = row;
                    col2 = col;
                    System.out.print(cardNames[count2]);
                    count2++;
                }
                else if(!board[row][col].equals(cardNames[count2]))
                {
                    count2++;
                    for (int i = 0; i < highest - 1; i++) {
                        System.out.print(" ");
                    }
                    System.out.print(" " + count2);
                }
                else
                {
                    for (int i = 0; i < highest - cardNames[count2].length(); i++) {
                        System.out.print(" ");
                    }
                    System.out.print(cardNames[count2]);
                    count2++;
                }
                System.out.print("|");
            }

            // print a horizontal divider after each row
            System.out.println();

            int numDashes = 8 * highest; //determined based on visually seeing what looked best
            for (int j = 0; j < numDashes; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println((Memory.getPlayer1()).getName() + "'s Cards: " + (Memory.getPlayer1()).getPlayerCards());
        System.out.println((Memory.getPlayer2()).getName() + "'s Cards: " + (Memory.getPlayer2()).getPlayerCards());

        if (board[row1][col1].equals(board[row2][col2]))
        {
            System.out.println("Congrulations " + Memory.getCurrentPlayer().getName() + " you have matched a pair of pokemon!");
            Memory.getCurrentPlayer().addPlayerCards(board[row1][col1]);
        }
        else {
            System.out.println("Very sad, your pair doesn't match!");
            board[row1][col1] = "";
            board[row2][col2] = "";
            usedNum.remove(usedNum.size() - 1);
            usedNum.remove(usedNum.size() - 1);
            Memory.changePlayer();
        }
        System.out.println(number);
        System.out.println(number2);
        System.out.println(usedNum);
        System.out.println(usedNum.contains(number2));
    }

    public boolean checkFinish()
    {
        for (String[] row : board)
        {
            for (String card : row)
            {
                if (card.equals(""))
                {
                    return true;
                }
            }
        }
        return false;
    }


    private void importPokemonNames()
    {
        String[] tmp = null;
        try
        {
            FileReader fileReader = new FileReader("src\\PokemonNames.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> lines = new ArrayList<String>();
            String line = null;

            while ((line = bufferedReader.readLine()) != null)
            {
                lines.add(line);
            }

            bufferedReader.close();
            tmp = lines.toArray(new String[lines.size()]);
            System.out.println("\nFile imported successfully!");
        }
        catch (IOException e)
        {
            System.out.println("Error importing file; unable to access "+ e.getMessage());
        }

        pokemons = new ArrayList<String>(Arrays.asList(tmp));
    }


}
