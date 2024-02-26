## FRQ Question 2

Write the complete HiddenWord class, including any necessary instance variables, its constructor, and the method, getHint, described above. You may assume that the length of the guess is the same as the length of the hidden word.

```java
import java.util.Scanner;
public class HiddenWord {
    private String word;
    public HiddenWord(String hiddenWord){
        word = hiddenWord;
    }
    public String getHint(String attempt){
        String hint = "";
        for(int i=0; i<attempt.length();i++){
            if(attempt.charAt(i)==word.charAt(i)){
                hint+=attempt.charAt(i);
            }
            else if(word.indexOf(attempt.charAt(i))!=-1){
                hint+="+";
            }
            else{
                hint+="*";
            }
        }
        return hint;
    }
    public static void main(String[] args) {
        HiddenWord puzzle = new HiddenWord("HARPS");
        Scanner scan = new Scanner(System.in);
        boolean playing = true;
        while (playing){
            System.out.println("Guess a 5 letter word");
            String attempt = scan.nextLine();
            System.out.println(attempt);
            String hint = puzzle.getHint(attempt);
            System.out.println("Hint: "+hint);
            if(hint.equals(puzzle.word)){
                System.out.println("You win");
                playing=false;
            }
        }
    }
}
HiddenWord.main(null);
```

This question is about creating a fun word guessing game. It tests if we can set up the game with a hidden word and give hints based on player guesses. We use classes and methods to organize the game, making it easier to manage. It's also a test of our skills in comparing and changing words, figuring out which letters match and which don't. Overall, it's a cool way to see how we handle game logic in programming.