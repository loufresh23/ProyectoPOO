import java.security.PublicKey;
import java.util.Date;
import java.util.List;

public class Credito {

    private Integer numCuotas;
    private Double montoInicial;
    private Double intereses;
    private Double montoTotal;
    private Date fecInicio;
    private Date fecFin;
    private String estado;
    private String observacion = "Ninguna";
    private List<Cuota> cuotas;
    private Cliente cliente;

    public Credito(Integer numCuotas, Double montoInicial, String estado, Cliente cliente) {
        this.numCuotas = numCuotas;
        this.montoInicial = montoInicial;
        this.intereses = calcularInteres();
        this.montoTotal = montoInicial + intereses;
        this.fecInicio = new Date();
        this.estado = estado;
        this.cliente = cliente;
    }

    public Integer getNumCuotas() {
        return numCuotas;
    }

    public void setNumCuotas(Integer numCuotas) {
        this.numCuotas = numCuotas;
    }

    public Double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(Double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public Double getIntereses() {
        return intereses;
    }

    public void setIntereses(Double intereses) {
        this.intereses = intereses;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void imprimir(){
        System.out.println("\n*** Credito ***");
        System.out.println("Nombre Cliente: " + cliente.getNombre() + " " +cliente.getApellido());
        System.out.println("Monto Inicial: " + montoInicial);
        System.out.println("Numero de cuotas: " + numCuotas);
        System.out.println("Total de interes: " + intereses);
        System.out.println("Monto total: " + montoTotal);
        System.out.println("Estado: " + estado);
        System.out.println("Observacion: " + observacion + "\n");
    }

    private Double calcularInteres(){
        return montoInicial * numCuotas * 0.05;
    }




}
