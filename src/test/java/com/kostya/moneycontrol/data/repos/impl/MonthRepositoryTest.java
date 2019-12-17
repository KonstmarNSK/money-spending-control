package com.kostya.moneycontrol.data.repos.impl;

import com.kostya.moneycontrol.config.MainConfig;
import com.kostya.moneycontrol.data.model.DayInfo;
import com.kostya.moneycontrol.data.model.Money;
import com.kostya.moneycontrol.data.model.MonthInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@DataJpaTest
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MainConfig.class)
public class MonthRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MonthRepository monthRepository;

    @Test
    public void simpleStoreAndLoadMonthInfo() {
        MonthInfo monthInfo = new MonthInfo();

        long monthInfoId = monthRepository.saveMonthInfo(monthInfo);
        MonthInfo summonedMonthInfo = monthRepository.getMonthInfo(monthInfoId);

        Assert.assertEquals("Wrong id!", monthInfoId, summonedMonthInfo.getId());
    }

    @Test
    public void storeAndLoadMonthInfoWithSomeData() {
        Money todayMoney = new Money(0, 12);
        Money moneyAtMonthBeginning = new Money(16, 25);
        Money moneyInMonthEnd = new Money(0, 0);

        DayInfo dayInfo = new DayInfo();
        dayInfo.setDate(new Date());
        dayInfo.setMoneyAtBeginning(todayMoney);
        dayInfo.setMoneyInEnd(todayMoney);

        MonthInfo monthInfo = new MonthInfo();
        monthInfo.setMoneyAtBeginning(moneyAtMonthBeginning);
        monthInfo.getDays().add(dayInfo);
        monthInfo.setMoneyInEnd(moneyInMonthEnd);

        long monthId = monthRepository.saveMonthInfo(monthInfo);
        MonthInfo summonedMonth = monthRepository.getMonthInfo(monthId);

        Assert.assertEquals("Day is wrong!", dayInfo, summonedMonth.getBeginningDate());
        Assert.assertEquals("Money in the beginning is wrong!",
                moneyAtMonthBeginning,
                summonedMonth.getMoneyAtBeginning());
        Assert.assertEquals("Money in the end is wrong!",
                moneyInMonthEnd,
                summonedMonth.getMoneyInEnd());
        Assert.assertEquals("Daily money is wrong!",
                todayMoney,
                summonedMonth.getDays().get(0).getMoneyAtBeginning());

    }
}