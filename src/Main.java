import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    static List<Cliente> listaClientes = new ArrayList<>();
    static List<Credito> listaCreditos = new ArrayList<>();
    static List<Cuota> listaCuotas = new ArrayList<>();
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("*****SISTEMA DE PRESTAMOS*****");
        System.out.println("1. Registrar Cliente");
        System.out.println("2. Mostrar Clientes");
        System.out.println("3. Registrar Credito");
        System.out.println("4. Listar Creditos");
        System.out.println("5. Evaluar Credito");
        System.out.println("6. Buscar cuotas de cliente");
        System.out.println("Seleccione una opcion: ");
        int op = Integer.parseInt(leer.nextLine());

        if (op == 1) {
            registrarCliente();
        }
        if (op == 2) {
            mostrarClientes();
        }
        if (op == 3) {
            registrarCredito();
        }
        if (op == 4) {
            mostrarCreditos();
        }
        if (op == 5) {
            editarCreditos();
        }
        if (op == 6) {
            buscar_cuotas();
        } else {
            menu();
        }
    }

    public static void registrarCliente() {
        System.out.println("***** REGISTRAR CLIENTE *****");
        System.out.println("Ingrese el tipo de documento: DNI o CARNET");
        String tipoDoc = leer.nextLine();
        System.out.println("Ingrese el numero de documento del cliente:");
        String numDoc = leer.nextLine();
        System.out.println("Coloque el nombre del cliente:");
        String nombre = leer.nextLine();
        System.out.println("Coloque el apellido del cliente:");
        String apellido = leer.nextLine();
        System.out.println("Coloque el telefono del cliente:");
        String telefono = leer.nextLine();
        System.out.println("Coloque el estatus crediticio del cliente: BUENO, REGULAR, MALO");
        String status = leer.nextLine();
        Cliente cliente = new Cliente(tipoDoc, numDoc, nombre, apellido, telefono, status);
        listaClientes.add(cliente);
        System.out.println("SE REGISTRO EL CLIENTE");
        cliente.imprimir();
        menu();
    }

    public static void registrarCredito() {
        System.out.println("***** REGISTRAR CREDITO *****");
        System.out.println("Ingrese el tipo de documento del Cliente");
        String tipoDoc = leer.nextLine();
        System.out.println("Ingrese el numero de documento del cliente:");
        String numDoc = leer.nextLine();
        Cliente cliente = listaClientes.stream().filter(c -> Objects.equals(tipoDoc, c.getTipoDocumento())
                && Objects.equals(numDoc, c.getNumDocumento())).findFirst().orElse(null);
        System.out.println("Nombre del cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Ingrese el monto:");
        String monto = leer.nextLine();
        System.out.println("Ingrese el numero de cuotas:");
        String cuotas = leer.nextLine();
        Credito credito = new Credito(Integer.valueOf(cuotas), Double.valueOf(monto), "CREADO", cliente);
        listaCreditos.add(credito);
        System.out.println("SE REGISTRO EL CREDITO");
        credito.imprimir();
        menu();
    }

    public static void mostrarClientes() {
        System.out.println("\n");
        System.out.println("***** LISTA DE CLIENTES *****");
        listaClientes.forEach(Cliente::imprimir);
        menu();
    }

    public static void mostrarCreditos() {
        System.out.println("\n");
        System.out.println("***** LISTA DE CREDITOS *****");
        listaCreditos.forEach(Credito::imprimir);
        menu();
    }

    public static void editarCreditos() {
        System.out.println("Ingrese el numero de Dni del cliente  para mostrar Creditos disponibles:");
        String dni = leer.nextLine();
        Credito credit = listaCreditos.stream().filter(c ->
                Objects.equals(dni, c.getCliente().getNumDocumento())).findFirst().orElse(null);
        String nombreapellid = credit.getCliente().getNombre() + " " + credit.getCliente().getApellido();

        System.out.println("Nombre del cliente: " + nombreapellid +
                "\n " + "Estado de credito :" + credit.getEstado() + " \n" + " Observaciones "
                + credit.getObservacion() + " \n" + "Monto total " + credit.getMontoTotal());
        int cuotas = credit.getNumCuotas();
        Double monttl = credit.getMontoTotal();
        Double monto = credit.getMontoTotal() / cuotas;
        Double montoinc = credit.getMontoInicial() / cuotas;
        Double interes2 = credit.getMontoTotal() - credit.getMontoInicial();
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");


        System.out.println("Desea APROBAR, DESAPROBAR u OBSERVAR la solicitud?");
        String aprobacion = leer.nextLine();


        if (aprobacion.equals("APROBAR")) {
            credit.setEstado("APROBADO");
            for (int i = 0; i <= cuotas; i++) {
                calendar.add(Calendar.MONTH, +1);
                Date dateObj = calendar.getTime();

                Cuota cuuota = new Cuota(dni, montoinc, dateObj, monto - montoinc, monto);
                listaCuotas.add(cuuota);
            }
        } else if (aprobacion.equals("OBSERVAR")){
            credit.setEstado("OBSERVADO");
            System.out.println("Agrege una observacion :");
            String obs = leer.nextLine();
            credit.setObservacion(obs);
        } else {
            credit.setEstado("DESAPROBADO");
            System.out.println("Agrege una observacion :");
            String obs = leer.nextLine();
            credit.setObservacion(obs);
        }

        //   listaCuotas.forEach(Cuota::imprimir);
        menu();
    }

    public static void buscar_cuotas() {

        System.out.println("Ingrese nmro de documento");
        String nmr_documento = leer.nextLine();
        String reporte = "-------Todos las cuotas del cliente-----";
        Integer id = 0;
        for (Cuota item : listaCuotas) {

            if (nmr_documento.equals(item.getDni())) {
                id++;
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String strDate = dateFormat.format(item.getFechaPago());

                String montito = String.format("%.2f", item.getMonto());
                String montopag = String.format("%.2f", item.getMontoPagar());
                reporte += ("\n\nNRO : " + id);
                reporte += ("\nDNI : " + item.getDni());
                reporte += ("\nMonto: " + montito);
                reporte += ("\nFecha : " + strDate);
                reporte += ("\nInteres: " + item.getInteres());
                reporte += ("\nMonto a  Pagar: " + montopag + "\n");
            }
        }
        System.out.println(reporte);
        menu();
    }
}