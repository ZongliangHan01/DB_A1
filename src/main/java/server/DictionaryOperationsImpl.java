package server;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DictionaryOperationsImpl implements DictionaryOperations{

    @Override
    public String deleteWord(String targetWord) {
        Word[] words = loadDatabase();
        String responseText = "Some error may occur";
        File jsonFile = new File("src/main/java/server/dictionary.json");
        boolean exist = false;
        List<Word> updatedWords = new ArrayList<>();

        for (Word word : words) {
            if (!word.getWord().equals(targetWord)) {
                updatedWords.add(word);
            } else {
                System.out.println("Word deleted successfully.");
                responseText = "Word deleted successfully.";
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("This word does not exist in dictionary");
            responseText = "This word does not exist in dictionary";
        }

        writeIntoDatabase(jsonFile, updatedWords);
        System.out.println("delete a word");
        return responseText;
    }

    @Override
    public String updateWord(String targetWord, String newMeaning) {
        Word[] words = loadDatabase();
        String responseText = "Some error may occur";
        boolean exist = false;
        File jsonFile = new File("src/main/java/server/dictionary.json");
        for (Word word: words) {
            if (word.getWord().equals(targetWord)) {
                word.setMeaning(newMeaning);
                exist = true;
                System.out.println("Update the meaning of target word");
                responseText = "Update the meaning of target word";
                break;
            }
        }
        if (!exist) {
            System.out.println("This word does not exist, please use add function");
            responseText = "This word does not exist, please use add function";
        }
        List<Word> wordsList = new ArrayList<>(Arrays.asList(words));
        writeIntoDatabase(jsonFile, wordsList);
        System.out.println("update a word");
        return responseText;
    }

    @Override
    public String addWord(String newWord, String meaning) {
        boolean exist = false;
        String responseText = "Some error may occur";
        File jsonFile = new File("src/main/java/server/dictionary.json");
        Word[] words = loadDatabase();
        List<Word> wordsList = new ArrayList<>(Arrays.asList(words));
        Word wordToAdd = new Word(newWord, meaning);
        for (Word word : words) {
            if (word.getWord().equals(newWord)) {
                System.out.println("this world already exist in the dictionary, please use update method");
                responseText = "this world already exist in the dictionary, please use update method";
                exist = true;
                break;
            }
        }
        if (!exist) {
            wordsList.add(wordToAdd);
            System.out.println(("Add a new word in the dictionary"));
            responseText = "Add a new word in the dictionary";
        }
        writeIntoDatabase(jsonFile, wordsList);
        System.out.println("add a word");
        return responseText;
    }

    @Override
    public String readWord(String targetWord) {
        Word[] words = loadDatabase();
        boolean exist = false;
        String responseText = "Some error may occur";
        for (Word word : words) {
            if (word.getWord().equals(targetWord)) {
                System.out.println("Word found: " + word.getWord() + " (" + word.getMeaning() + ")");
                responseText = "Word found: " + word.getWord() + " (" + word.getMeaning() + ")";
                exist = true;
                break;
            }
        }
        if (!exist) {
            responseText = "Word does not find";
        }
        System.out.println("read a word");
        return responseText;
    }

    private Word[] loadDatabase() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            File jsonFile = new File("src/main/java/server/dictionary.json");
            Word[] words = objectMapper.readValue(jsonFile, Word[].class);
            return words;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeIntoDatabase(File jsonFile, List<Word> words) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(jsonFile, words);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
