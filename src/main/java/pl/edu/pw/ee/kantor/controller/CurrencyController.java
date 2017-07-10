package pl.edu.pw.ee.kantor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.pw.ee.kantor.model.Currency;
import pl.edu.pw.ee.kantor.service.CurrencyService;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ModelAndView getList() {

        Currency pln = new Currency();
        pln.setId(1L);
        pln.setName("PLN");
        pln.setValue(4.36298);

        List<Currency> currencies = currencyService.getList();

        ModelAndView mav = new ModelAndView();
        mav.addObject("currency", pln);
        mav.addObject("list", currencies);
        mav.setViewName("list");
        return mav;
    }
}
