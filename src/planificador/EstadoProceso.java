package planificador;

public enum EstadoProceso {
    NUEVO, // acaba de llegar
    LISTO, // está en la cola esprando a que se le atienda
    EJECUCION, // en este momento lo está preparando en la CPU
    // BLOQUEADO, en nuestro caso no hace falta ya que son tareas nocturnas y no requiere de la intervención del usuario
    TERMINADO // termina y se lo lleva al cliente
}
