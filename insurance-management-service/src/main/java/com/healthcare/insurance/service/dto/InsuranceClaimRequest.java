package com.healthcare.insurance.service.dto;

import com.healthcare.insurance.model.InsuranceProvider;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceClaimRequest {
    private long patientId;
    private InsuranceProvider insurance;

    private LocalDate submissionDate;
    private LocalDate processingDate;
    private List<String> diagnosisCodes;
    private List<String> procedureCodes;
    private BigDecimal billedAmount;
}
