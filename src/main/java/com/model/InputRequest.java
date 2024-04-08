package com.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InputRequest {

    String compName;
    String service;

    String ipAddress;
    String dnsName;
    String portNumber;
    String desc;

}
