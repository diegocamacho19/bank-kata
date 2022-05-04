import java.util.Date;

public class StartApp {
    public static void main(String[] args) {
        Account account = new Account(new Statement());

        account.deposit(Float.valueOf(1000), date("10/01/2021"));
        account.deposit(Float.valueOf(2000), date("13/01/2021"));
        account.withdraw(Float.valueOf(500), date("14/01/2021"));

        account.printStatements();
    }

    public static Date date(String date){
        return new Date(date);
    }


}
