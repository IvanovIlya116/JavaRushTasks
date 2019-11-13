package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }



    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (this == null && o == null) {
            return true;
        }

        if (this != null && o == null) {
            return false;
        }

        if (! (o instanceof Solution)) {
            return false;
        }
        Solution n = (Solution) o;

        return ((n.first == null && first == null) || n.first.equals(first)) &&
                ((n.last == null && last == null) || n.last.equals(last));
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }
}
