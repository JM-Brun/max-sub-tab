import service.ResultService;

import java.util.Arrays;

public class Application {

    private Application() {
    }

    public static void main(String ... args) {


        ResultService resultService = new ResultService();

        // Display Result in the console
        System.out.println("===========================");
        System.out.println("Resultat : ");
        try {
            System.out.println(Arrays.toString(resultService.compute()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===========================");

    }
}
