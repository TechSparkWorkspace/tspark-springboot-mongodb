package org.techspark.investment.portfolio.mapper;

import org.mapstruct.Mapper;
import org.techspark.investment.portfolio.document.PortfolioTransaction;
import org.techspark.investment.portfolio.dto.PortfolioTransactionDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PortfolioTransactionMapper {
    PortfolioTransaction toEntity(PortfolioTransactionDTO dto);

    PortfolioTransactionDTO toDto(PortfolioTransaction entity);

    List<PortfolioTransactionDTO> toDtoList(List<PortfolioTransaction> list);
}
