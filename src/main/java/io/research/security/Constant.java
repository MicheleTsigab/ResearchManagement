package io.research.security;

public class Constant {

    public static final String ENCODER_ID = "bcrypt";
    public static final String API_URL_PREFIX = "/api/**";
    public static final String H2_URL_PREFIX = "/h2-console/**";
    public static final String SIGNUP_URL = "/api/user/signup";
    public static final String TOKEN_URL = "/api/user/auth/token";
    public static final String REFRESH_URL = "/api/user/auth/token/refresh";
    public static final String PRODUCTS_URL = "/api/user/calls";
    public static final String AUTHORIZATION =  "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SECRET_KEY = "SECRET_KEY";
    public static final long EXPIRATION_TIME = 900_000;
    public static final String ROLE_CLAIM = "roles";
    public static final String AUTHORITY_PREFIX = "ROLE_";
}
