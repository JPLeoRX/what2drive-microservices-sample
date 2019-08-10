package com.what2drive.service_common.resource;

public interface Resource {
    /**
     * Get default error reply object
     * @return
     */
    default ReplyObject getDefaultErrorReplyObject(Exception e) {
        return ReplyObject.Builder.error("Exception: " + e.getMessage()).build();
    }
}