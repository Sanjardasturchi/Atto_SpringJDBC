package org.example.springConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "org.example")
@Configuration
public class SpringConfig {

//    @Bean
//    public Controller controller(ScannerUtils scanner, UserService userService,
//                                 CardService cardService, TerminalService terminalService, TransactionService transactionService) {
//        Controller controller = new Controller();
//        controller.setScanner(scanner);
//        controller.setCardService(cardService);
//        controller.setUserService(userService);
//        controller.setTerminalService(terminalService);
//        controller.setTransactionService(transactionService);
//
//        return controller;
//    }
//
//    @Bean
//    public CardRepository cardRepository() {
//        CardRepository cardRepository = new CardRepository();
//        return cardRepository;
//    }
//
//    @Bean
//    public ProfileRepository profileRepository() {
//        ProfileRepository profileRepository = new ProfileRepository();
//        return profileRepository;
//    }
//
//
//    @Bean
//    public CardService cardService(CardRepository cardRepository) {
//        CardService cardService = new CardService();
//        cardService.setCardRepository(cardRepository);
//        return cardService;
//    }
//
//    @Bean
//    public TerminalService terminalService(TerminalRepository terminalRepository) {
//        TerminalService terminalService = new TerminalService();
//        terminalService.setTerminalRepository(terminalRepository);
//        return terminalService;
//    }
//
//    @Bean
//    TransactionService transactionService(TransactionRepository transactionRepository, CardRepository cardRepository, TerminalRepository terminalRepository) {
//        TransactionService transactionService = new TransactionService();
//        transactionService.setTransactionRepository(transactionRepository);
//        transactionService.setTerminalRepository(terminalRepository);
//        transactionService.setCardRepository(cardRepository);
//        return transactionService;
//    }
//
//    @Bean
//    public UserService userService(ProfileRepository profileRepository) {
//        UserService userService = new UserService();
//        userService.setProfileRepository(profileRepository);
//        return userService;
//    }
//
//    @Bean
//    public ScannerUtils scannerUtils() {
//        ScannerUtils scannerUtils = new ScannerUtils();
//        return scannerUtils;
//    }


}
