import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Equation extends Remote {
    String doEquation (int a, int b, int c) throws RemoteException;
}
