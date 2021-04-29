package com.escaperooms.crazystans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Hinter {
    List<String> hints = new ArrayList<>();

    Hinter(String... args) {
        hints.addAll(Arrays.asList(args));
    }

    boolean isEmpty() {
        return hints.isEmpty();
    }

    String getHint() {
        return hints.remove(0);
    }
}