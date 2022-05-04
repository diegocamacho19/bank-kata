import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Account {

    private Statement statement;
    private int count = 0;

    private List<String> lstString;
    public Account(Statement statement){
        this.statement = statement;
        lstString = new ArrayList<>();
    }

    void deposit(Float amount, Date fecha) {
        Float saldo = operation(amount, fecha);
        statement.setSaldo(saldo += amount);
        lstString.add(statement.getFecha()+"  "+statement.getMonto()+"  "+ statement.getRetiro()+ "  "+statement.getSaldo());

    }

    void withdraw(Float amount, Date fecha){
        Float saldo = operation(amount, fecha);
        statement.setSaldo(saldo -= amount);
        statement.setMonto(Float.valueOf(0));
        statement.setRetiro(amount);
        lstString.add(statement.getFecha()+"  "+statement.getMonto()+"  "+ statement.getRetiro()+ "  "+statement.getSaldo());
    }

    void printStatements() {
        System.out.println("date  credit  debit  balance");
        lstString.stream().sorted(Comparator.reverseOrder()).forEach(statementString ->{
            System.out.println(statementString);
        });
    }

    public Float operation(Float amount, Date fecha){
        statement.setMonto(amount);
        statement.setFecha(fecha);
        Float saldo = statement.getSaldo();

        return saldo;
    }

}
