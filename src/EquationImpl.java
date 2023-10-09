import java.rmi.RemoteException;

public class EquationImpl implements Equation{
    @Override
    public String doEquation(int a, int b, int c) throws RemoteException {
        System.out.println("Your equation is " + a + "x^2 + " + b + "x + " + c + " = 0");
        double x1 = 0, x2 = 0;
        if (b == 0 && c == 0){
            x1 = 0;
        }
        if (b == 0 && c != 0){
            if (-c / a < 0){
                x1 = 0;
            } else {
                x1 = Math.sqrt((double)((-c / a)));
                x2 = -x1;
            }
        }
        if (c == 0 && b != 0){
            x2 = (double) -b / a;
        }
        if (a == 0){
            x2 = (double) -c / b;
        }
        if (a != 0 && b != 0 && c != 0){
            int D = b * b - (4 * a * c);
            if (D < 0){
                x1 = 0;
            }
            if (D == 0) {
                x1 = (double) -b / (2 * a);
            }
            if (D > 0) {
                x1 = (-b - Math.sqrt(D)) / (2 * a);
                x2 = (-b +  Math.sqrt(D)) / (2 * a);
            }
        }
        String resp = "x1: " + x1 + ", x2: " + x2 + "\n";
        System.out.println(x1 + "    " + x2);
        return resp;
    }
}
