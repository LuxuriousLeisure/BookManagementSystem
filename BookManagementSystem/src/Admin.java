import java.io.*;
import java.util.*;

public class Admin {
    private static final String ADMIN_FILE = "data/admin_credentials.txt";
    
    // 验证管理员的用户名和密码
    public static boolean login(String username, String password) {
        try {
            List<String> credentials = readAdminCredentials();
            return credentials.get(0).equals(username) && credentials.get(1).equals(password);
        } catch (IOException e) {
            System.out.println("Error reading admin credentials.");
            return false;
        }
    }

    // 读取管理员凭证
    private static List<String> readAdminCredentials() throws IOException {
        List<String> credentials = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ADMIN_FILE))) {
            credentials.add(br.readLine()); // username
            credentials.add(br.readLine()); // password
        }
        return credentials;
    }
}
