package com.kostya.moneycontrol.data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MONTH_INFO")
public class MonthInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "integer", column = @Column(name = "begin_money_integer")),
            @AttributeOverride(name = "fractional", column = @Column(name = "begin_money_fractional"))})
    private Money moneyAtBeginning;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "integer", column = @Column(name = "end_money_integer")),
            @AttributeOverride(name = "fractional", column = @Column(name = "end_money_fractional"))})
    private Money moneyInEnd;


    @OneToMany(cascade = CascadeType.ALL)
    private List<DayInfo> days = new ArrayList<>();


    public long getId() {
        return id;
    }

    public Money getMoneyAtBeginning() {
        return moneyAtBeginning;
    }

    public Money getMoneyInEnd() {
        return moneyInEnd;
    }

    public DayInfo getBeginningDate() {
        return getDays().get(0);
    }

    public List<DayInfo> getDays() {
        return days;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMoneyAtBeginning(Money moneyAtBeginning) {
        this.moneyAtBeginning = moneyAtBeginning;
    }

    public void setMoneyInEnd(Money moneyInEnd) {
        this.moneyInEnd = moneyInEnd;
    }

    public void setDays(List<DayInfo> days) {
        this.days = days;
    }
}
