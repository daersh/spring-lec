package com.common;

public interface Account {
    /*설명. 잔액 조회*/
    String getBalance(); //public abstract 생략된것

    /*설명. 입금*/
    String deposit(int money);
    /*설명. 출금*/
    String witDraw(int money);

}
