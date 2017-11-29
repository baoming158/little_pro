package com.dmw.tools;

/**
 * 等额本金：每月还款额 = 总贷款额/总贷款月数 +(总贷款额-已还款本金额)*年利率/12
 * 还款总额=（还款月数+1）×贷款额×月利率/2+ 贷款额
 * ---------------------------------------------------------------------------
 * 等额本息：设贷款额为a，月利率为i，年利率为I，还款月数为n，每月还款额为b，还款利息总和为Y
 * 每月还款额 b＝a×i×（1＋i）^n÷〔（1＋i）^n－1〕
 * 第n月还款本金 (b-a*i)*(1+i)^(n-1)
 * 支付利息:Y＝n×a×i×（1＋i）^n÷〔（1＋i）^n－1〕－a
 * 还款总额:n×a×i×（1＋i）^n÷〔（1＋i）^n－1〕
 */
public class CalculateInterest {
    private static double total_money = 790000;
    private static double total_month = 360;

    public static void main(String[] args) {
        double year_rate = 0.0588;
        calculate_permonth_paid_detail(total_money,total_month,year_rate);
    }

    /**
     * 等额本金每月还款明细
     *
     */
    public static void calculate_permonth_paid_detail(double total_money,double total_month,double year_rate){
        double paid_total_money = (total_month+1)*total_money*(year_rate/12)/2+total_money;
        System.out.println("total:"+paid_total_money);
        double permonth_paid_money = total_money/total_month;
        for(int i=0;i<total_month;i++){
            double remaind_money_interest = (total_money - permonth_paid_money * i) * year_rate / 12;
            double permonth_paid_total_money = permonth_paid_money + remaind_money_interest;
            System.out.println(permonth_paid_money+" "+remaind_money_interest+" "+permonth_paid_total_money);
        }

    }

    /**
     * 等额本息每月还款明细
     */
    public static void calculate_permonth_paid_bx_detail(double total_money,double total_month,double year_rate){

        double paid_total_money = total_month*total_money*(year_rate/12)*Math.pow((1+year_rate/12),total_month)/(Math.pow((1+year_rate/12),total_month)-1);
        System.out.println("total:"+paid_total_money);
        double per_month_paid = total_money*year_rate/12*Math.pow((1+year_rate/12),total_month)/(Math.pow((1+year_rate/12),total_month)-1);
        for(int i=0;i<total_month;i++){
            double per_month_bj= (per_month_paid- total_money*year_rate/12)*Math.pow((1+year_rate/12),i+1-1);
            double per_month_lx = per_month_paid -per_month_bj;
            System.out.println(per_month_bj+" "+per_month_lx+" "+ per_month_paid);
        }

    }
}
