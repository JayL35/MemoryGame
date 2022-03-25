import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<String> playerCards;

    public Player(String name)
    {
        this.name = name;
        playerCards = new ArrayList<String>();
    }

    public String getName()
    {
        return name;
    }
}
