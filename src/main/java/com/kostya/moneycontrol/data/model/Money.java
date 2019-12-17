package com.kostya.moneycontrol.data.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.Objects;

@Embeddable
public class Money {
    private int integer;
    private int fractional;

    public Money() {
    }

    public Money(int integer, int fractional) {
        this.integer = integer;
        this.fractional = fractional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return integer == money.integer &&
                fractional == money.fractional;
    }

    @Override
    public int hashCode() {
        return Objects.hash(integer, fractional);
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public int getFractional() {
        return fractional;
    }

    public void setFractional(int fractional) {
        this.fractional = fractional;
    }
}
