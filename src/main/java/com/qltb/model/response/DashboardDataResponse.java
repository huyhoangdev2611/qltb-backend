package com.qltb.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardDataResponse {
    private long totalDevices;
    private long devicesInStorage;
    private long brokenDevices;
    private long lostDevices;
}
