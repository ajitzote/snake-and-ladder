import com.ajit.snakeladder.model.Game;
import com.ajit.snakeladder.model.Player;

import java.util.Scanner;

public class snakeGame {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board size");
        int boardSize = scanner.nextInt();
        System.out.println("Enter number of players");
        int noOfPlayers = scanner.nextInt();
        System.out.println("Enter number of snakes");
        int noOfSnakes = scanner.nextInt();
        System.out.println("Enter number of ladders");
        int noOfLadders = scanner.nextInt();

        Game game = new Game(noOfSnakes,noOfLadders,boardSize);

        for(int i=0;i<noOfPlayers;i++){
            System.out.println("Enter name of player ");
            String p1 = scanner.next();
            Player player = new Player(p1);
            game.addPlayer(player);

        }

        game.playGame();



    }
}
