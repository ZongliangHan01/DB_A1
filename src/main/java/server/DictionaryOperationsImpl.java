package server;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class DictionaryOperationsImpl implements DictionaryOperations{

    @Override
    public void deleteWord() {
        System.out.println("delete a word");
    }

    @Override
    public void updateWord() {
        System.out.println("update a word");
    }

    @Override
    public void addWord() {
        System.out.println("add a word");
    }

    @Override
    public void readWord(String targetWord) {
//        public Word[] get

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("src/main/java/server/dictionary.json");
            ClassLoader classLoader = getClass().getClassLoader();
//            Word[] words = objectMapper.readValue(
//                    classLoader.getResourceAsStream("dictionary.json"),
//                    Word[].class
//            );

            Word[] words = objectMapper.readValue(
                    file,
                    Word[].class
            );

            for (Word word : words) {
                if (word.getWord().equals(targetWord)) {
                    System.out.println("Word found: " + word.getWord() + " (" + word.getMeaning() + ")");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("read a word");
    }
}
