package org.jjinppang.jjinppang.common;

public class NotFoundException extends RuntimeException {
    public static final String USER_NOT_FOUND = "존재하지 않는 회원입니다.";
    public static final String AUTH_NOT_FOUND = "존재하지 않는 토큰입니다.";
    public static final String CATEGORY_NOT_FOUND = "존재하지 않는 분류입니다.";
    public static final String FILE_NOT_FOUND = "존재하지 않는 파일입니다.";
    public NotFoundException(String message) {
        super(message);
    }
}
