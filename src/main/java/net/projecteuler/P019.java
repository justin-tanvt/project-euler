package net.projecteuler;

import net.projecteuler.utils.P019Date;
import net.projecteuler.utils.P019Date.*;

public class P019 {

    public static void main(String[] args) {
        // reference = 1 Jan 1900 (Mon)
        P019Date currentDate = new P019Date(DAY.MON, MONTH.JAN, 1900);

        // question - How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
        // i.e. how many times were the first day of the month a Sunday, between 1 Jan 1901 to 31 Dec 2000?
        DAY questionDay = DAY.SUN;
        int questionYearStart = 1901;
        int questionYearEnd = 2000;

        int solution = 0;
        while (currentDate.getYear() <= questionYearEnd) {
            if (currentDate.getYear() >= questionYearStart && currentDate.getDay() == questionDay) {
                solution++;
            }

            currentDate.advanceToFirstOfNextMonth();
        }

        System.out.printf("\nfinal solution = %s\n", solution);
    }
}
