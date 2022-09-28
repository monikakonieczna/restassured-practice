package utils;

public enum Status {
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NO_CONTENT(204),
    INVALID_ID_SUPPLIED(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    PET_NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    INTERNAL_SERVER_ERROR(500);

    public int getCode() {
        return code;
    }

    private final int code;

    Status(int code) {
        this.code = code;
    }
}
