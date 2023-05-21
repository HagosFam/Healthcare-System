package com.healthcare.insurance.model;

import com.healthcare.insurance.model.enums.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceClaim {
    @Id
    private String claimNumber;
    private long patientId;
    private InsuranceProvider insurance;

    private LocalDate submissionDate;
    private LocalDate processingDate;
    private List<String> diagnosisCodes;
    private List<String> procedureCodes;
    private BigDecimal billedAmount;
    private BigDecimal approvedAmount;

    private Status status;


}
