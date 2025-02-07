
package word_ladder;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Word_Ladder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "しりとり";
        int score = 0;
        Set<String> usedWords = new HashSet<>();

        for (int i = 0; i < 15; i++) {
            char tail = showCharacter(word);

            System.out.print("「" + tail + "」 ");
            String newWord = inputWord(scanner);
            char head = newWord.charAt(0);
            
            // for last word = ん
            if (showCharacter(newWord) =='ん'){
            	System.out.println("ゲーム終了です。"+"      "+ "スコア: " + score + "です。");
            	break;//最後にが出たらゲーム終了
            }

            if (showCharacter(newWord) == 'ー') {
                newWord = newWord.substring(0, newWord.length() - 1);
            }//入力した言葉の最後に, ー が出たら、その1個前の文字を取る

            if (usedWords.contains(newWord)) {
                System.out.println("その言葉はすでに使用されています。");
                continue; //入力した言葉を既に入ってた時
            }

            if (newWord==word) {
                System.out.println("同じ言葉を繰り返すことはできません。");
                continue;//同じ言葉を二度と使わないため
            }

            if (!areCharactersEqual(head, tail)) {
                System.out.println("違います");
               
                continue;
            }

            if (newWord.length() <= 2) {
                System.out.println("二つ文字以上の言葉をご入力してください。");
                continue;
            }

            System.out.print("正解です。" + "        ");
            score += 10; // Increment score by 10 for each correct word
            System.out.println("スコア: " + score);
            usedWords.add(newWord); // Add the word to the used words set
            word = newWord;
        }
    }

    static char showCharacter(String str) {
        int i = str.length() - 1;
        char tail = str.charAt(i);
        return tail;
    }

    static String inputWord(Scanner scanner) {
        System.out.println("で始まる言葉を入力してください。");
        return scanner.next();
    }

    static boolean areCharactersEqual(char head, char tail) {
        if (head == 'ゃ' || head == 'ゅ' || head == 'ょ') {
            head = convertSmallLetter(head);
        }

        if (tail == 'ゃ' || tail == 'ゅ' || tail == 'ょ') {
            tail = convertSmallLetter(tail);
        }

        return head == tail;
    }

    static char convertSmallLetter(char small_letter) {
        switch (small_letter) {
            case 'ゃ':
                return 'や';
            case 'ゅ':
                return 'ゆ';
            case 'ょ':
                return 'よ';
            case 'っ':
                return 'つ';
            default:
                return small_letter; 
        }
    }
}