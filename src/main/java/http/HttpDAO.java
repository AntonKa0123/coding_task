package http;

import com.google.gson.Gson;
import io.restassured.response.Response;
import models.Comment;
import models.Post;
import models.User;

import java.util.Arrays;

public class HttpDAO {
    static java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(HttpDAO.class.toString());
    private static final Gson gson = new Gson();

    public static User[] getUsersByUsername(HttpParameters key, String value) {
        Response response = HttpClient.doGetRequest(EndPoints.users, key, value);
        User[] users = gson.fromJson(response.asString(), User[].class);
        logger.info("USERS: " + Arrays.toString(users));
        return users;
    }

    public static Post[] getPostsByUserId(HttpParameters key, String value) {
        Response response = HttpClient.doGetRequest(EndPoints.posts, key, value);
        Post[] posts = gson.fromJson(response.asString(), Post[].class);
        logger.info("POSTS: " + Arrays.toString(posts));
        return posts;
    }

    public static Comment[] getCommentsByPostId(HttpParameters key, String value) {
        Response response = HttpClient.doGetRequest(EndPoints.comments, key, value);
        Comment[] comments = gson.fromJson(response.asString(), Comment[].class);
        logger.info("COMMENTS: " + Arrays.toString(comments));
        return comments;
    }

    public static Post[] getPostsByUserName(HttpParameters key, String value){
        User[] users = getUsersByUsername(key, value);
        return getPostsByUserId(HttpParameters.USER_ID, users[0].getId());
    }
}