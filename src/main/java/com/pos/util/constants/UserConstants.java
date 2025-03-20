package com.pos.util.constants;

public class UserConstants {
    private UserConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static final class ROLE{
        public static final String CASHIER = "cashier";
        public static final String ADMIN = "admin";
        public static final String STOCK_MANAGER = "stock_manager";
        public static final String USER = "user";
    }
}
