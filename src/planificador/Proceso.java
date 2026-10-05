package planificador;

public class Proceso {
    //ATRIBUTOS
    private String nombre;
    private int llegada;               // en el momento que entra
    private int rafaga;                // cuanto tiempo necesita la CPU en total
    private int tiempoRestante;       // tiempo para terminar
    private EstadoProceso estado;     // estado en el que se encuentra

    //VARIABLES (iniciar y terminar)
    public int inicioCPU;
    public int finCPU;

    //CONSTRUCTOR PARA UN PROCESO NUEVO
    public Proceso(String nombre, int llegada, int rafaga){
        this.nombre = nombre;
        this.llegada = llegada;
        this.rafaga = rafaga;
        this.tiempoRestante = rafaga;
        this.estado = EstadoProceso.NUEVO;     // lo iniciamos siempre como nuevo
    }

    //VARIBLAES (para calcular)
    //(retorno = fin - llegada)
    public int retorno = finCPU - inicioCPU;
    //(espera = fin - llegada)
    public int espera = retorno - rafaga;
    //(respuesta = inicio -  llegada)
    public int respuesta = inicioCPU - llegada;
}
