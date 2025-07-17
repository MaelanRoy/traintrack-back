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
        public static final String EXERCISE = "/exercises";
        public static final String EXERCISE_ZONE = "/exercise-zones";
        public static final String EXERCISE_IMAGE = "/exercise-images";
        public static final String PROGRAM = "/programs";
        public static final String CATEGORY = "/categories";


        private Api() {
        }
    }
}

