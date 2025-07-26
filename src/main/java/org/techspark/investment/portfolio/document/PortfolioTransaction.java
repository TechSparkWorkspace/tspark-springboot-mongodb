package org.techspark.investment.portfolio.document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "portfolio")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioTransaction {

    @Id
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

