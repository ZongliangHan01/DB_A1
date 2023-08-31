/*
Zongliang Han
1166050
 */

package server;

public interface DictionaryOperations {
    String deleteWord(String targetWord);
    String updateWord(String targetWord, String[] newMeanings);
    String addWord(String newWord, String[] meanings);
    String readWord(String targetWord);

}
