package org.sid.securityservice.sec.filters;

public class JWTUtil {
    public static final String SECRET="mySecret1234";
    public static final String AUTHORIZATION_HEADER="Authorization";
    public static final int EXPIRE_ACCESS_TOKEN=60000;
    public static final int EXPIRE_REFRESH_TOKEN=900000;
    public static final String AUTHORIZATION_PREFIX="Bearer ";
}
