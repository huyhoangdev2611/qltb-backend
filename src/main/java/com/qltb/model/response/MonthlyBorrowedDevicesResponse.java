package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyBorrowedDevicesResponse {
    private int month;
    private long count;
}
