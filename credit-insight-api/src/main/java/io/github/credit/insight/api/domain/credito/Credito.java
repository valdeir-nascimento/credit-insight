package io.github.credit.insight.api.domain.credito;

import io.github.credit.insight.api.domain.AggregateRoot;
import io.github.credit.insight.api.domain.validation.ValidationHandler;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Credito extends AggregateRoot<CreditoID> {

    private String numeroCredito;
    private String numeroNfse;
    private LocalDate dataConstituicao;
    private BigDecimal valorIssqn;
    private String tipoCredito;
    private Boolean simplesNacional;
    private BigDecimal aliquota;
    private BigDecimal valorFaturado;
    private BigDecimal valorDeducao;
    private BigDecimal baseCalculo;

    private Credito(
        final CreditoID id,
        final String numeroCredito,
        final String numeroNfse,
        final LocalDate dataConstituicao,
        final BigDecimal valorIssqn,
        final String tipoCredito,
        final Boolean simplesNacional,
        final BigDecimal aliquota,
        final BigDecimal valorFaturado,
        final BigDecimal valorDeducao,
        final BigDecimal baseCalculo
    ) {
        super(id);

        this.numeroCredito = numeroCredito;
        this.numeroNfse = numeroNfse;
        this.dataConstituicao = dataConstituicao;
        this.valorIssqn = valorIssqn;
        this.tipoCredito = tipoCredito;
        this.simplesNacional = simplesNacional;
        this.aliquota = aliquota;
        this.valorFaturado = valorFaturado;
        this.valorDeducao = valorDeducao;
        this.baseCalculo = baseCalculo;

    }

    public static Credito newCredito(
        final Long id,
        final String numeroCredito,
        final String numeroNfse,
        final LocalDate dataConstituicao,
        final BigDecimal valorIssqn,
        final String tipoCredito,
        final Boolean simplesNacional,
        final BigDecimal aliquota,
        final BigDecimal valorFaturado,
        final BigDecimal valorDeducao,
        final BigDecimal baseCalculo
    ) {
        final var creditoId = CreditoID.from(id);

        return new Credito(
            creditoId,
            numeroCredito,
            numeroNfse,
            dataConstituicao,
            valorIssqn,
            tipoCredito,
            simplesNacional,
            aliquota,
            valorFaturado,
            valorDeducao,
            baseCalculo
        );
    }

    public static Credito with(
        final CreditoID id,
        final String numeroCredito,
        final String numeroNfse,
        final LocalDate dataConstituicao,
        final BigDecimal valorIssqn,
        final String tipoCredito,
        final Boolean simplesNacional,
        final BigDecimal aliquota,
        final BigDecimal valorFaturado,
        final BigDecimal valorDeducao,
        final BigDecimal baseCalculo

    ) {
        return new Credito(
            id,
            numeroCredito,
            numeroNfse,
            dataConstituicao,
            valorIssqn,
            tipoCredito,
            simplesNacional,
            aliquota,
            valorFaturado,
            valorDeducao,
            baseCalculo
        );
    }


    @Override
    public void validate(final ValidationHandler handler) {
        new CreditoValidator(this, handler).validate();
    }

    public Credito update(
        final String numeroCredito,
        final String numeroNfse,
        final LocalDate dataConstituicao,
        final BigDecimal valorIssqn,
        final String tipoCredito,
        final Boolean simplesNacional,
        final BigDecimal aliquota,
        final BigDecimal valorFaturado,
        final BigDecimal valorDeducao,
        final BigDecimal baseCalculo
    ) {
        this.numeroCredito = numeroCredito;
        this.numeroNfse = numeroNfse;
        this.dataConstituicao = dataConstituicao;
        this.valorIssqn = valorIssqn;
        this.tipoCredito = tipoCredito;
        this.simplesNacional = simplesNacional;
        this.aliquota = aliquota;
        this.valorFaturado = valorFaturado;
        this.valorDeducao = valorDeducao;
        this.baseCalculo = baseCalculo;

        return this;
    }

    public CreditoID getId() {
        return id;
    }

    public String getNumeroCredito() {
        return numeroCredito;
    }

    public String getNumeroNfse() {
        return numeroNfse;
    }

    public LocalDate getDataConstituicao() {
        return dataConstituicao;
    }

    public BigDecimal getValorIssqn() {
        return valorIssqn;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public Boolean isSimplesNacional() {
        return simplesNacional;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public BigDecimal getValorFaturado() {
        return valorFaturado;
    }

    public BigDecimal getValorDeducao() {
        return valorDeducao;
    }

    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }
}
