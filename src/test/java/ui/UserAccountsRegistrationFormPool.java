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
public class UserAccountsRegistrationFormPool {
    Map<String, UserAccountRegistrationForm> userAccountRegistrationForms;

    public void deserialize(String filePath) {
        userAccountRegistrationForms = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        try {
            UserAccountRegistrationForm registrationForm = objectMapper.readValue(file, UserAccountRegistrationForm.class);
            userAccountRegistrationForms.put(filePath, registrationForm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serialize(String filePath, String firsName, String lastName, String password, String email,
                          String day, String month, String year, String streetAddress, String city,
                          String state, String postCode, String mobilePhone, String alias) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            UserAccountRegistrationForm registrationForm = new UserAccountRegistrationForm();
            registrationForm.setFirstName(firsName);
            registrationForm.setLastName(lastName);
            registrationForm.setPassword(password);
            registrationForm.setEmail(email);
            registrationForm.setEmail(email);
            registrationForm.setDay(day);
            registrationForm.setMonth(month);
            registrationForm.setYear(year);
            registrationForm.setStreetAddress(streetAddress);
            registrationForm.setCity(city);
            registrationForm.setState(state);
            registrationForm.setPostCode(postCode);
            registrationForm.setMobilePhone(mobilePhone);
            registrationForm.setAlias(alias);
            objectMapper.writeValue(new FileOutputStream(filePath), registrationForm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserAccountRegistrationForm getUserRegistrationForm(String filePath) {
        return userAccountRegistrationForms.get(filePath);
    }

}
