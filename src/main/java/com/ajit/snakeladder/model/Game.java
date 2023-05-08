package com.ajit.snakeladder.model;

import java.util.*;

public class Game {
    private int numberOfSnakes;
    private int numberOfLadders;
    private Queue<Player> players;
    private List<Ladder> ladders;
    private  List<Snake> snakes;

    private Board board;
    private Dice dice;

    public Game(int numberOfSnakes, int numberOfLadders , int boardSize) {
        this.numberOfSnakes = numberOfSnakes;
        this.numberOfLadders = numberOfLadders;


        this.ladders= new ArrayList<>(numberOfLadders);
        this.snakes= new ArrayList<>(numberOfSnakes);

        this.board= new Board(boardSize);
        this.dice =new Dice(1,6,2);
        this.players = new ArrayDeque<Player>();

        initBoard();




    }

    public void addPlayer(Player player){

        this.players.add(player);




    }

    public void initBoard() {
        Random rand = new Random();
        Set<String> sl = new HashSet<>();
        Set<Integer> snakeStarts = new HashSet<>();
        Set<Integer> snakeEnds = new HashSet<>();

        while (snakes.size()<numberOfSnakes) {
            int snakeStart = rand.nextInt(board.getStart(), board.getEnd());
            int snakeEnd = rand.nextInt(board.getStart(), board.getEnd());

            if (snakeStart <= snakeEnd) {
                continue;
            }
            String startEndPair = String.valueOf(snakeStart) + snakeEnd;

            if (!sl.contains(startEndPair)) {
                Snake newSnake = new Snake(snakeStart, snakeEnd);
                snakes.add(newSnake);
                snakeStarts.add(snakeStart);
                snakeEnds.add(snakeEnd);
                sl.add(startEndPair);

            }
        }
        sl.clear();
        while (ladders.size()<numberOfLadders) {
            int ladderStart = rand.nextInt(board.getStart(), board.getEnd());
            int ladderEnd = rand.nextInt(board.getStart(), board.getEnd());

            if (ladderStart >= ladderEnd) {
                continue;
            }
            String startEndPair = String.valueOf(ladderStart) + ladderEnd;

            if(snakeStarts.contains(ladderStart) || snakeStarts.contains(ladderEnd)){
                continue;
            }

            if (!sl.contains(startEndPair)) {
                Ladder newLadder = new Ladder(ladderStart, ladderEnd);
                ladders.add(newLadder);
                sl.add(startEndPair);

            }
        }

     snakeStarts.clear();
     snakeEnds.clear();
     sl.clear();
        for(Ladder ladder:ladders){
            System.out.println("the ladders are like following");
            System.out.println("start:"+ladder.getStart()+" end:"+ladder.getEnd());
        }
        for(Snake snake:snakes){
            System.out.println("the snakes are like following");
            System.out.println("start:"+snake.getHead()+" end:"+snake.getTail());
        }

        System.out.println("Size of ladder is"+this.ladders.size());
        System.out.println("Size of snakes is"+this.snakes.size());
    }

    public void playGame(){
    int n= players.size();
    int count=0;

        while(true){
            Player player = players.poll();
            int rolledDice = dice.roll();
            System.out.println("Player "+player.getName()+" rolled "+rolledDice);
            int currPosition = player.getPosition();
            int newPosition =currPosition+rolledDice;

            if(newPosition>board.getEnd()){
                player.setPosition(currPosition);
                players.offer(player);
                System.out.println("which is invalid because its above the boundary so "+player.getName()+" misses chance");
                continue;
            }
            else{
                System.out.println("Player "+player.getName()+" goes from "+currPosition+"to "+newPosition);

                newPosition = traverse(board,newPosition,rolledDice,ladders,snakes,player);
                player.setPosition(newPosition);
                if(newPosition==board.getEnd()){
                    player.setWin(true);


                        System.out.println(player.getName()+" wins!");


                }
                else{
                    players.offer(player);

                }
            }
            count++;
            if(count%n==0) {
                System.out.println(" ");
                System.out.println(" ");
            }
            if(players.size()<2) break;
        }


    }


    public int traverse(Board board, int currPosition, int rolledDice, List<Ladder> ladders, List<Snake> snakes, Player player){

        int newPosition = currPosition;

        for(Snake snake:snakes){
            if(newPosition==snake.getHead()){
                System.out.println("Player "+player.getName()+" got eaten by snake");
                newPosition=snake.getTail();
                System.out.println("Player "+player.getName()+" goes from "+currPosition+"to "+newPosition);
            }
        }
        for(Ladder ladder:ladders){
            if(newPosition==ladder.getStart()){
                System.out.println("Player "+player.getName()+" climbs the ladder");
                newPosition=ladder.getEnd();
                System.out.println("Player "+player.getName()+" goes from "+currPosition+"to "+newPosition);
            }
        }

        return newPosition;
    }
}
