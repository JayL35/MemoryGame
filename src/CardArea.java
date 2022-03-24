import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CardArea {

    private String[][] board;
    private String[] cardNames;
    private ArrayList<String> pokemons;

    public CardArea ()
    {
        importPokemonNames();
        board = new String[6][6];
        cardNames = new String[36];
    }

    public void setAnswers()
    {
        for (int i = 0; i < cardNames.length / 2; i++)
        {
            int random = (int) (Math.random() * pokemons.size()) + 1;
            cardNames[i] = pokemons.get(random);
            cardNames[i + 18] = cardNames[i];
        }
        for (int i = 0; i < cardNames.length; i++)
        {
            int random1 = (int) (Math.random() * cardNames.length) + 1;
            int random2 = (int) (Math.random() * cardNames.length) + 1;
            String temp = cardNames[random1];
            cardNames[random1] = cardNames[random2];
            cardNames[random2] = temp;
        }
        for (int i = 0; i < cardNames.length; i++)
        {
            System.out.println(cardNames[i]);
        }


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
