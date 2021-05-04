package http;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class HttpClient {
    public static Response doGetRequest(String endpoint, HttpParameters key, String value) {
        HashMap<String, String> params = new HashMap<>();
        params.put(key.getParam(), value);
        return doGetRequest(endpoint, params, HttpStatus.SC_OK, ContentType.JSON);
    }

    private static Response doGetRequest(String endpoint, Map<String, String> params, int httpStatus, ContentType contentType) {
        return given().headers("Content-Type", contentType, "Accept", contentType).params(params).
                when().get(endpoint).
                then().assertThat()
                .statusCode(httpStatus).contentType(contentType).extract().response();
    }
}
