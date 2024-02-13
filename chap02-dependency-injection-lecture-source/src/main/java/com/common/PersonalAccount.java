package com.common;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PersonalAccount implements Account{
    private final int bankCode;
    private final String accNo;
    private int balance; //설명. 잔액

    public PersonalAccount(int bankCode, String accNo) {
        this.bankCode = bankCode;
        this.accNo = accNo;
    }
    @Override
    public String getBalance() {
        return this.accNo+" 계좌의 현재 잔액은 "+ this.balance + "원 입니다.";
    }

    @Override
    public String deposit(int money) {
        String str = "";
        if(money>=0){
            this.balance +=money;
            str = money+"원 입금";
        }else{
            str = "잘못된 금액";
        }
        return str;
    }

    @Override
    public String witDraw(int money) {
        String str = "";
        if(money<=this.balance){
            balance-=money;
            str= money+"원 출금하였습니다. 남은 잔액은 "+ balance+"원 입니다.";
        }else {
            str = "잔액 초과입니다.";
        }
        return str;
    }
}
