package pl.edu.pw.ee.kantor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.pw.ee.kantor.model.Currency;
import pl.edu.pw.ee.kantor.model.NbpCurrency;
import pl.edu.pw.ee.kantor.service.CurrencyService;

import java.util.List;

//Sam @Controller ma za zadanie zwrócić do klienta model, jak i widok (pełne dane, widok w postaci HTML-a)
//@RestController jest używany, gdyby to NASZA aplikacja była serwerem wysyłającym jakieś dane za pomocą odpowiedzi HTTP.
//Wówczas odpowiedź od serwera jest wysyłana za pomocą wyłącznie informacji (bez pattern-u) formatami XML, albo teraz częściej JSON!
@Controller
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @Autowired
    RestTemplate restTemplate; //To jest klasa, która jest tu u nas klientem REST-owym. Do tego kontrolera powinien być wstrzyknięty klient REST-owy!
    // W związku z tym, że nie jest w stanie być wstrzyknięty z zewnętrznej biblioteki (jego instancja), to musimy dodać SWÓJ plik @Configuration,
    // w którym dodamy jego instancję jako @Bean-a, a więc jako obiekt sterowany przez kontener Spring IoC, czyli część szkieletu naszej aplikacji!
    // Właśnie dependency injection bazuje na wstrzykiwaniu obiektów składowych z użyciem fabryki @Bean-ów (a jak nie można go stworzyć
    // łatwo, to wtedy tworzy się odpowiednią instancję i dodaje adnotację @Bean!

//    private static final String URL = "http://api.nbp.pl/api/exchangerates/rates/A/EUR";
    private static final String RATES_URL = "http://api.nbp.pl/api/exchangerates/tables/A";

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping //(Wchodząc pod ten adres URL (wyznaczony przez mapowanie)możemy odczytać informacje z bazy danych metodą GET)
    public ModelAndView getList() {

//        NbpCurrency responseFromService = restTemplate.getForObject(URL, NbpCurrency.class);
//        System.out.println(responseFromService);

        NbpCurrency[] forObject = restTemplate.getForObject(RATES_URL, NbpCurrency[].class);

        for (NbpCurrency nbpCurrency : forObject){
            System.out.println(nbpCurrency);
        }

        Currency pln = new Currency();
        pln.setId(1L);
        pln.setName("PLN");
        pln.setValue(4.36298);

        List<Currency> currencies = currencyService.getList();

        ModelAndView mav = new ModelAndView();
        mav.addObject("currency", pln);
        mav.addObject("list", currencies);
        mav.addObject("nbpCurrency", forObject[0]);

        mav.setViewName("list");
        return mav;
    }
}
