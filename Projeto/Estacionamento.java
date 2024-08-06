import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<Ticket> tickets;
    private CalculadoraTarifa calculadoraTarifa;
    //Array list que gera as vagas do estacionamento com valores de ocupado, previamente falsos.
    public Estacionamento(int numeroDeVagas) {
        vagas = new ArrayList<>();
        for (int i = 1; i <= numeroDeVagas; i++) {
            vagas.add(new Vaga(i, false));
        }
        tickets = new ArrayList<>();
        calculadoraTarifa = new CalculadoraTarifa();
    }

    public Ticket estacionarVeiculo(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (!vaga.isOcupada()) {
                vaga.ocupar();
                Ticket ticket = new Ticket(veiculo, vaga, LocalDateTime.now());
                tickets.add(ticket);
                return ticket;
            }
        }
        return null; // Sem vagas disponiveis
    }

    public double retirarVeiculo(Ticket ticket) {
        ticket.getVaga().desocupar();
        ticket.setHoraSaida(LocalDateTime.now());
        return calculadoraTarifa.calcularTarifa(ticket.getVeiculo(), ticket.getHoraEntrada(), ticket.getHoraSaida());
    }

    public List<Vaga> getVagasDisponiveis() {
        List<Vaga> vagasDisponiveis = new ArrayList<>();
        for (Vaga vaga : vagas) {
            if (!vaga.isOcupada()) {
                vagasDisponiveis.add(vaga);
            }
        }
        return vagasDisponiveis;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
