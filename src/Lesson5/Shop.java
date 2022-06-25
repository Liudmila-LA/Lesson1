package Lesson5;

import java.util.HashMap;

public class Shop {
    String nameShop;
    Double debit;
    Double credit;
    int year;
    HashMap<Months,Double> valuesByMonth = new HashMap<>();
    
    Shop(String name){
        this.nameShop = name;
        this.credit=0.0;
        this.debit=0.0;

        for (Months Month:Months.values()
             ) {
            this.valuesByMonth.put(Month, 0.0);
        }
    }
    Shop(String name, Double debit, Double credit, Months month, int year){
        this.nameShop = name;
        this.credit=credit;
        this.debit=debit;
        this.year = year;
        for (Months Month:Months.values()
        )
            this.valuesByMonth.put(Month, 0.0);
        this.valuesByMonth.put(month, this.valuesByMonth.get(month)+debit-credit);
    }

    public void addDebitForMonth(Double debit, Months month) {
        Double monthDebit = this.valuesByMonth.get(month);
        monthDebit +=debit;
        this.valuesByMonth.put(month, monthDebit);
        this.debit += debit;
    }
    public void addCreditForMonth(Double credit, Months month) {
        Double monthCredit = this.valuesByMonth.get(month);
        monthCredit += credit;
        this.valuesByMonth.put(month, monthCredit);
        this.credit += credit;
    }

    void getResultCredit() {
        System.out.printf("Расходы %s за весь период: %.2f %n",  this.nameShop, this.credit) ;
    }

    void resultByMonth(){

        System.out.println("Прибыль по магазину " + this.nameShop + " по месяцам:");
        for (Months month:
             Months.values()) {
            System.out.printf("%02d.%s %.2f %n", month.code, this.year, this.valuesByMonth.get(month));

        }
    }

}
