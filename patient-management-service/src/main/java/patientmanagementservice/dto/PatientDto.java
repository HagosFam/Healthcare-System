package patientmanagementservice.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import patientmanagementservice.entity.Address;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private Long id;
    @NotBlank(message = "firstName should not be empty")
    private String firstName;
    @NotBlank(message = "lastName should not be empty")
    private String lastName;
    @NotBlank(message = "phoneNumber should not be empty")
    private String phoneNumber;
    @Nullable
    private String insuranceId;
    @NotBlank(message = "email should not be empty")
    @Email(message = "email should be valid")
    private String email;
    private Address address;
}
