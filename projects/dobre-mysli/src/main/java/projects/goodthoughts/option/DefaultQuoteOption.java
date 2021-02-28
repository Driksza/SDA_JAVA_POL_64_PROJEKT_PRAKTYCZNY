package projects.goodthoughts.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import projects.goodthoughts.model.Quote;
import projects.goodthoughts.service.QuoteService;

public class DefaultQuoteOption {
    private static final Logger logger = LoggerFactory.getLogger(DefaultQuoteOption.class);
    private final QuoteService quoteService = new QuoteService();

    public static void main(String[] args) {
        DefaultQuoteOption option = new DefaultQuoteOption();
        option.run();
    }

    public void run(Object... args) {
        logger.info("Uruchamianie opcji DefaultQuoteOption ..");
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
        logger.info("Zakończono opcję DefaultQuoteOption");
    }

    private void showGoodbyeMessage() {
        //Nothing
    }

    private void showInvalidOptionMassage(String userInput) {
        //Nothing

    }

    private boolean checkIsExitoption(String userInput) {

        return true;
    }

    private void executeOption(String userInput) {
        Quote defoultQuote = quoteService.getDefaultQuote();
        logger.debug("Probany cytat: {}", defoultQuote);

        System.out.printf("\tCytat na dziś: \"%s\" (%s)%n", defoultQuote.getContent(), defoultQuote.getAuthor());

    }

    private boolean validateOption(String userInput) {

        return true;
    }

    private String getUserInput() {

        return "";
    }

    private void showMenu() {
        //Nothing
    }

    private void showWelcomeMessage() {
        System.out.println("Pobieram cytat ...");
    }
}















