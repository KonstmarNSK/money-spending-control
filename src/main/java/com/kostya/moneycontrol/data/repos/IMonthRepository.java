package com.kostya.moneycontrol.data.repos;

import com.kostya.moneycontrol.data.model.MonthInfo;

public interface IMonthRepository {
    MonthInfo getMonthInfo(long monthId);
    long saveMonthInfo(MonthInfo monthInfo);
}
