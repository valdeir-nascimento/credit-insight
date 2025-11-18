package io.github.credit.insight.api.domain.credito;

import io.github.credit.insight.api.domain.exception.DomainException;
import io.github.credit.insight.api.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CreditoTest {

    @Test
    void givenValidParams_whenCallNewCredito_thenInstantiateCredito() {
        // given
        final var expectedId = 1L;
        final var expectedNumeroCredito = "123456";
        final var expectedNumeroNfse = "7891011";
        final var expectedDataConstituicao = LocalDate.of(2024, 2, 25);
        final var expectedValorIssqn = new BigDecimal("1500.75");
        final var expectedTipoCredito = "ISSQN";
        final var expectedSimplesNacional = Boolean.TRUE;
        final var expectedAliquota = new BigDecimal("5.0");
        final var expectedValorFaturado = new BigDecimal("30000.00");
        final var expectedValorDeducao = new BigDecimal("5000.00");
        final var expectedBaseCalculo = new BigDecimal("25000.00");

        // when
        final var actualCredito = Credito.newCredito(
            expectedId,
            expectedNumeroCredito,
            expectedNumeroNfse,
            expectedDataConstituicao,
            expectedValorIssqn,
            expectedTipoCredito,
            expectedSimplesNacional,
            expectedAliquota,
            expectedValorFaturado,
            expectedValorDeducao,
            expectedBaseCalculo
        );

        // then
        assertNotNull(actualCredito);
        assertNotNull(actualCredito.getId());
        assertEquals(expectedId, actualCredito.getId().getLongValue());
        assertEquals(expectedNumeroCredito, actualCredito.getNumeroCredito());
        assertEquals(expectedNumeroNfse, actualCredito.getNumeroNfse());
        assertEquals(expectedDataConstituicao, actualCredito.getDataConstituicao());
        assertEquals(expectedValorIssqn, actualCredito.getValorIssqn());
        assertEquals(expectedTipoCredito, actualCredito.getTipoCredito());
        assertEquals(expectedSimplesNacional, actualCredito.isSimplesNacional());
        assertEquals(expectedAliquota, actualCredito.getAliquota());
        assertEquals(expectedValorFaturado, actualCredito.getValorFaturado());
        assertEquals(expectedValorDeducao, actualCredito.getValorDeducao());
        assertEquals(expectedBaseCalculo, actualCredito.getBaseCalculo());
        assertNotNull(actualCredito.getCreatedAt());
        assertNotNull(actualCredito.getUpdatedAt());
    }

    @Test
    void givenInvalidNullNumeroCredito_whenCallNewCreditoAndValidate_thenShouldReceiveError() {
        // given
        final var expectedId = 1L;
        final String expectedNumeroCredito = null;
        final var expectedNumeroNfse = "7891011";
        final var expectedDataConstituicao = LocalDate.of(2024, 2, 25);
        final var expectedValorIssqn = new BigDecimal("1500.75");
        final var expectedTipoCredito = "ISSQN";
        final var expectedSimplesNacional = Boolean.TRUE;
        final var expectedAliquota = new BigDecimal("5.0");
        final var expectedValorFaturado = new BigDecimal("30000.00");
        final var expectedValorDeducao = new BigDecimal("5000.00");
        final var expectedBaseCalculo = new BigDecimal("25000.00");
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'numeroCredito' cannot be null or empty";

        // when
        final var actualCredito = Credito.newCredito(
            expectedId,
            expectedNumeroCredito,
            expectedNumeroNfse,
            expectedDataConstituicao,
            expectedValorIssqn,
            expectedTipoCredito,
            expectedSimplesNacional,
            expectedAliquota,
            expectedValorFaturado,
            expectedValorDeducao,
            expectedBaseCalculo
        );

        final var actualException = assertThrows(
            DomainException.class,
            () -> actualCredito.validate(new ThrowsValidationHandler())
        );

        // then
        assertEquals(expectedErrorCount, actualException.getErrors().size());
        assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    void givenInvalidBlankNumeroCredito_whenCallNewCreditoAndValidate_thenShouldReceiveError() {
        // given
        final var expectedId = 1L;
        final var expectedNumeroCredito = "   ";
        final var expectedNumeroNfse = "7891011";
        final var expectedDataConstituicao = LocalDate.of(2024, 2, 25);
        final var expectedValorIssqn = new BigDecimal("1500.75");
        final var expectedTipoCredito = "ISSQN";
        final var expectedSimplesNacional = Boolean.TRUE;
        final var expectedAliquota = new BigDecimal("5.0");
        final var expectedValorFaturado = new BigDecimal("30000.00");
        final var expectedValorDeducao = new BigDecimal("5000.00");
        final var expectedBaseCalculo = new BigDecimal("25000.00");
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'numeroCredito' cannot be null or empty";

        // when
        final var actualCredito = Credito.newCredito(
            expectedId,
            expectedNumeroCredito,
            expectedNumeroNfse,
            expectedDataConstituicao,
            expectedValorIssqn,
            expectedTipoCredito,
            expectedSimplesNacional,
            expectedAliquota,
            expectedValorFaturado,
            expectedValorDeducao,
            expectedBaseCalculo
        );

        final var actualException = assertThrows(
            DomainException.class,
            () -> actualCredito.validate(new ThrowsValidationHandler())
        );

        // then
        assertEquals(expectedErrorCount, actualException.getErrors().size());
        assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    void givenInvalidNullNumeroNfse_whenCallNewCreditoAndValidate_thenShouldReceiveError() {
        // given
        final var expectedId = 1L;
        final var expectedNumeroCredito = "123456";
        final String expectedNumeroNfse = null;
        final var expectedDataConstituicao = LocalDate.of(2024, 2, 25);
        final var expectedValorIssqn = new BigDecimal("1500.75");
        final var expectedTipoCredito = "ISSQN";
        final var expectedSimplesNacional = Boolean.TRUE;
        final var expectedAliquota = new BigDecimal("5.0");
        final var expectedValorFaturado = new BigDecimal("30000.00");
        final var expectedValorDeducao = new BigDecimal("5000.00");
        final var expectedBaseCalculo = new BigDecimal("25000.00");
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'numeroNfse' cannot be null or empty";

        // when
        final var actualCredito = Credito.newCredito(
            expectedId,
            expectedNumeroCredito,
            expectedNumeroNfse,
            expectedDataConstituicao,
            expectedValorIssqn,
            expectedTipoCredito,
            expectedSimplesNacional,
            expectedAliquota,
            expectedValorFaturado,
            expectedValorDeducao,
            expectedBaseCalculo
        );

        final var actualException = assertThrows(
            DomainException.class,
            () -> actualCredito.validate(new ThrowsValidationHandler())
        );

        // then
        assertEquals(expectedErrorCount, actualException.getErrors().size());
        assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    void givenInvalidBlankNumeroNfse_whenCallNewCreditoAndValidate_thenShouldReceiveError() {
        // given
        final var expectedId = 1L;
        final var expectedNumeroCredito = "123456";
        final var expectedNumeroNfse = "   ";
        final var expectedDataConstituicao = LocalDate.of(2024, 2, 25);
        final var expectedValorIssqn = new BigDecimal("1500.75");
        final var expectedTipoCredito = "ISSQN";
        final var expectedSimplesNacional = Boolean.TRUE;
        final var expectedAliquota = new BigDecimal("5.0");
        final var expectedValorFaturado = new BigDecimal("30000.00");
        final var expectedValorDeducao = new BigDecimal("5000.00");
        final var expectedBaseCalculo = new BigDecimal("25000.00");
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'numeroNfse' cannot be null or empty";

        // when
        final var actualCredito = Credito.newCredito(
            expectedId,
            expectedNumeroCredito,
            expectedNumeroNfse,
            expectedDataConstituicao,
            expectedValorIssqn,
            expectedTipoCredito,
            expectedSimplesNacional,
            expectedAliquota,
            expectedValorFaturado,
            expectedValorDeducao,
            expectedBaseCalculo
        );

        final var actualException = assertThrows(
            DomainException.class,
            () -> actualCredito.validate(new ThrowsValidationHandler())
        );

        // then
        assertEquals(expectedErrorCount, actualException.getErrors().size());
        assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    void givenInvalidNegativeValorIssqn_whenCallNewCreditoAndValidate_thenShouldReceiveError() {
        // given
        final var expectedId = 1L;
        final var expectedNumeroCredito = "123456";
        final var expectedNumeroNfse = "7891011";
        final var expectedDataConstituicao = LocalDate.of(2024, 2, 25);
        final var expectedValorIssqn = new BigDecimal("-1.00");
        final var expectedTipoCredito = "ISSQN";
        final var expectedSimplesNacional = Boolean.TRUE;
        final var expectedAliquota = new BigDecimal("5.0");
        final var expectedValorFaturado = new BigDecimal("30000.00");
        final var expectedValorDeducao = new BigDecimal("5000.00");
        final var expectedBaseCalculo = new BigDecimal("25000.00");
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'valorIssqn' must be >= 0";

        // when
        final var actualCredito = Credito.newCredito(
            expectedId,
            expectedNumeroCredito,
            expectedNumeroNfse,
            expectedDataConstituicao,
            expectedValorIssqn,
            expectedTipoCredito,
            expectedSimplesNacional,
            expectedAliquota,
            expectedValorFaturado,
            expectedValorDeducao,
            expectedBaseCalculo
        );

        final var actualException = assertThrows(
            DomainException.class,
            () -> actualCredito.validate(new ThrowsValidationHandler())
        );

        // then
        assertEquals(expectedErrorCount, actualException.getErrors().size());
        assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    void givenInvalidNegativeAliquota_whenCallNewCreditoAndValidate_thenShouldReceiveError() {
        // given
        final var expectedId = 1L;
        final var expectedNumeroCredito = "123456";
        final var expectedNumeroNfse = "7891011";
        final var expectedDataConstituicao = LocalDate.of(2024, 2, 25);
        final var expectedValorIssqn = new BigDecimal("1500.75");
        final var expectedTipoCredito = "ISSQN";
        final var expectedSimplesNacional = Boolean.TRUE;
        final var expectedAliquota = new BigDecimal("-1.0");
        final var expectedValorFaturado = new BigDecimal("30000.00");
        final var expectedValorDeducao = new BigDecimal("5000.00");
        final var expectedBaseCalculo = new BigDecimal("25000.00");
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'aliquota' must be >= 0";

        // when
        final var actualCredito = Credito.newCredito(
            expectedId,
            expectedNumeroCredito,
            expectedNumeroNfse,
            expectedDataConstituicao,
            expectedValorIssqn,
            expectedTipoCredito,
            expectedSimplesNacional,
            expectedAliquota,
            expectedValorFaturado,
            expectedValorDeducao,
            expectedBaseCalculo
        );

        final var actualException = assertThrows(
            DomainException.class,
            () -> actualCredito.validate(new ThrowsValidationHandler())
        );

        // then
        assertEquals(expectedErrorCount, actualException.getErrors().size());
        assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    void givenInvalidNegativeBaseCalculo_whenCallNewCreditoAndValidate_thenShouldReceiveError() {
        // given
        final var expectedId = 1L;
        final var expectedNumeroCredito = "123456";
        final var expectedNumeroNfse = "7891011";
        final var expectedDataConstituicao = LocalDate.of(2024, 2, 25);
        final var expectedValorIssqn = new BigDecimal("1500.75");
        final var expectedTipoCredito = "ISSQN";
        final var expectedSimplesNacional = Boolean.TRUE;
        final var expectedAliquota = new BigDecimal("5.0");
        final var expectedValorFaturado = new BigDecimal("30000.00");
        final var expectedValorDeducao = new BigDecimal("5000.00");
        final var expectedBaseCalculo = new BigDecimal("-1.00");
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'baseCalculo' must be >= 0";

        // when
        final var actualCredito = Credito.newCredito(
            expectedId,
            expectedNumeroCredito,
            expectedNumeroNfse,
            expectedDataConstituicao,
            expectedValorIssqn,
            expectedTipoCredito,
            expectedSimplesNacional,
            expectedAliquota,
            expectedValorFaturado,
            expectedValorDeducao,
            expectedBaseCalculo
        );

        final var actualException = assertThrows(
            DomainException.class,
            () -> actualCredito.validate(new ThrowsValidationHandler())
        );

        // then
        assertEquals(expectedErrorCount, actualException.getErrors().size());
        assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    void givenValidCredito_whenCallValidate_thenShouldNotReturnErrors() {
        // given
        final var expectedId = 1L;
        final var expectedNumeroCredito = "123456";
        final var expectedNumeroNfse = "7891011";
        final var expectedDataConstituicao = LocalDate.of(2024, 2, 25);
        final var expectedValorIssqn = new BigDecimal("1500.75");
        final var expectedTipoCredito = "ISSQN";
        final var expectedSimplesNacional = Boolean.TRUE;
        final var expectedAliquota = new BigDecimal("5.0");
        final var expectedValorFaturado = new BigDecimal("30000.00");
        final var expectedValorDeducao = new BigDecimal("5000.00");
        final var expectedBaseCalculo = new BigDecimal("25000.00");

        final var actualCredito = Credito.newCredito(
            expectedId,
            expectedNumeroCredito,
            expectedNumeroNfse,
            expectedDataConstituicao,
            expectedValorIssqn,
            expectedTipoCredito,
            expectedSimplesNacional,
            expectedAliquota,
            expectedValorFaturado,
            expectedValorDeducao,
            expectedBaseCalculo
        );

        // when / then
        assertDoesNotThrow(() -> actualCredito.validate(new ThrowsValidationHandler()));
    }

    @Test
    void givenValidCredito_whenCallUpdate_thenReturnCreditoUpdated() {
        // given
        final var expectedId = 1L;
        final var originalNumeroCredito = "123456";
        final var originalNumeroNfse = "7891011";
        final var originalDataConstituicao = LocalDate.of(2024, 2, 25);
        final var originalValorIssqn = new BigDecimal("1500.75");
        final var originalTipoCredito = "ISSQN";
        final var originalSimplesNacional = Boolean.TRUE;
        final var originalAliquota = new BigDecimal("5.0");
        final var originalValorFaturado = new BigDecimal("30000.00");
        final var originalValorDeducao = new BigDecimal("5000.00");
        final var originalBaseCalculo = new BigDecimal("25000.00");

        final var expectedNumeroCredito = "654321";
        final var expectedNumeroNfse = "1122334";
        final var expectedDataConstituicao = LocalDate.of(2024, 3, 1);
        final var expectedValorIssqn = new BigDecimal("2000.00");
        final var expectedTipoCredito = "OUTROS";
        final var expectedSimplesNacional = Boolean.FALSE;
        final var expectedAliquota = new BigDecimal("4.5");
        final var expectedValorFaturado = new BigDecimal("28000.00");
        final var expectedValorDeducao = new BigDecimal("3000.00");
        final var expectedBaseCalculo = new BigDecimal("25000.00");

        final var aCredito = Credito.newCredito(
            expectedId,
            originalNumeroCredito,
            originalNumeroNfse,
            originalDataConstituicao,
            originalValorIssqn,
            originalTipoCredito,
            originalSimplesNacional,
            originalAliquota,
            originalValorFaturado,
            originalValorDeducao,
            originalBaseCalculo
        );

        assertDoesNotThrow(() -> aCredito.validate(new ThrowsValidationHandler()));

        final var createdAt = aCredito.getCreatedAt();
        final var updatedAt = aCredito.getUpdatedAt();

        // when
        final var actualCredito = aCredito.update(
            expectedNumeroCredito,
            expectedNumeroNfse,
            expectedDataConstituicao,
            expectedValorIssqn,
            expectedTipoCredito,
            expectedSimplesNacional,
            expectedAliquota,
            expectedValorFaturado,
            expectedValorDeducao,
            expectedBaseCalculo
        );

        // then
        assertDoesNotThrow(() -> actualCredito.validate(new ThrowsValidationHandler()));

        assertEquals(aCredito.getId(), actualCredito.getId());
        assertEquals(expectedNumeroCredito, actualCredito.getNumeroCredito());
        assertEquals(expectedNumeroNfse, actualCredito.getNumeroNfse());
        assertEquals(expectedDataConstituicao, actualCredito.getDataConstituicao());
        assertEquals(expectedValorIssqn, actualCredito.getValorIssqn());
        assertEquals(expectedTipoCredito, actualCredito.getTipoCredito());
        assertEquals(expectedSimplesNacional, actualCredito.isSimplesNacional());
        assertEquals(expectedAliquota, actualCredito.getAliquota());
        assertEquals(expectedValorFaturado, actualCredito.getValorFaturado());
        assertEquals(expectedValorDeducao, actualCredito.getValorDeducao());
        assertEquals(expectedBaseCalculo, actualCredito.getBaseCalculo());
        assertEquals(createdAt, actualCredito.getCreatedAt());
    }

    @Test
    void givenValidParams_whenCallWith_thenInstantiateCreditoWithGivenValues() {
        // given
        final var expectedId = CreditoID.from(99L);
        final var expectedNumeroCredito = "999999";
        final var expectedNumeroNfse = "8888888";
        final var expectedDataConstituicao = LocalDate.of(2024, 1, 1);
        final var expectedValorIssqn = new BigDecimal("1000.00");
        final var expectedTipoCredito = "ISSQN";
        final var expectedSimplesNacional = Boolean.FALSE;
        final var expectedAliquota = new BigDecimal("3.5");
        final var expectedValorFaturado = new BigDecimal("20000.00");
        final var expectedValorDeducao = new BigDecimal("2000.00");
        final var expectedBaseCalculo = new BigDecimal("18000.00");
        final var expectedCreatedAt = Instant.parse("2024-01-10T10:15:30.00Z");
        final var expectedUpdatedAt = Instant.parse("2024-01-11T11:20:35.00Z");

        // when
        final var actualCredito = Credito.with(
            expectedId,
            expectedNumeroCredito,
            expectedNumeroNfse,
            expectedDataConstituicao,
            expectedValorIssqn,
            expectedTipoCredito,
            expectedSimplesNacional,
            expectedAliquota,
            expectedValorFaturado,
            expectedValorDeducao,
            expectedBaseCalculo,
            expectedCreatedAt,
            expectedUpdatedAt
        );

        // then
        assertNotNull(actualCredito);
        assertEquals(expectedId, actualCredito.getId());
        assertEquals(expectedNumeroCredito, actualCredito.getNumeroCredito());
        assertEquals(expectedNumeroNfse, actualCredito.getNumeroNfse());
        assertEquals(expectedDataConstituicao, actualCredito.getDataConstituicao());
        assertEquals(expectedValorIssqn, actualCredito.getValorIssqn());
        assertEquals(expectedTipoCredito, actualCredito.getTipoCredito());
        assertEquals(expectedSimplesNacional, actualCredito.isSimplesNacional());
        assertEquals(expectedAliquota, actualCredito.getAliquota());
        assertEquals(expectedValorFaturado, actualCredito.getValorFaturado());
        assertEquals(expectedValorDeducao, actualCredito.getValorDeducao());
        assertEquals(expectedBaseCalculo, actualCredito.getBaseCalculo());
        assertEquals(expectedCreatedAt, actualCredito.getCreatedAt());
        assertEquals(expectedUpdatedAt, actualCredito.getUpdatedAt());
    }
}
