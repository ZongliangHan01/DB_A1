package server;

public class Controller {
    DictionaryOperationsImpl operations = new DictionaryOperationsImpl();

    //TODO: function to parse the string to the right format
    private String[] handleInput(String input) {
        String[] inputSplit = new String[3];
        String[] split = input.split("#");
        int i=0;
        for (String str: split) {
            inputSplit[i] = str;
            i+=1;
        }
//        Arrays.fill(inputSplit, "null");

        return inputSplit;
    }


    public String getCommand(String input) {   // this function get the string from the server,
        String[] inputSplit = handleInput(input);
        String response;
        String command = inputSplit[0];
        String word = inputSplit[1];
        String meaning = inputSplit[2];
        for (String str: inputSplit) {
            System.out.println(str);
        }
        switch (command) {
            case "read":
                response = readWord(word);
                break;
            case "add":
                response = addWord(word, meaning);
                break;
            case "update":
                response = updateWord(word, meaning);
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

    private String updateWord(String targetWord, String newMeaning) {
        return operations.updateWord(targetWord, newMeaning);
    }

    private String addWord(String newWord, String meaning) {
       return operations.addWord(newWord, meaning);
    }
}
