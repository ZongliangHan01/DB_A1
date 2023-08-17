package server;

public class Controller {
    DictionaryOperationsImpl operations = new DictionaryOperationsImpl();

    //TODO: function to parse the string to the right format
    private String[] handleInput(String input) {
        return input.split(" ");

    }


    public void getCommand(String input) {   // this function get the string from the server,
        String[] inputSplit = handleInput(input);
        int command = Integer.parseInt(inputSplit[0]);
        String word = inputSplit[1];
        switch (command) {
            case 1:
                readWord(word);
                break;
            case 2:
                addWord();
                break;
            case 3:
                updateWord();
            case 4:
                deleteWord();
            default:
                System.out.println("wrong command");
        }
    }

    private void readWord(String targetWord) {
        operations.readWord(targetWord);
    }

    private void deleteWord() {
        operations.deleteWord();
    }

    private void updateWord() {
        operations.updateWord();
    }

    private void addWord() {
        operations.addWord();
    }
}
