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
