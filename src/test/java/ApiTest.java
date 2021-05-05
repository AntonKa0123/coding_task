import http.HttpDAO;
import http.HttpParameters;
import io.qameta.allure.*;
import models.Comment;
import models.Post;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiTest {

    @Epic("Mobiquity code challenge")
    @Feature("API testing Flow")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Only one user should be found for username Delphine")
    @Test
    public void checkNumberOfUsersPerUserName() {
        User[] users = HttpDAO.getUsersByUsername(HttpParameters.USER_NAME, "Delphine");
        Assertions.assertEquals(users.length, 1);
    }

    @Epic("Mobiquity code challenge")
    @Feature("API testing Flow")
    @Severity(SeverityLevel.BLOCKER)
    @Story("At least one post should be found for username Delphine")
    @Test
    public void checkNumberOfPostsPerUser() {
        User[] users = HttpDAO.getUsersByUsername(HttpParameters.USER_NAME, "Delphine");
        Post[] posts = HttpDAO.getPostsByUserId(HttpParameters.USER_ID, users[0].getId());
        Assertions.assertTrue(posts.length >= 1, "USER without posts");
    }

    @Epic("Mobiquity code challenge")
    @Feature("API testing Flow")
    @Severity(SeverityLevel.BLOCKER)
    @Story("At least one comment should be found per Post for username Delphine")
    @Test
    public void checkNumberOfCommentsPerPost() {
        User[] users = HttpDAO.getUsersByUsername(HttpParameters.USER_NAME, "Delphine");
        Post[] posts = HttpDAO.getPostsByUserId(HttpParameters.USER_ID, users[0].getId());
        List<String> postsWithoutComments = new ArrayList<>(posts.length);
        for (Post post : posts) {
            Comment[] comments = HttpDAO.getCommentsByPostId(HttpParameters.POST_ID, post.getId());
            if (comments.length == 0){
                postsWithoutComments.add(post.getId());
            }
        }
        Assertions.assertEquals(0, postsWithoutComments.size(), "Posts without comments");
    }

    @Epic("Mobiquity code challenge")
    @Feature("API testing Flow")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Email format should be followed by RFC 5322")
    @Test
    public void validateEmailFormat(){
        final Pattern valid_email_address_regex = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

        Post[] posts = HttpDAO.getPostsByUserName(HttpParameters.USER_NAME, "Delphine");
        Map<String, String> commentsMap = new HashMap<>();
        for (Post post : posts) {
            Comment[] comments = HttpDAO.getCommentsByPostId(HttpParameters.POST_ID, post.getId());
            for (Comment comment : comments) {
                Matcher matcher = valid_email_address_regex.matcher(comment.getEmail());
                if (!matcher.matches()){
                    commentsMap.put(comment.getId(), comment.getEmail());
                }
            }
        }
        Assertions.assertEquals(0, commentsMap.size(), String.format("Incorrect email format: %s", commentsMap));
    }
}
