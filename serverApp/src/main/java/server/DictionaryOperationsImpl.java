package server;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DictionaryOperationsImpl implements DictionaryOperations{

    //TODO: update the way of accessing json file
    @Override
    public String deleteWord(String targetWord) {
        File jsonFile = new File("/Users/zonglianghan/Desktop/DS/DS_A1/serverApp/src/main/java/server/dictionary.json");
        Word[] words = loadDatabase(jsonFile);
        String responseText = "Some error may occur";
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
            responseText = "Error: This word does not exist in dictionary";
        }

        writeIntoDatabase(jsonFile, updatedWords);
        System.out.println("delete a word");
        return responseText;
    }

    @Override
    public String updateWord(String targetWord, String[] newMeanings) {
        File jsonFile = new File("/Users/zonglianghan/Desktop/DS/DS_A1/serverApp/src/main/java/server/dictionary.json");
        Word[] words = loadDatabase(jsonFile);
        String responseText = "Some error may occur";
        boolean exist = false;
        for (Word word: words) {
            if (word.getWord().equals(targetWord)) {
                word.setMeaning(newMeanings);
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
    public String addWord(String newWord, String[] meanings) {
        boolean exist = false;
        String responseText = "Some error may occur";
        File jsonFile = new File("/Users/zonglianghan/Desktop/DS/DS_A1/serverApp/src/main/java/server/dictionary.json");
        Word[] words = loadDatabase(jsonFile);
        List<Word> wordsList = new ArrayList<>(Arrays.asList(words));
        Word wordToAdd = new Word(newWord, meanings);
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
        File jsonFile = new File("/Users/zonglianghan/Desktop/DS/DS_A1/serverApp/src/main/java/server/dictionary.json");
        Word[] words = loadDatabase(jsonFile);
        boolean exist = false;
        String responseText = "Some error may occur";
        for (Word word : words) {
            if (word.getWord().equals(targetWord)) {
                System.out.println("Word found: " + word.getWord() + " (" + word.getMeaning() + ")");
//                responseText = "Word found: " + word.getWord() + " (" + word.getMeaning() + ")";
                String meaning = "";
                for (String mean : word.getMeaning()) {
                    meaning = meaning + mean + "#";
                }
                responseText = meaning;
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

    private Word[] loadDatabase(File jsonFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//            File jsonFile = new File("src/main/java/server/dictionary.json");
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
