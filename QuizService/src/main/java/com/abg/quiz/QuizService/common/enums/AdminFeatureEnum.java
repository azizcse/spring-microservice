package com.abg.quiz.QuizService.common.enums;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/30/2023
 */
public enum AdminFeatureEnum {
    ADMIN_USER_LIST(2, "Admin User List"),
    FETCH_ACTIVITY_TYPE(3, "Fetch Activity Type"),
    ACTIVITY_LOG(4, "Activity Log"),
    ADD_ADMIN_USER(5,"Add Admin User"),
    EDIT_ADMIN_USER(6,"Edit Admin User"),
    FETCH_ADMIN_USER(7, "Fetch Admin User"),
    DELETE_ADMIN_USER(8,"Delete Admin User"),
    CHANGE_PASSWORD(9,"Change Password"),
    REQUEST_PASSWORD_RESET(10,"Request Password Reset");
    private long code;
    private String name;

    private AdminFeatureEnum(long code, String name) {
        this.code = code;
        this.name = name;
    }

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}