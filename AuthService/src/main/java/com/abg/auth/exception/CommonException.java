package com.abg.auth.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.StatusType;

import static org.zalando.problem.Status.FORBIDDEN;
import static org.zalando.problem.Status.UNAUTHORIZED;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 12/14/2023
 */
public class CommonException extends AbstractThrowableProblem {
    private CommonException(StatusType status, String detail) {
        super(null, null, status, detail, null, null, null);
    }

    public static CommonException unauthorized() {
        return new CommonException(UNAUTHORIZED, "Unauthorised or Bad Credentials");
    }

    public static CommonException forbidden() {
        return new CommonException(FORBIDDEN, "Forbidden");
    }

    public static CommonException headerError() {
        return new CommonException(FORBIDDEN, "Missing Header");
    }
}
