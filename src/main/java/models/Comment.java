package models;

import lombok.Data;

@Data
public class Comment {
    String postId, id, name, email, body;
}