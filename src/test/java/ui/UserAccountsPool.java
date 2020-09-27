package ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class UserAccountsPool {
    Map<String, UserAccount> users;

    public void deserialize(String filePath) {
        users = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        try {
            UserAccount user = objectMapper.readValue(file, UserAccount.class);
            users.put(filePath, user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serialize(String filePath, String email, String password) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            UserAccount user = new UserAccount();
            user.setEmail(email);
            user.setPassword(password);
            objectMapper.writeValue(new FileOutputStream(filePath), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserAccount getUser(String filePath) {
        return users.get(filePath);
    }
}

