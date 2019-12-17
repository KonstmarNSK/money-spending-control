package com.kostya.moneycontrol.data;

import java.util.Objects;

/**
 * Objects of this class are used to identify object of class {@link com.kostya.moneycontrol.data.model.MonthInfo}
 * and must be unique
 */
public final class MonthId {
    private final long id;

    public MonthId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthId monthId = (MonthId) o;
        return id == monthId.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
