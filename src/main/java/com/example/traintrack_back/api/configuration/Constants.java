package com.example.traintrack_back.api.configuration;

public final class Constants {

    private Constants() {
    }

    public static final class Authority {

        public static final String ADMINISTRATOR = "hasAuthority('ADMINISTRATOR')";
        public static final String NORMAL = "hasAuthority('NORMAL')";

        private Authority() {
        }
    }

    public static final class Api {
        
        public static final String USERS = "/users";

        private Api() {
        }
    }
}

