import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client(){};

    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry(null);
            Equation stub = (Equation) registry.lookup("Equation");
            if (args.length != 3) {
                System.out.println("Usage: Client <a> <b> <c>");
                return;
            }
            // Получаем аргументы из командной строки и преобразуем их в целые числа
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);


            System.out.println("Your equation is " + a + "x^2 + " + b + "x + " + c + " = 0");
            String resp = stub.doEquation(a, b, c);
            System.out.println(resp);
        } catch (Exception e){
            System.err.println("Server exception" + e.toString());
            e.printStackTrace();
        }
    }
}
