import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

    private Statement statement;

    private List<Statement> lstStatement;
    public Account(Statement statement){
        this.statement = statement;
        lstStatement = new ArrayList<>();
    }

    void deposit(Float amount, Date fecha) {
        Float saldo = operation(amount, fecha);
        statement.setSaldo(saldo += amount);
        lstStatement.add(statement);

    }

    void withdraw(Float amount, Date fecha){
        Float saldo = operation(amount, fecha);
        statement.setSaldo(saldo -= amount);
        statement.setRetiro(amount);
        lstStatement.add(statement);

    }

    void printStatements() {
        System.out.println("date  credit  debit  balance");
        lstStatement.stream().forEach(statement ->{
            System.out.println(statement.getFecha()+"  "+statement.getMonto()+"  "+ statement.getRetiro()+ "  "+statement.getSaldo());
        });
    }

    public Float operation(Float amount, Date fecha){
        statement.setMonto(amount);
        statement.setFecha(fecha);
        Float saldo = statement.getSaldo();

        return saldo;
    }

}
