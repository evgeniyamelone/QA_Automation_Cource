package ui;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"firsName", "lastName", "password", "email",
        "day", "month", "year", "streetAddress", "city",
        "state", "postCode", "mobilePhone", "alias"})
public class UserAccountRegistrationForm {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String password;
    @NonNull
    private String email;
    @NonNull
    private String day;
    @NonNull
    private String month;
    @NonNull
    private String year;
    @NonNull
    private String streetAddress;
    @NonNull
    private String city;
    @NonNull
    private String state;
    @NonNull
    private String postCode;
    @NonNull
    private String mobilePhone;
    @NonNull
    private String alias;
}

