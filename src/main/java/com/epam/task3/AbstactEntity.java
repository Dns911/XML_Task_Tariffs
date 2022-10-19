package com.epam.task3;

import java.util.StringJoiner;

public class AbstactEntity {
    private long id;

    public AbstactEntity() {
    }

    public AbstactEntity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ",  "[", "]")
                .add("id=" + id)
                .toString();
    }
}
