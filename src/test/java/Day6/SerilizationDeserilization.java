package Day6;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class SerilizationDeserilization {

    @Test
    public void convertPojo2Json() {

        // CREATED JAVA OBJECT USING POJO CLASS
        Pojo_PostRequest pojoPostRequest = new Pojo_PostRequest();
        pojoPostRequest.setJob("Samrat");
        pojoPostRequest.setJob("SDET");

        //CONVERT JAVA OBJECT -----> JSON OBJECT (SERILIZATION)



    }

}
