package com.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class TestService {
    private String msg;

    public String printout() {
        return msg;
    }
}
