package project2026.Models;

public class Session {
    
    private static String name;
    private static String role;
    private static Restaurant restaurant;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Session.name = name;
    }
    
    public static void setRole(String r) {
        role = r;
    }
    
    public static String getRole() {
        return role;
    }
    
    public static boolean isManager() {
        return "manager".equals(role);
    }
}
