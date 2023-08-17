package server;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DictionaryOperationsImpl implements DictionaryOperations{

    @Override
    public void deleteWord(String targetWord) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            File jsonFile = new File("src/main/java/server/dictionary.json");

            Word[] words = objectMapper.readValue(jsonFile, Word[].class);

            List<Word> updatedWords = new ArrayList<>();

            for (Word word : words) {
                if (!word.getWord().equals(targetWord)) {
                    updatedWords.add(word);
                } else {
                    System.out.println("Word deleted successfully.");
                }
            }
            //TODO: write out the message when target word does not exist
            objectMapper.writeValue(jsonFile, updatedWords);


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("delete a word");
    }

    @Override
    public void updateWord(String targetWord, String newMeaning) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            boolean exist = false;
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            File jsonFile = new File("src/main/java/server/dictionary.json");

            Word[] words = objectMapper.readValue(jsonFile, Word[].class);
            for (Word word: words) {
                if (word.getWord().equals(targetWord)) {
                    word.setMeaning(newMeaning);
                    exist = true;
                    System.out.println("Update the meaning of target word");
                    break;
                }
            }
            if (!exist) {
                System.out.println("This word does not exist, please use add function");
            }
            objectMapper.writeValue(jsonFile, words);


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("update a word");
    }

    @Override
    public void addWord(String newWord, String meaning) {
        try {
            boolean exist = false;
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            File jsonFile = new File("src/main/java/server/dictionary.json");

            Word[] words = objectMapper.readValue(jsonFile, Word[].class);

            List<Word> wordsList = new ArrayList<>(Arrays.asList(words));
//            List<Word> updatedWords = new ArrayList<>(Arrays.asList(existingWords));
            Word wordToAdd = new Word(newWord, meaning);
            for (Word word : words) {
                if (word.getWord().equals(newWord)) {
                    System.out.println("this world already exist in the dictionary, please use update method");
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                wordsList.add(wordToAdd);
                System.out.println(("Add a new word in the dictionary"));
            }
            objectMapper.writeValue(jsonFile, wordsList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("add a word");
    }

    @Override
    public void readWord(String targetWord) {
//        public Word[] get

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("src/main/java/server/dictionary.json");
//            ClassLoader classLoader = getClass().getClassLoader();

            Word[] words = objectMapper.readValue(file, Word[].class);



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
