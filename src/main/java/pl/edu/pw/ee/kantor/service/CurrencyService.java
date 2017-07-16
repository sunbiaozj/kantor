package pl.edu.pw.ee.kantor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.ee.kantor.model.Currency;
import pl.edu.pw.ee.kantor.repository.CurrencyRepository;

import java.util.List;

@Service
public class CurrencyService {

    //Tu można dodać dodatkową logikę biznesową odnośnie elementów pozyskiwanych z bazy danych (np. walidacja, spr. czy użytk. ist.)
    @Autowired
    CurrencyRepository currencyRepository;

    public List<Currency> getList() {
        return currencyRepository.getAllCurrencies();
    }
}
