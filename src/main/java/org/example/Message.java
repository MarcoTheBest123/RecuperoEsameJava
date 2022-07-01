package org.example;

public class Message {
    int letterCount;
    int wordsCount;
    String replacedString;


    public Message(int length, int totParole, String replacedString) {
        this.letterCount = length;
        this.wordsCount = totParole;
        this.replacedString = replacedString;
    }

/*    @Override
    public String toString() {
        return "Message{" +
                "letterCount=" + letterCount +
                ", wordsCount=" + wordsCount +
                ", replacedString='" + replacedString + '\'' +
                '}';
    }
*/
    public int getLetterCount() {
        return letterCount;
    }

    public void setLetterCount(int letterCount) {
        this.letterCount = letterCount;
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public String getReplacedString() {
        return replacedString;
    }

    public void setReplacedString(String replacedString) {
        this.replacedString = replacedString;
    }
}