package io.github.credit.insight.api.infrastructure.credito;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CreditoJpaRepository extends JpaRepository<CreditoJpaEntity, Long> {

    List<CreditoJpaEntity> findByNumeroNfse(String numeroNfse);

    Optional<CreditoJpaEntity> findByNumeroCredito(String numeroCredito);

}
