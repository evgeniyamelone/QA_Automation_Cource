package ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
public class UserAccount {
    @NonNull
    private String email;
    @NonNull
    private String password;
}
