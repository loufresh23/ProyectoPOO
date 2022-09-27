import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cuota {
    private String dni;
    private Double monto;
    private Date fechaPago;
    private Double interes;
    private Double montoPagar;

    public Cuota(String dni, Double monto, Date fechaPago, Double interes, Double montoPagar) {
        this.dni = dni;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.interes = interes;
        this.montoPagar = montoPagar;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Double getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(Double montoPagar) {
        this.montoPagar = montoPagar;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void imprimir(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = dateFormat.format( fechaPago);


        System.out.println("\n*** Cuotas ***");
        System.out.println("DNI : " + dni);
        System.out.println("Monto: " +monto);
        System.out.println("Fecha : " + strDate);
        System.out.println("Interes: " + interes);
        System.out.println("Monto a  Pagar: " + montoPagar + "\n");
    }
}
