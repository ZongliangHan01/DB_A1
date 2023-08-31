/*
Zongliang Han
1166050
 */

package server;

import java.util.List;
import java.util.ArrayList;

public class Word {
    private String word;
    private String[] meanings;
//    private List<String> stringList = new ArrayList<>();

    public Word(String word, String[] meanings) {
        this.word = word;
        this.meanings = meanings;
    }

    public Word() {

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

//    public String getMeaning() {
//        String meaning = "";
//        for (String mean : meanings) {
//            meaning = meaning + mean + "#";
//        }
//        return meaning;
//    }

    public String[] getMeaning() {
        return meanings;
    }
    public void setMeaning(String[] meanings) {
        this.meanings = meanings;
    }
}