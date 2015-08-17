package org.thoughtworks.regx.express;


import java.util.List;

public class EscapeExpress extends BaseExpress {

    public EscapeExpress(String express) {
        super(express);
    }

    public EscapeExpress() {

    }

    @Override
    public String process(String express, List<Express> result) {
        result.add(new EscapeExpress(express.substring(0, 2)));
        express = express.substring(2, express.length());
        return express;
    }
}
