package com.hbbo.boardback.common;

public interface ResponseCode {
    
    /* 
     * public static final String SUCCESS = "SU";
     * 인터페이스에서는 멤버 변수가 public static final 이기 때문에 생략 가능하다.
     * public abstract 가 멤버 메서드의 기본값이기 때문에 생략 가능하다.
     * (모든 메서드가 추상 메서드이기 때문임) 
    */

    // HTTP Status 200
    String SUCCESS = "SU";

    // HTTP Status 400
    String VALIDATION_FAILED = "VF";
    String DUPLICATE_EMAIL = "DE";
    String DUPLICATE_NICKNAME = "DN";
    String DUPLICATE_TEL_NUMBER = "DT";
    String NOT_EXISTED_USER = "NU";
    String NOT_EXISTED_BOARD = "NB";

    // HTTP Status 401
    String SIGN_IN_FAIL = "SF";
    String AUTHORIZATION_FAIL = "AF";

    // HTTP Status 403
    String NO_PERMISSION = "NP";

    // HTTP Status 500
    String DATABASE_ERROR = "DBE";
}
