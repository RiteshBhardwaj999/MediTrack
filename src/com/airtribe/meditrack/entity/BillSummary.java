package com.airtribe.meditrack.entity;

public final class BillSummary {

    private final int billId;
    private final double amount;
    private final double tax;
    private final double total;

    public BillSummary(int billId, double amount,
                       double tax, double total) {
        this.billId = billId;
        this.amount = amount;
        this.tax = tax;
        this.total = total;
    }

    public int getBillId() { return billId; }
    public double getAmount() { return amount; }
    public double getTax() { return tax; }
    public double getTotal() { return total; }
}
