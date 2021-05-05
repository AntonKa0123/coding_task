package http;

import properties.PropertiesLoader;

public final class EndPoints {
    public static final String users = PropertiesLoader.getProperties().getProperty("api.users");
    public static final String posts = PropertiesLoader.getProperties().getProperty("api.posts");
    public static final String comments = PropertiesLoader.getProperties().getProperty("api.comments");
}
