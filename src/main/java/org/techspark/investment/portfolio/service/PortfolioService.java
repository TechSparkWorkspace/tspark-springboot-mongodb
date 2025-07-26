package org.techspark.investment.portfolio.service;

import org.techspark.investment.portfolio.dto.PortfolioTransactionDTO;

import java.util.List;

public interface PortfolioService {
    PortfolioTransactionDTO create(PortfolioTransactionDTO dto);

    List<PortfolioTransactionDTO> getAll();

    List<PortfolioTransactionDTO> getBySymbol(String symbol);

    PortfolioTransactionDTO update(String id, PortfolioTransactionDTO dto);

    void delete(String id);
}