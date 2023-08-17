package server;

public interface DictionaryOperations {
    void deleteWord(String targetWord);
    void updateWord(String targetWord, String newMeaning);
    void addWord(String newWord, String meaning);
    void readWord(String targetWord);

}
