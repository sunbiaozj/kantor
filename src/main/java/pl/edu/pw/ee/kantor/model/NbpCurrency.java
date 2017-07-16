package pl.edu.pw.ee.kantor.model;

import java.util.List;

public class NbpCurrency {

    private String table;
    private String currency;
    private String code;

    private List<NbpCurrencyRate> rates;

    public NbpCurrency(){
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<NbpCurrencyRate> getRates() {
        return rates;
    }

    public void setRates(List<NbpCurrencyRate> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "NbpCurrency{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }
}
