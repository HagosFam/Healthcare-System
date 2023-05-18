package com.healthcare.service.dto;

import java.util.List;

public class BillsDto {
    private List<BillDto> bills;

    public BillsDto(List<BillDto> bills) {
        this.bills = bills;
    }

    public List<BillDto> getBills() {
        return bills;
    }
}
