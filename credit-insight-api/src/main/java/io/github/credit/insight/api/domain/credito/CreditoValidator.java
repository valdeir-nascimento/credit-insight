package io.github.credit.insight.api.domain.credito;

import io.github.credit.insight.api.domain.validation.Error;
import io.github.credit.insight.api.domain.validation.ValidationHandler;
import io.github.credit.insight.api.domain.validation.Validator;

import java.math.BigDecimal;

public class CreditoValidator extends Validator {

    private final Credito credito;

    public CreditoValidator(final Credito credito, final ValidationHandler handler) {
        super(handler);
        this.credito = credito;
    }

    @Override
    public void validate() {

        if (credito.getNumeroCredito() == null || credito.getNumeroCredito().isBlank()) {
            validationHandler().append(new Error("'numeroCredito' cannot be null or empty"));
        }

        if (credito.getNumeroNfse() == null || credito.getNumeroNfse().isBlank()) {
            validationHandler().append(new Error("'numeroNfse' cannot be null or empty"));
        }

        if (credito.getValorIssqn() == null || credito.getValorIssqn().compareTo(BigDecimal.ZERO) < 0) {
            validationHandler().append(new Error("'valorIssqn' must be >= 0"));
        }

        if (credito.getAliquota() == null || credito.getAliquota().compareTo(BigDecimal.ZERO) < 0) {
            validationHandler().append(new Error("'aliquota' must be >= 0"));
        }

        if (credito.getBaseCalculo() == null || credito.getBaseCalculo().compareTo(BigDecimal.ZERO) < 0) {
            validationHandler().append(new Error("'baseCalculo' must be >= 0"));
        }
    }
}
