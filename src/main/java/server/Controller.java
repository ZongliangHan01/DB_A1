package server;

public class Controller {
    DictionaryOperationsImpl operations = new DictionaryOperationsImpl();

    //TODO: function to parse the string to the right format
    private String[] handleInput(String input) {
        return input.split("#");

    }


    public void getCommand(String input) {   // this function get the string from the server,
        String[] inputSplit = handleInput(input);
        String command = inputSplit[0];
        String word = inputSplit[1];
        String meaning = inputSplit[2];
        switch (command) {
            case "read":
                readWord(word);
                break;
            case "add":
                addWord(word, meaning);
                break;
            case "update":
                updateWord(word, meaning);
                break;
            case "delete":
                deleteWord(word);
                break;
            default:
                System.out.println("wrong command");
        }
    }

    private void readWord(String targetWord) {
        operations.readWord(targetWord);
    }

    private void deleteWord(String targetWord) {
        operations.deleteWord(targetWord);
    }

    private void updateWord(String targetWord, String newMeaning) {
        operations.updateWord(targetWord, newMeaning);
    }

    private void addWord(String newWord, String meaning) {
        operations.addWord(newWord, meaning);
    }
}
