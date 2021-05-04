package http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
public enum HttpParameters {
    USER_NAME("username"),
    USER_ID("userId"),
    POST_ID("postId");

    @Getter
    private final String param;
}
