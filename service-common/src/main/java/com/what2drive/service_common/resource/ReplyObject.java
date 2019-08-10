package com.what2drive.service_common.resource;

import java.io.Serializable;
import java.util.HashMap;

/**
 * JSON REST response wrapper
 *
 * This object will indicate whether response was successful or not as well as pass the results of the response
 *
 * @author Leo Ertuna
 * @since 24.03.2018 18:38
 */
public class ReplyObject implements Serializable {
    private boolean success;
    private String errorMessage;
    private HashMap<String, Object> results;

    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    private ReplyObject(boolean success, String errorMessage, HashMap<String, Object> results) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.results = results;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Modifiers
    //------------------------------------------------------------------------------------------------------------------
    private void addResult(String name, Object result) {
        this.results.put(name, result);
    }
    //------------------------------------------------------------------------------------------------------------------



    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HashMap<String, Object> getResults() {
        return results;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Factory methods
    //------------------------------------------------------------------------------------------------------------------
    private static ReplyObject success() {
        return new ReplyObject(true, "",  new HashMap<>());
    }

    private static ReplyObject success(String name, Object result) {
        ReplyObject replyObject = success();
        replyObject.addResult(name, result);
        return replyObject;
    }

    private static ReplyObject error() {
        return new ReplyObject(false, "", new HashMap<>());
    }

    private static ReplyObject error(String errorMessage){
        return new ReplyObject(false, errorMessage, new HashMap<>());
    }
    //------------------------------------------------------------------------------------------------------------------



    // Builder
    //------------------------------------------------------------------------------------------------------------------
    public static class Builder {
        private ReplyObject replyObject;

        private Builder(ReplyObject replyObject) {
            this.replyObject = replyObject;
        }

        public Builder addResult(String name, Object result) {
            if (replyObject.isSuccess()) {
                replyObject.addResult(name, result);
                return this;
            }

            else {
                throw new IllegalStateException("Reply object should have no results: replyObject=" + replyObject);
            }
        }

        public ReplyObject build() {
            return replyObject;
        }

        public static Builder success() {
            return new Builder(ReplyObject.success());
        }

        public static Builder success(String name, Object result) {
            return new Builder(ReplyObject.success(name, result));
        }

        public static Builder error() {
            return new Builder(ReplyObject.error());
        }

        public static Builder error(String errorMessage) {
            return new Builder(ReplyObject.error(errorMessage));
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}