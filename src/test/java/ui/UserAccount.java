package ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserAccount {
    @NonNull
    private String email;
    @NonNull
    private String password;
}
