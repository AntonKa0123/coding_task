package http;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Comment;
import models.Post;
import models.User;
import org.apache.http.HttpStatus;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class HttpHelper {
    static java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(HttpHelper.class.toString());

    public static User[] getUsersByUsername(Pair<String, String> param) {
        Response response = doGetRequest(EndPoints.users, param);
        Gson gson = new Gson();
        User[] users = gson.fromJson(response.asString(), User[].class);
        logger.info("USERS: " + Arrays.toString(users));
        return users;
    }

    public static Post[] getPostsByUserId(Pair<String, String> userId) {
        Response response = doGetRequest(EndPoints.posts, userId);
        Gson gson = new Gson();
        Post[] posts = gson.fromJson(response.asString(), Post[].class);
        logger.info("POSTS: " + Arrays.toString(posts));
        return posts;
    }

    public static Comment[] getCommentsForPost(Pair<String, String> param) {
        Response response = doGetRequest(EndPoints.comments, param);
        Gson gson = new Gson();
        Comment[] comments = gson.fromJson(response.asString(), Comment[].class);
        logger.info("COMMENTS: " + Arrays.toString(comments));
        return comments;
    }

    public static Post[] getPostsByUserName(Pair<String, String> username){
        User[] users = getUsersByUsername(username);
        return getPostsByUserId(new Pair<>("userId", users[0].getId()));
    }

    public static Response doGetRequest(String endpoint, Pair<String, String> param) {
        return given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).param(param.getKey(), param.getValue()).
                when().get(endpoint).
                then().assertThat()
                .statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON).extract().response();
    }
}