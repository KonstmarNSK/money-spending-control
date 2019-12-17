package com.kostya.moneycontrol.data.model;

import com.kostya.moneycontrol.data.DayId;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "DAY_INFO")
public class DayInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "MONEY_AT_BEGINNING")
    private Money moneyAtBeginning;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "integer", column = @Column(name = "money_integer")),
            @AttributeOverride(name = "fractional", column = @Column(name = "money_fractional"))})
    private Money moneyInEnd;

    @ManyToOne
    private MonthInfo month;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Money getMoneyAtBeginning() {
        return moneyAtBeginning;
    }

    public void setMoneyAtBeginning(Money moneyAtBeginning) {
        this.moneyAtBeginning = moneyAtBeginning;
    }

    public Money getMoneyInEnd() {
        return moneyInEnd;
    }

    public void setMoneyInEnd(Money moneyInEnd) {
        this.moneyInEnd = moneyInEnd;
    }

    public MonthInfo getMonth() {
        return month;
    }

    public void setMonth(MonthInfo month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayInfo dayInfo = (DayInfo) o;
        return id == dayInfo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
