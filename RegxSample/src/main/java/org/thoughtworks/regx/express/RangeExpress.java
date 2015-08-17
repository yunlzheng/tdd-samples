package org.thoughtworks.regx.express;

import java.util.List;

public class RangeExpress extends BaseExpress {
    public RangeExpress(String express) {
        super(express);
    }

    public RangeExpress() {

    }

    @Override
    public String process(String express, List<Express> result) {
        int end = express.indexOf("]") + 1;
        result.add(new RangeExpress(express.substring(0, end)));
        return express.substring(end, express.length());
    }
}
