package services.pet;

import helpers.PetStoreHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Test read option of a pet in a pet store")
public class GetPetHappyPathTest {

    PetStoreHelper petStoreHelper = new PetStoreHelper();
    String petName = "Dog";
    int petId = 2;
    String[] status = {"available", "pending", "sold"};

    @BeforeAll
    public void createTestData(){
        Response response = petStoreHelper.createPet(petId, petName, status[0]);
        assertEquals(200, response.getStatusCode());
        System.out.println(response.jsonPath().getInt("id"));
    }


    @Test
    @Order(1)
    @DisplayName("Get pet with id: 1.")
    public void getPetHappyPath() {
        Response response = petStoreHelper.getPet(petId);

        assertEquals(200, response.getStatusCode());

        assertEquals((int) petId, response
                .jsonPath()
                .getInt("id"));
        assertEquals(response
                .jsonPath()
                .getString("name"), petName);
        assertEquals(response
                .jsonPath()
                .getString("status"), status[0]);
    }

    @Test
    @Order(2)
    @DisplayName("Delete pet with id:1. ")
    public void deletePetHappyPath() {
        Response response = petStoreHelper.deletePet(petId);
        assertEquals(200, response.getStatusCode());
    }

}
