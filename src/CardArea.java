import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CardArea {

    private String[][] board;
    private String[] cardNames;
    private ArrayList<String> pokemons;
    private int highest;

    public CardArea ()
    {
        importPokemonNames();
        board = new String[6][6];
        cardNames = new String[36];
        highest = 0;
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
    }

    public void drawBoard() {
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                count++;
                for (int i = 0; i < highest - 1; i++)
                {
                    System.out.print(" ");
                }
                if (count < 9)
                {
                    System.out.print(" ");
                }
                System.out.print(" " + count);
                // print a vertical divider between each column
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
