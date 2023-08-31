/*
Zongliang Han
1166050
 */

package server;

import java.io.File;

public class Controller {
    DictionaryOperationsImpl operations;
    File file;

    public Controller(File file) {
        this.file = file;
        this.operations =  new DictionaryOperationsImpl(file);
    }
    //TODO: function to parse the string to the right format
    private String[] handleInput(String input) {
        String[] inputSplit = new String[10];
        String[] split = input.split("#");
        int i=0;
        for (String str: split) {
            inputSplit[i] = str;
            i+=1;
        }
//        Arrays.fill(inputSplit, "null");

        return split;
    }


    public String getCommand(String input) {   // this function get the string from the server,
        String[] inputSplit = handleInput(input);
        String response;
        String command = inputSplit[0];
        String word = inputSplit[1];
        String[] meanings = new String[inputSplit.length-2];
        for (int i = 2; i < inputSplit.length; i++) {
            meanings[i - 2] = inputSplit[i];
        }
        for (String str: inputSplit) {
            System.out.println(str);
        }

        for (String str: meanings) {
            System.out.println(str);
        }

        switch (command) {
            case "read":
                response = readWord(word);
                break;
            case "add":
                response = addWord(word, meanings);
                break;
            case "update":
                response = updateWord(word, meanings);
                break;
            case "delete":
                response = deleteWord(word);
                break;
            default:
                System.out.println("wrong command");
                response = "wrong command";
        }
        return response;
    }

    private String readWord(String targetWord) {

        return operations.readWord(targetWord);
    }

    private String deleteWord(String targetWord) {
        return operations.deleteWord(targetWord);
    }

    private String updateWord(String targetWord, String[] newMeanings) {
        return operations.updateWord(targetWord, newMeanings);
    }

    private String addWord(String newWord, String[] meanings) {
       return operations.addWord(newWord, meanings);
    }
}
