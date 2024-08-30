package Cliente;

public class Excepcion extends Exception{
public Excepcion(String mensaje){
super("ERROR: "+mensaje+". Presione Enter para continuar");
}
}
