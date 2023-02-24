package fr.educentre.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class RenameReservationClientRequestDto {

    @Email(message = "Email is not valid")
    @Size(min = 4, message = "email must at least 4 characters long")
    private String newEmail;

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
