package io.github.credit.insight.api.infrastructure.credito;

import io.github.credit.insight.api.GatewayTest;
import io.github.credit.insight.api.domain.credito.Credito;
import io.github.credit.insight.api.domain.credito.CreditoGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@GatewayTest
class CreditoGatewayImplTest {

    @Autowired
    private CreditoGateway creditoGateway;

    @Autowired
    private CreditoJpaRepository creditoJpaRepository;

    @Test
    void givenPrePersistedCreditosAndValidNumeroNfse_whenCallsFindByNumeroNfse_shouldReturnMappedList() {
        // given
        final var expectedNumeroNfse = "7891011";

        final var credito1 = newCredito(
            "123456",
            expectedNumeroNfse,
            LocalDate.of(2024, 2, 25),
            "1500.75",
            "ISSQN",
            true,
            "5.00",
            "30000.00",
            "5000.00",
            "25000.00"
        );

        final var credito2 = newCredito(
            "789012",
            expectedNumeroNfse,
            LocalDate.of(2024, 2, 26),
            "1200.50",
            "ISSQN",
            false,
            "4.50",
            "25000.00",
            "4000.00",
            "21000.00"
        );

        final var credito3 = newCredito(
            "654321",
            "1122334",
            LocalDate.of(2024, 1, 15),
            "800.50",
            "OUTROS",
            true,
            "3.50",
            "20000.00",
            "3000.00",
            "17000.00"
        );

        assertEquals(0, creditoJpaRepository.count());

        creditoJpaRepository.saveAllAndFlush(List.of(credito1, credito2, credito3));

        assertEquals(3, creditoJpaRepository.count());

        // when
        final var actualResult = creditoGateway.findByNumeroNfse(expectedNumeroNfse);

        // then
        assertNotNull(actualResult);
        assertEquals(2, actualResult.size());

        final var numerosCredito = actualResult.stream()
            .map(Credito::getNumeroCredito)
            .toList();

        assertAll(
            () -> assertTrue(numerosCredito.contains("123456")),
            () -> assertTrue(numerosCredito.contains("789012")),
            () -> actualResult.forEach(credito ->
                assertEquals(expectedNumeroNfse, credito.getNumeroNfse())
            )
        );
    }

    @Test
    void givenNoCreditosPersistedForNumeroNfse_whenCallsFindByNumeroNfse_shouldReturnEmptyList() {
        // given
        final var expectedNumeroNfse = "NFSE-NAO-EXISTE";

        assertEquals(0, creditoJpaRepository.count());

        // when
        final var actualResult = creditoGateway.findByNumeroNfse(expectedNumeroNfse);

        // then
        assertAll(
            () -> assertNotNull(actualResult),
            () -> assertTrue(actualResult.isEmpty())
        );
    }

    @Test
    void givenPrePersistedCreditoAndValidNumeroCredito_whenCallsFindByNumeroCredito_shouldReturnCreditoMapped() {
        // given
        final var expectedNumeroCredito = "CRED-001";
        final var expectedNumeroNfse = "NFSE-123";
        final var expectedDataConstituicao = LocalDate.of(2024, 3, 10);
        final var expectedValorIssqn = new BigDecimal("999.99");
        final var expectedTipoCredito = "ISSQN";
        final var expectedSimplesNacional = true;
        final var expectedAliquota = new BigDecimal("3.00");
        final var expectedValorFaturado = new BigDecimal("15000.00");
        final var expectedValorDeducao = new BigDecimal("1000.00");
        final var expectedBaseCalculo = new BigDecimal("14000.00");

        final var entity = newCredito(
            expectedNumeroCredito,
            expectedNumeroNfse,
            expectedDataConstituicao,
            expectedValorIssqn.toString(),
            expectedTipoCredito,
            expectedSimplesNacional,
            expectedAliquota.toString(),
            expectedValorFaturado.toString(),
            expectedValorDeducao.toString(),
            expectedBaseCalculo.toString()
        );

        assertEquals(0, creditoJpaRepository.count());

        final var savedEntity = creditoJpaRepository.saveAndFlush(entity);

        assertAll(
            () -> assertEquals(1, creditoJpaRepository.count()),
            () -> assertNotNull(savedEntity.getId())
        );

        // when
        final var actualResult = creditoGateway.findByNumeroCredito(expectedNumeroCredito);

        // then
        assertTrue(actualResult.isPresent());

        final var actualCredito = actualResult.get();

        assertAll(
            () -> assertEquals(expectedNumeroCredito, actualCredito.getNumeroCredito()),
            () -> assertEquals(expectedNumeroNfse, actualCredito.getNumeroNfse()),
            () -> assertEquals(expectedDataConstituicao, actualCredito.getDataConstituicao()),
            () -> assertEquals(expectedValorIssqn, actualCredito.getValorIssqn()),
            () -> assertEquals(expectedTipoCredito, actualCredito.getTipoCredito()),
            () -> assertEquals(expectedSimplesNacional, actualCredito.isSimplesNacional()),
            () -> assertEquals(expectedAliquota, actualCredito.getAliquota()),
            () -> assertEquals(expectedValorFaturado, actualCredito.getValorFaturado()),
            () -> assertEquals(expectedValorDeducao, actualCredito.getValorDeducao()),
            () -> assertEquals(expectedBaseCalculo, actualCredito.getBaseCalculo())
        );
    }

    @Test
    void givenNoCreditoPersistedForNumeroCredito_whenCallsFindByNumeroCredito_shouldReturnEmptyOptional() {
        // given
        final var expectedNumeroCredito = "CRED-NAO-EXISTE";

        assertEquals(0, creditoJpaRepository.count());

        // when
        final var actualResult = creditoGateway.findByNumeroCredito(expectedNumeroCredito);

        // then
        assertAll(
            () -> assertNotNull(actualResult),
            () -> assertTrue(actualResult.isEmpty())
        );
    }

    private CreditoJpaEntity newCredito(
        final String numeroCredito,
        final String numeroNfse,
        final LocalDate dataConstituicao,
        final String valorIssqn,
        final String tipoCredito,
        final Boolean simplesNacional,
        final String aliquota,
        final String valorFaturado,
        final String valorDeducao,
        final String baseCalculo
    ) {
        final var entity = new CreditoJpaEntity();
        entity.setNumeroCredito(numeroCredito);
        entity.setNumeroNfse(numeroNfse);
        entity.setDataConstituicao(dataConstituicao);
        entity.setValorIssqn(new BigDecimal(valorIssqn));
        entity.setTipoCredito(tipoCredito);
        entity.setSimplesNacional(simplesNacional);
        entity.setAliquota(new BigDecimal(aliquota));
        entity.setValorFaturado(new BigDecimal(valorFaturado));
        entity.setValorDeducao(new BigDecimal(valorDeducao));
        entity.setBaseCalculo(new BigDecimal(baseCalculo));
        return entity;
    }
}
