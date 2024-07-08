package clickup.api.steps;

import clickup.api.steps.BaseSteps;
import clickup.api.rest.TagsRestClient;
import clickup.api.utils.ResourceUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class TagsSteps extends BaseSteps {
    @When("User send GET tags of {}")
        public void getTags(final String id) {
        if (id.equals("valid_space")){
            final Response getTagsResponse = tagsRestClient.getTags("90152681230");
            sharedTestData.setResponse(getTagsResponse);
        } else if (id.equals("not_valid_space")){
            final Response getTagsResponse = tagsRestClient.getTags("11111111111");
            sharedTestData.setResponse(getTagsResponse);
        } else {
            System.out.println("Invalid test name provided");
            return;
        }
    }

    @And("Response contains {}")
        public void responseBodyShouldContains(final String bodyPart) {
        String responseBody = sharedTestData.getResponse().getBody().asString();
        assertThat(responseBody, containsString(bodyPart));
    }

    @When("User send POST to create tag with {}")
    public void createTag(final String bodyPath) {
        if (bodyPath.equals("valid_body")) {
            String source = "data/folders/create_tag.json";
            JSONObject requestBody = ResourceUtils.readJson(source);
            final Response createTagResponse = tagsRestClient.createTag(requestBody);
            sharedTestData.setResponse(createTagResponse);
        } else if (bodyPath.equals("not_valid_body")) {
            String source = "data/folders/create_folders.json";
            JSONObject requestBody = ResourceUtils.readJson(source);
            final Response createTagResponse = tagsRestClient.createTag(requestBody);
            sharedTestData.setResponse(createTagResponse);
        } else {
            System.out.println("Invalid test name provided");
            return;
        }
    }

    @When("User send DELETE to delete test_tag")
    public void deleteTag() {
            final Response deleteTagResponse = tagsRestClient.deleteTag();
            sharedTestData.setResponse(deleteTagResponse);
    }

    @And("Response does not contain {}")
    public void responseBodyShouldNotContain(final String bodyPart) {
        String responseBody = sharedTestData.getResponse().getBody().asString();
        assertThat(responseBody, not(containsString(bodyPart)));
    }
}