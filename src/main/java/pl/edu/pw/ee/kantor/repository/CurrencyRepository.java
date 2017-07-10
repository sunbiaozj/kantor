package pl.edu.pw.ee.kantor.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import pl.edu.pw.ee.kantor.model.Currency;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
// @Scope("prototype")
public class CurrencyRepository  {

    @PersistenceContext
    EntityManager entityManager;

    // JPQL/JPAQL, HQL
    public List<Currency> getAllCurrencies() {
        Query query = entityManager.createQuery("SELECT c FROM Currency c");
        List<Currency> resultList = (List<Currency>) query.getResultList();
        return resultList;
    }
}
