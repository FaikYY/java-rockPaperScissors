import java.util.Random;
import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
        
    Player p1 = new Player();
    Bot bot = new Bot();

    boolean isGameOver = false;
    int randomNumber;
    final int FINAL_SCORE = 3;

    public void playGame(){
        while(isGameOver == false){
            playerTurn();
            botTurn();
            checkMove();
            checkScore();
        }
    }

    public void print(String text){
        System.out.println(text);
    }

    public void print(int text){
        System.out.println(text);
    }

    public void checkScore(){
        if(bot.score == FINAL_SCORE){
            print("BOT WINS!");
            isGameOver = true;
            printScoreTable();
            scanner.close();
        }
        else if(p1.score == FINAL_SCORE){
            print("YOU WIN!");
            isGameOver = true;
            printScoreTable();
            scanner.close();
        }
        else{
            printScoreTable();
            print("\n");
        }
    }

    public void printScoreTable(){
        print("#########################");
        print("##### Bot  Score: " + bot.score + " #####");
        print("##### Your Score: " + p1.score + " #####");
        print("#########################");
    }
    
    public void playerTurn(){
        // ask for input
        System.out.print("Please enter your move: ");
        
        // take input
        p1.move = scanner.nextLine();
    }

    public void botTurn(){
        // pick a number between 1-3
        randomNumber = random.nextInt((3 - 1) + 1) + 1;
        
        // choose a move based on the random number generated above
        switch(randomNumber){
            case 1:
                bot.move = "Rock";
                print("Bot Move: " + bot.move);
                break;
            case 2:
                bot.move = "Paper";
                print("Bot Move: " + bot.move);
                break;
            case 3:
                bot.move = "Scissors";
                print("Bot Move: " + bot.move);
                break;
        }
    }
    
    public void checkMove(){
        if (p1.move.equalsIgnoreCase("rock") && bot.move.equalsIgnoreCase("rock")){
            print("Draw!");
        }
        else if(p1.move.equalsIgnoreCase("rock") && bot.move.equalsIgnoreCase("paper")){
            print("Bot got you!");
            bot.score++;
        }
        else if(p1.move.equalsIgnoreCase("rock") && bot.move.equalsIgnoreCase("scissors")){
            print("You got him!");
            p1.score++;
        }
        else if (p1.move.equalsIgnoreCase("paper") && bot.move.equalsIgnoreCase("rock")){
            print("You got him!");
            p1.score++;
        }
        else if(p1.move.equalsIgnoreCase("paper") && bot.move.equalsIgnoreCase("paper")){
            print("Draw!");
        }
        else if(p1.move.equalsIgnoreCase("paper") && bot.move.equalsIgnoreCase("scissors")){
            print("Bot got you!");
            bot.score++;
        }
        else if (p1.move.equalsIgnoreCase("scissors") && bot.move.equalsIgnoreCase("rock")){
            print("Bot got you!");
            bot.score++;
        }
        else if(p1.move.equalsIgnoreCase("scissors") && bot.move.equalsIgnoreCase("paper")){
            print("You got him!");
            p1.score++;
        }
        else if(p1.move.equalsIgnoreCase("scissors") && bot.move.equalsIgnoreCase("scissors")){
            print("Draw!");
        }
    }
}
