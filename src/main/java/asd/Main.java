package asd;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Instant instant = Instant.parse("2008-08-02T");
        System.out.println(instant.toString());
    }
}
