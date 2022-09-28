package helpers;

import client.RestAssuredClient;
import config.APIConstants;
import io.restassured.response.Response;
import models.request.CreatePetRequest;
import models.response.CreatePetResponse;


public class PetStoreHelper extends RestAssuredClient {

    public PetStoreHelper() {
        super(APIConstants.PetStore.BASE_URL);
    }

    public CreatePetResponse createPetResponse(Integer id, String name, String status) {
        CreatePetRequest.Category category = CreatePetRequest.Category
                .builder()
                .build();
        CreatePetRequest.Tag tag = CreatePetRequest.Tag
                .builder()
                .build();
        CreatePetRequest createPetRequest = CreatePetRequest
                .newBuilder()
                .withId(id)
                .withCategory(category)
                .withName(name)
                .addTags(tag)
                .withStatus(status)
                .build();
        Response response = post("pet", createPetRequest);
        return response
                .body()
                .as(CreatePetResponse.class);
    }

    /**
     * Method to create pet where only id, name and status are filled with data. category ang tag have default value 0 and default names ("categoryName", "tagName").
     *
     * @param id
     * @param name
     * @param status
     * @return
     */
    public Response createPet(Integer id, String name, String status) {
        CreatePetRequest.Category category = CreatePetRequest.Category
                .builder()
                .build();
        CreatePetRequest.Tag tag = CreatePetRequest.Tag
                .builder()
                .build();
        CreatePetRequest createPetRequest = CreatePetRequest
                .newBuilder()
                .withId(id)
                .withCategory(category)
                .withName(name)
                .addTags(tag)
                .withStatus(status)
                .build();
        return post("pet", createPetRequest);
    }

    public Response getPet(int id) {
        return get("pet/" + id);
    }

    public Response deletePet(int id) {
        return delete("pet/" + id);
    }
}
