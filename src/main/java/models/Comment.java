package models;

public class Comment {
    String postId, id, name, email, body;

    public String getId() {
        return id;
    }

    public String getPostId() {
        return postId;
    }

    public String getBody() {
        return body;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "postId='" + postId + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
