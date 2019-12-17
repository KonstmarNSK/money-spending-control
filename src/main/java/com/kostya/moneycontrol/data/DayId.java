package com.kostya.moneycontrol.data;

import java.util.Objects;

public class DayId {
    private final long id;

    public DayId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayId dayId = (DayId) o;
        return id == dayId.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
