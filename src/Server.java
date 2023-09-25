import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.io.PrintStream;

public class Server extends EquationImpl{
    public Server () {}
    public static void main(String[] args) {
        try{
            EquationImpl obj = new EquationImpl();

            Equation stub = (Equation) UnicastRemoteObject.exportObject(obj,0);
            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Equation", stub);



            System.err.println("Server ready");
        }catch (Exception e){
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

    }
}