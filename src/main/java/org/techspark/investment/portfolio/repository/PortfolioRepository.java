package org.techspark.investment.portfolio.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.techspark.investment.portfolio.document.PortfolioTransaction;

import java.util.List;

public interface PortfolioRepository extends MongoRepository<PortfolioTransaction, String> {

    List<PortfolioTransaction> findBySymbol(String tickerSymbol);

}
