package org.techspark.investment.portfolio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techspark.investment.portfolio.document.PortfolioTransaction;
import org.techspark.investment.portfolio.dto.PortfolioTransactionDTO;
import org.techspark.investment.portfolio.mapper.PortfolioTransactionMapper;
import org.techspark.investment.portfolio.repository.PortfolioRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository repository;
    private final PortfolioTransactionMapper mapper;

    @Override
    public PortfolioTransactionDTO create(PortfolioTransactionDTO dto) {
        PortfolioTransaction entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<PortfolioTransactionDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public List<PortfolioTransactionDTO> getBySymbol(String symbol) {
        return mapper.toDtoList(repository.findBySymbol(symbol));
    }

    @Override
    public PortfolioTransactionDTO update(String id, PortfolioTransactionDTO dto) {
        PortfolioTransaction existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        existing.setSymbol(dto.getSymbol());
        existing.setType(dto.getType());
        existing.setQuantity(dto.getQuantity());
        existing.setPrice(dto.getPrice());
        existing.setDate(dto.getDate());

        return mapper.toDto(repository.save(existing));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
