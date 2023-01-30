import java.util.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;

public class TransactionMenu extends Account {
    int menuInput;
    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'£'###,##0.00");
    HashMap<Integer, Integer> customerData = new HashMap<>();

    private boolean isAlpha(String s) {
        return s.chars().allMatch(Character::isLetter);
    }

    private boolean isNotNull(String s) {
        return s != null;
    }

    private int isEqualIgnoreCase(String s) {
        if (isNotNull(s) && isAlpha(s) && s.equalsIgnoreCase("y")) {
            return 1;
        }
        else if (isNotNull(s) && isAlpha(s) && s.equalsIgnoreCase("n")) {
            return 0;
        }
        else {
            return -1;
        }
    }

    private void setAnythingElsePrompt(int accountType) throws IOException {
        System.out.print("\nAnything else...? (y:Yes | n:No) ");
        char choice = sc.next().charAt(0);
        String s = Character.toString(choice);
        int response = isEqualIgnoreCase(s);

        if (response == 1 && accountType == 1) {
            getCurrentAccount();
        }
        else if (response == 1 && accountType == 2) {
            getSavingsAccount();
        }
        else if (response == 0) {
            System.out.println("Thanks for using this ATM service. Goodbye!\n");
            getLogin();
        }
        else {
            System.out.println("Invalid Menu Option entered. Please try again:");
            setAnythingElsePrompt(accountType);
        }
    }

    private void getChoice(int accountType) throws IOException {
        try {
            menuInput = sc.nextInt();
        }
        catch (Exception e) {
            System.out.println("Invalid Character(s) were specified. Only 1 digit accepted.");
            sc.nextLine();

            switch (accountType) {
                case 0:
                    getAccountType();
                    break;
                case 1:
                    getCurrentAccount();
                    break;
                default:
                    getSavingsAccount();
            }
        }
    }

    private boolean disableCustomerAccountIfExists(int cn, int p) {
        return customerData.entrySet()
                .removeIf(
                        entry -> (cn == entry.getKey() || p == entry.getValue()));
    }

    private void logFailedAttempts(int attempts, int cn, int p) throws IOException {
        if (attempts == 3) {
            System.out.println("3 failed attempts to access account.\nMaximum number of attempts reached!");
            try {
                boolean flag = disableCustomerAccountIfExists(cn, p);
                String answer = (flag) ? "\nTransaction rejected and Customer Account locked.\n" :
                        "\nCustomer Account specified does not exist!\n";
                System.out.println(answer);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                getLogin();
            }
        }
    }

    protected void setCustomerAccounts() {
        customerData.put(840912, 4763);
        customerData.put(787461, 2398);
        customerData.put(458012, 4509);
        customerData.put(564314, 7510);
        customerData.put(953718, 3775);
    }

    protected void getLogin() throws IOException {
        System.out.println("=====================================================================");
        System.out.println("|\t\t\t\t\tWelcome to Bank Express ATM!\t\t\t\t\t|");
        System.out.println("=====================================================================\n");

        int attempts = 0;
        boolean again = true;
        do {
            try {
                System.out.print("Enter your Customer Number: ");
                setCustomerNumber(sc.nextInt());
                System.out.print("Enter your PIN: ");
                setPIN(sc.nextInt());
            }
            catch (Exception e) {
                System.out.println("Invalid Character(s) were specified. Only Digits accepted.\n");
                sc.nextLine();
                continue;
            }

            int cn = getCustomerNumber();
            int p = getPIN();
            if (customerData.containsKey(cn) && customerData.get(cn) == p) {
                getAccountType();
            }
            else {
                System.out.println("Incorrect Customer Number or PIN was specified. Please try again:\n");
                attempts++;
                logFailedAttempts(attempts, cn, p);
            }
        }
        while (again);
    }

    private void getAccountType() throws IOException {
        System.out.println("\nEnter a digit for the Account you want to access: ");
        System.out.println("[1] > Current Account");
        System.out.println("[2] > Savings Account");
        System.out.println("[3] > Exit");
        System.out.print("\nChoice: ");
        getChoice(0);

        switch (menuInput) {
            case 1:
                getCurrentAccount();
                break;
            case 2:
                getSavingsAccount();
                break;
            case 3:
                System.out.println("Thanks for using this ATM service. Goodbye!\n");
                getLogin();
                break;
            default:
                System.out.print("Invalid Menu Option entered. Please try again:\n");
                getAccountType();
        }
    }

    private void getCurrentAccount() throws IOException {
        System.out.println("\nCurrent Account: ");
        System.out.println("[1] > View Balance");
        System.out.println("[2] > Withdraw Funds");
        System.out.println("[3] > Deposit Funds");
        System.out.println("[4] > Return");
        System.out.println("[5] > Exit");
        System.out.print("\nChoice: ");
        getChoice(1);

        switch (menuInput) {
            case 1:
                System.out.println("Current Account Balance: " + moneyFormat.format(getCurrentBalance()));
                setAnythingElsePrompt(1);
                break;
            case 2:
                getCurrentWithdrawl();
                setAnythingElsePrompt(1);
                break;
            case 3:
                getCurrentDeposit();
                setAnythingElsePrompt(1);
                break;
            case 4:
                getAccountType();
                break;
            case 5:
                System.out.println("Thanks for using this ATM service. Goodbye!\n");
                getLogin();
                break;
            default:
                System.out.print("Invalid Menu Option entered. Please try again:\n");
                getCurrentAccount();
        }
    }

    private void getSavingsAccount() throws IOException {
        System.out.println("\nSavings Account: ");
        System.out.println("[1] > View Balance");
        System.out.println("[2] > Withdraw Funds");
        System.out.println("[3] > Deposit Funds");
        System.out.println("[4] > Return");
        System.out.println("[5] > Exit ");
        System.out.print("\nChoice: ");
        getChoice(2);

        switch (menuInput) {
            case 1:
                System.out.println("Savings Account Balance: " + moneyFormat.format(getSavingsBalance()));
                setAnythingElsePrompt(2);
                break;
            case 2:
                getSavingsWithdrawl();
                setAnythingElsePrompt(2);
                break;
            case 3:
                getSavingsDeposit();
                setAnythingElsePrompt(2);
                break;
            case 4:
                getAccountType();
                break;
            case 5:
                System.out.println("Thanks for using this ATM service. Goodbye!\n");
                getLogin();
                break;
            default:
                System.out.print("Invalid Menu Option entered. Please try again:\n");
                getSavingsAccount();
        }
    }
}