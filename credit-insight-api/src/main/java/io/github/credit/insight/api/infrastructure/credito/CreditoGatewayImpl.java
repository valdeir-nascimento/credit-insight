package io.github.credit.insight.api.infrastructure.credito;

import io.github.credit.insight.api.domain.credito.Credito;
import io.github.credit.insight.api.domain.credito.CreditoGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CreditoGatewayImpl implements CreditoGateway {

    private final CreditoJpaRepository creditoJpaRepository;

    public CreditoGatewayImpl(final CreditoJpaRepository creditoJpaRepository) {
        this.creditoJpaRepository = creditoJpaRepository;
    }

    @Override
    public List<Credito> findByNumeroNfse(String numeroNfse) {
        return this.creditoJpaRepository.findByNumeroNfse(numeroNfse).stream()
            .map(CreditoJpaEntity::toAggregate)
            .toList();
    }

    @Override
    public Optional<Credito> findByNumeroCredito(String numeroCredito) {
        return this.creditoJpaRepository.findByNumeroCredito(numeroCredito)
            .map(CreditoJpaEntity::toAggregate);
    }
}
