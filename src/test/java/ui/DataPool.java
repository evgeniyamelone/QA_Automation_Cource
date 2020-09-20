package ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class DataPool {

    Map<String,UserAccount> users = new HashMap<String, UserAccount>();

    public void processDataFile(String filePath) {

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        try {
            UserAccount user = objectMapper.readValue(file, UserAccount.class);
            users.put(filePath, user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

