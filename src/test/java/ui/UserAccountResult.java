package ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountResult {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String day;
    @NonNull
    private String month;
    @NonNull
    private String year;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserAccountResult userAccountResult = (UserAccountResult) o;
        return firstName.equals(userAccountResult.firstName) &&
                lastName.equals(userAccountResult.lastName) &&
                email.equals(userAccountResult.email) &&
                day.equals(userAccountResult.day) &&
                month.equals(userAccountResult.month) &&
                year.equals(userAccountResult.year);
    }
}

