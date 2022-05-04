
import java.util.Date;

public class Statement {

    private Date fecha;
    private Float monto;
    private Float saldo;
    private Float retiro;

    public Statement(){
        fecha = new Date();
        monto =Float.valueOf(0);
        saldo = Float.valueOf(0);
        retiro =  Float.valueOf(0);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Float getRetiro() {
        return retiro;
    }

    public void setRetiro(Float retiro) {
        this.retiro = retiro;
    }
}
