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
import org.springframework.boot.autoconfigure.domain.EntityScan;
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
    public void firstTest() {
        Money todayMoney = new Money();
        todayMoney.setFractional(0);
        todayMoney.setInteger(12);

        DayInfo dayInfo = new DayInfo();
        dayInfo.setDate(new Date());
        dayInfo.setMoneyAtBeginning(todayMoney);
        dayInfo.setMoneyInEnd(todayMoney);

        Money monthlyMoney = new Money();
        monthlyMoney.setInteger(10);
        monthlyMoney.setFractional(10);

        MonthInfo monthInfo = new MonthInfo();
        monthInfo.setMoneyAtBeginning(monthlyMoney);
        monthInfo.setMoneyInEnd(monthlyMoney);
        monthInfo.getDays().add(dayInfo);

        long monthInfoId = monthRepository.saveMonthInfo(monthInfo);
        MonthInfo summonedMonthInfo = monthRepository.getMonthInfo(monthInfoId);

        Assert.assertEquals("Not equal!", dayInfo, summonedMonthInfo.getBeginningDate());
    }
}