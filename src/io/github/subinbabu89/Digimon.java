package io.github.subinbabu89;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Digimon {
    private static Map<String, Digimon> map = new HashMap<>();
    private final String key;
    private Set<Digimon> parents = new LinkedHashSet<>();

    Digimon(String str) {
        key = str;
    }

    static Digimon get(String str) {
        Digimon res = map.get(str);
        if (res == null) {
            res = new Digimon(str);
            map.put(str, res);
        }
        return res;
    }

    String getKey() {
        return key;
    }

    void addParent(Digimon n) {
        parents.add(n);
    }

    Set<Digimon> getParents() {
        return parents;
    }

    public boolean equals(Object n) {
        return key.equals(((Digimon) n).key);
    }

    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return key;
    }
}
