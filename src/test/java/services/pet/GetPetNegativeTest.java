package services.pet;

import helpers.PetStoreHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetPetNegativeTest {

    PetStoreHelper petStoreHelper = new PetStoreHelper();
    int petId = -5;
    double petIdDouble = 1.4;

    @Test
    @DisplayName("Get pet with invalid id: negative number")
    public void getPetHappyPath() {
        Response response = petStoreHelper.getPet(petId);

        assertEquals(Status.INVALID_ID_SUPPLIED.getCode(), response.getStatusCode());

        assertEquals("error", response
                .jsonPath()
                .getInt("type"));
        assertEquals("Pet not found", response
                .jsonPath()
                .getString("message"));
    }
}
