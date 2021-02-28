package projects.goodthoughts.option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;
import java.util.Set;
public class DefaultQuoteOption {
    private static final Logger logger = LoggerFactory.getLogger(DefaultQuoteOption.class);


    public static void main(String[] args) {
        DefaultQuoteOption option = new DefaultQuoteOption();
        option.run();
    }
    public void run(Object... args) {
        logger.info("Uruchamianie aplikacji DefaultQuoteOption");
        showWelcomeMessage();
        while (true) {        // nieskończona pętla
            showMenu();
            String userInput = getUserInput();
            boolean isValidOption = validateOption(userInput);
            if (isValidOption) {
                executeOption(userInput);
                boolean isExitOption = checkIsExitoption(userInput);
                if (isExitOption) {
                    break;
                }
            } else {
                showInvalidOptionMassage(userInput);
            }
        }
        showGoodbyeMessage();
        logger.info("Zakończono pracę aplikacji DefaultQuoteOption");
    }
    private void showGoodbyeMessage() {
    }
    private void showInvalidOptionMassage(String userInput) {
    }
    private boolean checkIsExitoption(String userInput) {
        return true;
    }
    private void executeOption(String userInput) {
        

    }
    private boolean validateOption(String userInput) {
        return  true;
    }
    private String getUserInput() {
        return "";
    }
    private void showMenu() {
    }
    private void showWelcomeMessage() {
        System.out.println("Pobieram cytat ...");
    }
}















