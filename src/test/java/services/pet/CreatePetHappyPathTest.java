package services.pet;

import helpers.PetHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.PropertyManager;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test creation of a pet in a pet store")
public class CreatePetHappyPathTest {

    PetHelper petHelper = new PetHelper();
    PropertyManager propertyManager = new PropertyManager();

    Random random = new Random();
    Integer petId = random.nextInt(10);
    String petName = "Pet ";


    //------Property sample---------//
    String pet_Id = propertyManager.getProperty("properties/pet.properties","id");


    @DisplayName("Create pet with id within range of 1-10, petName equals Pet and all 3 available statuses.")
    @CsvSource({"available", "pending", "sold"})
    @ParameterizedTest
    public void createPetHappyPath(String status) {
        Response response = petHelper.createPet(petId, petName, status);

        assertEquals(200, response.getStatusCode());

        assertEquals((int) petId, response
                .jsonPath()
                .getInt("id"));
        assertEquals(response
                .jsonPath()
                .getString("name"), petName);
        assertEquals(response
                .jsonPath()
                .getString("status"), status);


    }
}
