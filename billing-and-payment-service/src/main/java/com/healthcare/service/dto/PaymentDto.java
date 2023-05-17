package com.healthcare.service.dto;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PaymentDto {
    private Long id;
    private double amount;
    private Date paymentDate;
}