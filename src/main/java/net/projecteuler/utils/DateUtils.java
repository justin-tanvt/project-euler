package net.projecteuler.utils;

public class DateUtils {

    DAY day;
    MONTH month;
    int year;

    public enum DAY {
        MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT,
        SUN
    }

    public enum MONTH {
        JAN(31),
        FEB(28),
        MAR(31),
        APR(30),
        MAY(31),
        JUN(30),
        JUL(31),
        AUG(31),
        SEP(30),
        OCT(31),
        NOV(30),
        DEC(31);

        final int daysInMonth;

        MONTH(int daysInMonth) {
            this.daysInMonth = daysInMonth;
        }

        public int getDaysInMonth(int year) {
            if (this != MONTH.FEB) {
                return daysInMonth;
            }

            return isLeap(year) ? 29 : 28;
        }

        private boolean isLeap(int year) {
            // if not divisible by 4, is not leap year
            if (year % 4 != 0) {
                return false;
            }

            // if not century, is leap year
            if (year % 100 != 0) {
                return true;
            }

            // if century and divisible by 400, is leap year
            return year % 400 == 0;
        }
    }

    public void advanceToFirstOfNextMonth() {
        int daysToAdvance = this.month.getDaysInMonth(this.year);
        this.day = DAY.values()[(this.day.ordinal() + daysToAdvance) % DAY.values().length];
        this.month = MONTH.values()[(this.month.ordinal() + 1) % MONTH.values().length];

        if (this.month == MONTH.JAN) {
            this.year += 1;
        }
    }

    public DateUtils(DAY day, MONTH month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public DAY getDay() {
        return this.day;
    }

    public int getYear() {
        return this.year;
    }
}
