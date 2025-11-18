package io.github.credit.insight.api.domain.credito;

import io.github.credit.insight.api.domain.Identifier;

import java.util.Objects;

public class CreditoID extends Identifier {

    private final Long value;

    private CreditoID(final Long value) {
        this.value = Objects.requireNonNull(value, "'id' cannot be null");
    }

    public static CreditoID from(final Long value) {
        return new CreditoID(value);
    }

    public static CreditoID unique(final Long value) {
        return new CreditoID(value);
    }

    @Override
    public Long getValue() {
        return value;
    }

}
