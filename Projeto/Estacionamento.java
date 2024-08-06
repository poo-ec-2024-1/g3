import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<Ticket> tickets;
    private CalculadoraTarifa calculadoraTarifa;
    //Matriz de vagas, que representa cada vaga do estacionamento, sendo previamente inicializada como falso.
    public Estacionamento(int numeroDeVagas) {
        vagas = new ArrayList<>();
        for (int i = 1; i <= numeroDeVagas; i++) {
            vagas.add(new Vaga(i, false));
        }
        tickets = new ArrayList<>();
        calculadoraTarifa = new CalculadoraTarifa();
    }
    //Ticket de preço/tarifa.
    public Ticket estacionarVeiculo(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (!vaga.isOcupada()) {
                vaga.ocupar();
                Ticket ticket = new Ticket(veiculo, vaga, LocalDateTime.now());
                tickets.add(ticket);
                return ticket;
            }
        }
        return null; // Sem vagas disponíveis
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

    public Ticket getTicketPorPlaca(String placa) {
        for (Ticket ticket : tickets) {
            if (ticket.getVeiculo().getPlaca().equals(placa) && ticket.getHoraSaida() == null) {
                return ticket;
            }
        }
        return null;
    }
}
