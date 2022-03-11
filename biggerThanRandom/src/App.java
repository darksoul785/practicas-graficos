

public class App {
    public static void main(String[] args) throws Exception {
        
        double randomA = Math.random()*10;
        double randomB = Math.random()*10;
        
        System.out.println("valor random de A = " + randomA);
        System.out.println("valor random de B = " + randomB);

        double max = Math.max(randomA, randomB);

        System.out.println("El valor maximo es = " + max);
      }
}
