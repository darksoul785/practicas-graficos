import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        String str = Arrays.toString(args).replace("[", "").replace("]", "");

        for(int i = 0; i < str.length();i++){
           for(int j = i + 1; j<=str.length();j++){
               System.out.println(str.substring(i,j));
           }
       }
    }
}
