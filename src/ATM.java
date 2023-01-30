import java.io.IOException;

public class ATM extends TransactionMenu {
    public static void main(String[] args) throws IOException {
        TransactionMenu tmo = new TransactionMenu();
        tmo.setCustomerAccounts();
        tmo.getLogin();
    }
}