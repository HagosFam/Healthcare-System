package com.healthcare.service.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BillDto {
    private Long id;
    private Long patientId;
    private String servicesRendered;
    private PaymentDto payment;
}