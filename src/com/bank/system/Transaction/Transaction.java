package com.bank.system.Transaction;

import com.bank.system.Services.Services;

public interface Transaction {
    void getDetails(double amount,Services sender,Services receiver);


    String getMode();
}
