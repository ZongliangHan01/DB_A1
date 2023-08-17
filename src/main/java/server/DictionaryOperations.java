package server;

public interface DictionaryOperations {
    String deleteWord(String targetWord);
    String updateWord(String targetWord, String newMeaning);
    String addWord(String newWord, String meaning);
    String readWord(String targetWord);

}
