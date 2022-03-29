package com.circles24.threadstates;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
public class MenuHandler implements Runnable {

    private final static String EXIT_OPTION = "5";

    private final static String SLEEP_OPTION = "6";

    private void menu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            try {
                printMenu();
                String option = reader.readLine();
                if (EXIT_OPTION.equals(option)) {
                    break;
                } else if (SLEEP_OPTION.equals(option)) {
                    Thread.sleep(5000);
                }  else {
                    long num1 = Long.parseLong(reader.readLine());
                    long num2 = Long.parseLong(reader.readLine());
                    log.info("answer :: {}", Operation.compute(option, num1, num2));
                }
            } catch (Exception ex) {
                log.error("error while running menu loop", ex);
            }
        }
    }

    private void printMenu() {
        log.info("------ MENU ------");
        log.info("1. addition");
        log.info("2. subtraction");
        log.info("3. multiplication");
        log.info("4. multiplication");
        log.info("5. exit");
        log.info("6. sleep");
    }

    public void run() {
        menu();
    }
}
