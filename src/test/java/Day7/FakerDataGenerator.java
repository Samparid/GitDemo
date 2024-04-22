package Day7;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {

    @Test
    public void testGenerateDummyData() {

        Faker faker = new Faker();
        String fullname = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        String username = faker.name().username();
        String password = faker.internet().password();
        String phoneNumber = faker.phoneNumber().cellPhone();
        String emailAddress = faker.internet().emailAddress();
        System.out.println(fullname);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(username);
        System.out.println(password);
        System.out.println(phoneNumber);
        System.out.println(emailAddress);


    }
}
