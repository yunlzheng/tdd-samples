package org.thoughtworks.regx;

import org.thoughtworks.regx.express.Express;

import java.util.List;

public class RegxEngine {
    public String transfor(String express, String input) {
        return match(new ExpressEngine().compile(express), input);
    }

    private String match(List<Express> expresses, String input) {
        return "(a)";
    }
}
