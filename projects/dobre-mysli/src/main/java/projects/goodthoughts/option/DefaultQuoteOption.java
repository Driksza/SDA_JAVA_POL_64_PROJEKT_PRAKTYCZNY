package projects.goodthoughts.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import projects.goodthoughts.model.Quote;
import projects.goodthoughts.service.QuoteService;

import java.util.Scanner;

public class DefaultQuoteOption implements Option {
    private static final Logger logger = LoggerFactory.getLogger(DefaultQuoteOption.class);
    private final QuoteService quoteService = new QuoteService();

    public static void main(String[] args) {
        DefaultQuoteOption option = new DefaultQuoteOption();
        option.run();
    }

    @Override
    public void executeOption(String userInput) {
        Quote defoultQuote = quoteService.getDefaultQuote();
        logger.debug("Probany cytat: {}", defoultQuote);

        System.out.printf("Cytat na dziś:%n \"%s\" (%s)%n", defoultQuote.getContent(), defoultQuote.getAuthor());

        System.out.println("\nCzy zapisać? (tak dla zapisu): ");
        String input = new Scanner(System.in).nextLine();

        if("tak".equals(input)) {
            Quote savedQuote = quoteService.save(defoultQuote);
            logger.info("Zapisano cytat: {}",savedQuote);

            // Tymczasowe
            quoteService.showSavedQuotes();
        }

    }



}















