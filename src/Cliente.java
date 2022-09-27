public class Cliente {

    private String tipoDocumento;
    private String numDocumento;
    private String nombre;
    private String apellido;
    private String numTelefono;
    private String statusCrediticio;

    public Cliente(String tipoDocumento, String numDocumento, String nombre, String apellido, String numTelefono, String statusCrediticio) {
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numTelefono = numTelefono;
        this.statusCrediticio = statusCrediticio;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getStatusCrediticio() {
        return statusCrediticio;
    }

    public void setStatusCrediticio(String statusCrediticio) {
        this.statusCrediticio = statusCrediticio;
    }

    public void imprimir(){
        System.out.println("\n*** Cliente ***");
        System.out.println("Tipo de documento: " + tipoDocumento);
        System.out.println("Numero de documento: " + numDocumento);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Numero de telefono: " + numTelefono);
        System.out.println("Status crediticio: " + statusCrediticio + "\n");
    }

}
