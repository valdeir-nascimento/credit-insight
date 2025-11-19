package io.github.credit.insight.api.domain.credito;

import java.util.List;
import java.util.Optional;

public interface CreditoGateway {

    List<Credito> findByNumeroNfse(String numeroNfse);

    Optional<Credito> findByNumeroCredito(String numeroCredito);

}
