import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(args));
        if (args[0].equals("-hex")) {
            System.out.println("selecciono hex.");
            String ip = "";
            for (int i = 0; i < args[1].length(); i = i + 2) {
                ip = ip + Integer.valueOf(args[1].substring(i, i + 2), 16) + ".";
            }           
            System.out.println(ip);     
        }
        if (args[0].equals("-ip")) {
            System.out.println("selecciono ip.");
            String index = args[1];
            String [] array =new String[] {index};
            String [] ip = array[0].split("\\.");
            for(int i = 0;i<ip.length;i++){
                int intIp = Integer.parseInt(ip[i]);
                if(Integer.toHexString(intIp).length()<2){
                    System.out.print("0");
                }
                System.out.print(Integer.toHexString(intIp));
            }
            System.out.println();
        }
    }
}
