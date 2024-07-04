package clickup.api.rest;

import clickup.api.utils.ResourceUtils;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class TagsRestClient extends BaseRestClient {

public TagsRestClient() {
    this.setUpRestAssured();
}

    public Response getTags(final String space_id) {
        return requestSpec.given()
               .get("/space/"+ space_id +"/tag/");
    }

    public Response createTag(JSONObject body) {
        return requestSpec.given()
                .body(body.toString())
                .post("/space/90152401675/tag/");
    }

    public Response deleteTag() {
        return requestSpec.given()
                .delete("/space/90152401675/tag/test_tag");
    }
}