package ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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
    private String mobile;
    @NonNull
    private String alias;
}

