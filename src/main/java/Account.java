import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
	public Float lastBalance = Float.valueOf(0);
    private List<Statement> lstStatement;
    public Account(Statement statement){
        lstStatement = new ArrayList<>();
    }

    void deposit(Float amount, Date fecha) {
        Statement stt = new Statement();
        stt.setFecha(fecha);
        stt.setMonto(amount);
        stt.setSaldo(lastBalance + amount);
        this.lastBalance = lastBalance + amount ;
        lstStatement.add(stt);

    }

    void withdraw(Float amount, Date fecha){
        Statement stt = new Statement();
        stt.setFecha(fecha);
        stt.setMonto(Float.valueOf(0));
        stt.setRetiro(amount);
        stt.setSaldo(lastBalance - amount);
        this.lastBalance = lastBalance - amount ;
        lstStatement.add(stt);
    }

    void printStatements() {
    	System.out.format("%5s %14s %7s %10s", "Date", "Credit", "Debit", "Balance");   
    	System.out.println();  
        lstStatement.stream().forEach(statement ->{
        	System.out.format("%5s %14s %7s %10s", statement.getFecha(), statement.getRetiro(), statement.getMonto(), statement.getSaldo());  
        	System.out.println();  
        });
    }
    
    void printStatements(boolean onlyDeposit, boolean onlyWithdraw) {
    	System.out.format("%5s %14s %7s %10s", "Date", "Credit", "Debit", "Balance"); 
    	System.out.println();  
        if(onlyDeposit) {
        	lstStatement.stream().forEach(statement ->{
        		if(statement.getMonto() != 0) {
                	System.out.format("%5s %14s %7s %10s", statement.getFecha(), statement.getRetiro(), statement.getMonto(), statement.getSaldo());         		
                	System.out.println();  
        		}
            });
        }
        if(onlyWithdraw) {
        	lstStatement.stream().forEach(statement ->{
        		if(statement.getRetiro() != 0) {
                	System.out.format("%5s %14s %7s %10s", statement.getFecha(), statement.getRetiro(), statement.getMonto(), statement.getSaldo());        		
                	System.out.println();  
        		}
            });
        }
        
    }

}
