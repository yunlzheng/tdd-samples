package org.thoughtworks.regx.express;

import java.util.List;

public interface Express {

    public String process(String express, List<Express> result);
}
