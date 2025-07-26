package org.techspark.investment.portfolio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techspark.investment.portfolio.document.PortfolioTransaction;
import org.techspark.investment.portfolio.dto.PortfolioTransactionDTO;
import org.techspark.investment.portfolio.service.PortfolioService;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor
@Tag(name = "Portfolio Management", description = "APIs for managing portfolio transactions")
public class PortfolioController {

    private final PortfolioService portfolioService;

    @Operation(
            summary = "Create a new portfolio transaction",
            description = "Adds a new portfolio transaction to the system.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Record created successfully",
                            content = @Content(schema = @Schema(implementation = PortfolioTransaction.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error")
            }
    )
    @PostMapping
    public ResponseEntity<PortfolioTransactionDTO> create(@Valid @RequestBody PortfolioTransactionDTO dto) {
        return ResponseEntity.ok(portfolioService.create(dto));
    }

    @Operation(
            summary = "Get all portfolio transactions",
            description = "Retrieves all portfolio transactions from the system.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of portfolio transactions retrieved successfully",
                            content = @Content(schema = @Schema(implementation = PortfolioTransactionDTO.class)))
            }
    )
    @GetMapping
    public ResponseEntity<List<PortfolioTransactionDTO>> getAll() {
        return ResponseEntity.ok(portfolioService.getAll());
    }

    @Operation(
            summary = "Get portfolio transactions by symbol",
            description = "Retrieves all portfolio transactions for a specific stock symbol.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of portfolio transactions for the symbol retrieved successfully",
                            content = @Content(schema = @Schema(implementation = PortfolioTransactionDTO.class))),
                    @ApiResponse(responseCode = "404", description = "No transactions found for the given symbol")
            }
    )
    @GetMapping("/{symbol}")
    public ResponseEntity<List<PortfolioTransactionDTO>> getBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(portfolioService.getBySymbol(symbol));
    }

    @Operation(
            summary = "Update a portfolio transaction",
            description = "Updates an existing portfolio transaction by ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Portfolio transaction updated successfully",
                            content = @Content(schema = @Schema(implementation = PortfolioTransactionDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Transaction not found")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<PortfolioTransactionDTO> update(@PathVariable String id, @RequestBody PortfolioTransactionDTO dto) {
        return ResponseEntity.ok(portfolioService.update(id, dto));
    }

    @Operation(
            summary = "Delete a portfolio transaction",
            description = "Deletes a portfolio transaction by ID.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Transaction deleted successfully"),
                    @ApiResponse(responseCode = "404", description = "Transaction not found")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        portfolioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
