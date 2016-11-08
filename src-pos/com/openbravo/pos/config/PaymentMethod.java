package com.openbravo.pos.config;

public enum PaymentMethod {
  FREE(1L, "free"),
  CASH(10L, "cash"),
  CASH_REFOUND(11L, "cashrefund"),
  CASH_IN(12L, "cashin"),
  CASH_OUT(13L, "cashout"),
  CARD(20L, "magcard"),
  CARD_REFOUND(21L, "magcardrefund"),
  DEBT_PAID(30L, "debtpaid"),
  DEBT(31L, "debt"),
  CHECK(40L, "cheque"),
  CHECK_REFOUND(41L, "chequerefund"),
  PAPER_IN(50L, "paperin"),
  PAPER_OUT(51L, "paperout"),
  TICKET(60L, "ticket");
  
  private Long key;
  private String value;
  
  PaymentMethod(Long key, String value) {
    this.key = key;
    this.value = value;
  }
  
  public Long getKey() {
    return key;
  }
  public String getValue() {
    return value;
  }

  public static String getString(Long value) {
    String val = null;
    for (PaymentMethod paymentMethod : PaymentMethod.values()) {
      if (paymentMethod.getKey().equals(value)) {
        val = paymentMethod.getValue();
        break;
      }
    }
    return val;
  }

  
  
}
