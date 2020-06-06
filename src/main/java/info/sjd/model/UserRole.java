package info.sjd.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    USER("USER"),
    ADMIN("ADMIN");

    private final String name;

}
