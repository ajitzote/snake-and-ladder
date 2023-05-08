package com.ajit.snakeladder.model;

import java.util.Scanner;

public class App {
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
            System.out.println("Enter name of player "+i+1);
            Player player = new Player(scanner.nextLine());
            game.addPlayer(player);
        }

        game.playGame();


    }
}
