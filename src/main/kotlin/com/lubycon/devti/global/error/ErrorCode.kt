package com.lubycon.devti.global.error

enum class ErrorCode(
     val status: Int,
     val code: String,
     val message: String
) {
    // Common
    INVALID_INPUT_VALUE(400, "COM001", "Invalid input value"),
    INVALID_INPUT_FORMAT(400, "COM002", "Can not read request json"),
    METHOD_NOT_ALLOWED(405, "COM003", "Method not allowed"),
    MEDIA_TYPE_NOT_SUPPORTED(405, "COM004", "Media type not supported"),
    ENTITY_NOT_FOUND(404, "COM005", "Entity not found"),
    RESOURCE_NOT_FOUND(400, "COM006", "Resource not found"),
    INTERNAL_SERVER_ERROR(500, "COM007", "Server error"),
    INVALID_TYPE_VALUE(400, "COM008", "Invalid type value"),
    REQUEST_WITH_DUPLICATED_DATA(400, "COM009", "Request body contains duplicated data"),

    // Survey
    EMAIL_DUPLICATION(400, "S001", "Email is Duplication"),
    PHONE_DUPLICATION(400, "S002", "Phone is Duplication"),

    // Preset
    PRESET_NOT_FOUND(400, "P001", "Preset not found");
}