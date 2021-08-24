package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    String username;
    String password;
    String productName;
    String firstName;
    String lastName;
    String zipCode;


}
