import java.time.Duration;
import java.time.LocalDateTime;

public class CalculadoraTarifa {
    public double calcularTarifa(Veiculo veiculo, LocalDateTime horaEntrada, LocalDateTime horaSaida) {
        Duration duracao = Duration.between(horaEntrada, horaSaida);
        long minutos = duracao.toMinutes();
        return minutos * veiculo.getTarifaPorMinuto();
    }
}
