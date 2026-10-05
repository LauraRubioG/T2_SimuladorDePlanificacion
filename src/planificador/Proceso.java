package planificador;

public class Proceso {
    //ATRIBUTOS
    private final String nombre;
    private final int llegada;               // en el momento que entra
    private final int rafaga;                // cuanto tiempo necesita la CPU en total
    private int tiempoRestante;       // tiempo para terminar
    private EstadoProceso estado;     // estado en el que se encuentra

    //VARIABLES (iniciar y terminar) guarda el tiempo
    // al valer -1 aun no ha entrado en la CPU
    public int inicioCPU;
    public int finCPU;

    //CONSTRUCTOR PARA UN PROCESO NUEVO
    public Proceso(String nombre, int llegada, int rafaga){
        this.nombre = nombre;
        this.llegada = llegada;
        this.rafaga = rafaga;
        this.tiempoRestante = rafaga;    //al iniciar un nuevo proceso el tiempoRestante debe empezar siendo igual que la rafaga
        this.estado = EstadoProceso.NUEVO;     // lo iniciamos siempre como nuevo
        // al valer -1 aun no ha entrado en la CPU
        this.inicioCPU = -1;
        this.finCPU = -1;
    }

    //CONSTRUCTOR PARA UN PROCESO DISTINTO
    public Proceso(Proceso distinto){
        this.nombre = distinto.nombre;
        this.llegada = distinto.llegada;
        this.rafaga = distinto.rafaga;
        this.tiempoRestante = distinto.rafaga;
        this.estado = EstadoProceso.NUEVO;    // vuelver a estra desde el principio como nuevo
        this.inicioCPU = -1;
        this.finCPU = -1;
    }

    // ---------GETTERS Y SETTERS -----------------
    //devuelce el estado actual del proceso
    public EstadoProceso getEstado(){
        return estado;
    }
    // devuelve en que minuto termina
    public int getFinCPU(){
        return finCPU;
    }
    //devuelve el nombre
    public String getNombre(){
        return nombre;
    }
    //devuelve la llegada
    public int getLlegada(){
        return llegada;
    }
    //devuelve la rafaga
    public int getRafaga(){
        return rafaga;
    }
    //devuelve el tiemporestante
    public int getTiempoRestante(){
        return tiempoRestante;
    }

    //nos permite cambiar el estado
    public void setEstado(EstadoProceso estado){
        this.estado = estado;
    }


    //-----METODOS PARA CALCULAR LA MÉTRICA----
    //para averiguar la métrica vamos a usar funciones como los getter en vez de variables
    //sueltas como tal

    //Metodo para Retorno = instante de fin del proceso - instante de llegada
    public int getRetorno(){
        return finCPU - llegada;
    }
    //Metodo para Espera = tiempo de retorno - ráfaga
    public int getEspera(){
        return getRetorno() - rafaga;
    }
    //Metodo para Respusta = instante primero en la CPU - llegada
    public int getRespuesta(){
        return inicioCPU - llegada;
    }

}
