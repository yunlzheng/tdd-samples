package org.thoughtworks.regx;


import org.thoughtworks.regx.express.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressEngine {

    public static final String ANY_TIMES = "*";
    public static final String ANY_CHARACTER = ".";
    public static final String AT_LEST_ONCE = "+";
    public static final String ESCAPE = "\\";

    private static Map<String, Express> expressMap = new HashMap<String, Express>();

    public static final String RANGE = "[";

    static {
        expressMap.put(ANY_TIMES, new AnyTimesExpress());
        expressMap.put(ANY_CHARACTER, new AnyCharacterExpress());
        expressMap.put(AT_LEST_ONCE, new AtLestOncesExpress());
        expressMap.put(ESCAPE, new EscapeExpress());
        expressMap.put(RANGE, new RangeExpress());
    }

    public List<Express> compile(String express) {
        List<Express> result = new ArrayList<Express>();
        String cache = "";
        while (express.length() > 0) {
            String meta = express.substring(0, 1);
            if (expressMap.containsKey(meta)) {
                cache = freshCache(result, cache);
                express = expressMap.get(meta).process(express, result);
            } else {
                cache += meta;
                express = new NormalExpress().process(express, result);
            }
        }
        freshCache(result, cache);

        return result;
    }

    private String freshCache(List<Express> result, String cache) {
        if (!cache.equals("")) {
            result.add(new NormalExpress(cache));
        }
        cache = "";
        return cache;
    }
}
