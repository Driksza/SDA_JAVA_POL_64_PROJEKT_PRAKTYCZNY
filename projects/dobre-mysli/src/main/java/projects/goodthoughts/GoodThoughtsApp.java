package projects.goodthoughts;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import projects.goodthoughts.config.DbUtil;
import projects.goodthoughts.model.Quote;
import projects.goodthoughts.option.DefaultQuoteOption;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;

public class GoodThoughtsApp implements projects.goodthoughts.option.Option {

    private static final Logger logger = LoggerFactory.getLogger(GoodThoughtsApp.class);


    public static void main(String[] args) {
        System.out.println("Witaj");
        logger.info("Uruchamianie aplikacji ...");

        Quote quote1 = new Quote("Life is beautiful", "Życie jest piękne",
                "Anonim", "Życiowe", LocalDateTime.now());
        Quote quote2 = new Quote("Life is brutal and full of zasadzkas",
                "Życie jest brutalne i pełne zasadzek", "Wujek dobra rada",
                "Życiowe", LocalDateTime.now().minusMonths(3));

        logger.debug("Tets cytatu 1: " + quote1 + "koniec");
        logger.debug("Tets cytatu 2: {}", quote2);
        logger.debug(String.format("Oba cytaty,1 %s, 2: %s", quote1, quote2));

        Session session = DbUtil.getSession();
        System.out.println(session);


        GoodThoughtsApp app = new GoodThoughtsApp();
        app.run();

    }

    @Override
    public void showGoodbyeMessage() {
        System.out.println("Dziękujemy za skorzystanie z naszej aplikacji.");
    }

    @Override
    public void showInvalidOptionMessage(String userInput) {
        System.out.println("Wybrałeś nieprawidłową opcję ('" + userInput + "')");
    }

    @Override
    public boolean checkIsExitOption(String userInput) {
        //return  userInput.equals("0");
        return "0".equals(userInput); //gdyby NULL
    }

    @Override
    public void executeOption(String userInput) {
        logger.debug("Wykonana opcja: {}", userInput);
        switch (userInput) {
            case "1":
                executeDefaultQuoteOption();
                break;
            case "2":
            case "3":

        }
    }

    public void executeDefaultQuoteOption() {
        DefaultQuoteOption option = new DefaultQuoteOption();
        option.run();

    }

    @Override
    public boolean validateOption(String userInput) {
        Set<String> validOptions = Set.of("0", "1", "2", "3");
        return validOptions.contains(userInput);
    }

    @Override
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nTwój wybór to: ");
        String userInput = scanner.nextLine();
        return userInput.trim();
    }

    @Override
    public void showMenu() {
        System.out.println("Wybierz opcję z listy poniżej:");
        System.out.println("\t1. Pobieranie domyślnego cytat");
        System.out.println("\t2. Dodaj własny cytat");
        System.out.println("\t3. Wyświetl zapisane cytaty");
        System.out.println("\t0. Zakończ");
    }

    @Override
    public void showWelcomeMessage() {
        System.out.println("Witaj w naszej aplikacji (" + LocalDateTime.now() + ")");
    }
}
