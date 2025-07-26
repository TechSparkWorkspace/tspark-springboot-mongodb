package org.techspark.investment.portfolio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.techspark.investment.portfolio.document.TransactionType;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioTransactionDTO {

    private String id;

    @NotBlank
    private String symbol;

    @NotNull
    private TransactionType type; // BUY or SELL

    @NotNull
    private Double quantity;

    @NotNull
    private Double price;

    @NotNull
    private LocalDate date;
}
