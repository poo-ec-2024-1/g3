import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento(10); // 10 vagas
        CadastroUsuario cadastroUsuario = new CadastroUsuario("usuarios.dat");
        CadastroVeiculo cadastroVeiculo = new CadastroVeiculo("veiculos.dat");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            System.out.println("\n1. Estacionar Veiculo");
            System.out.println("2. Retirar Veiculo");
            System.out.println("3. Ver Vagas Disponiveis");
            System.out.println("4. Cadastrar Usuario");
            System.out.println("5. Cadastrar Veiculo");
            System.out.println("6. Sair");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("\nDigite a placa:");
                    String placa = scanner.next();
                    Veiculo veiculo = cadastroVeiculo.buscarVeiculoPorPlaca(placa);
                    if (veiculo == null) {
                        System.out.println("\nVeiculo nao encontrado. Cadastre o veiculo primeiro.");
                        break;
                    }
                    Ticket ticket = estacionamento.estacionarVeiculo(veiculo);
                    if (ticket != null) {
                        System.out.println("\nVeiculo estacionado na vaga " + ticket.getVaga().getNumero());
    
                    } else {
                        System.out.println("\nSem vagas disponiveis");
                    }
                    break;
                case 2:
                    System.out.println("\nDigite a placa:");
                    String placaRetirada = scanner.next();
                    Ticket ticketEncontrado = null;
                    for (Ticket t : estacionamento.getTickets()) {
                        if (t.getVeiculo().getPlaca().equals(placaRetirada) && t.getHoraSaida() == null) {
                            ticketEncontrado = t;
                            break;
                        }
                    }
                    if (ticketEncontrado != null) {
                        double tarifa = estacionamento.retirarVeiculo(ticketEncontrado);
                        System.out.println("\nVeiculo retirado. Tarifa total: R$" + tarifa);
                    } else {
                        System.out.println("\nVeiculo nao encontrado");
                    }
                    break;
                case 3:
                    System.out.println("Vagas disponiveis:");
                    for (Vaga vaga : estacionamento.getVagasDisponiveis()) {
                        System.out.println("Vaga " + vaga.getNumero());
                    }
                    break;
                case 4:
                    System.out.println("\nDigite o nome do usuario:");
                    String nome = scanner.next();
                    System.out.println("\nDigite o contato do usuario:");
                    String contato = scanner.next();
                    System.out.println("\nDigite a placa do veiculo do usuario:");
                    String placaUsuario = scanner.next();
                    Usuario novoUsuario = new Usuario(nome, contato);
                    cadastroUsuario.cadastrarUsuario(placaUsuario, novoUsuario);
                    System.out.println("\nUsuario cadastrado com sucesso.");
                    break;
                case 5:
                    System.out.println("\nDigite a placa:");
                    String placaVeiculo = scanner.next();
                    Usuario usuario = cadastroUsuario.buscarUsuarioPorPlaca(placaVeiculo);
                    if (usuario == null) {
                        System.out.println("\nUsuario nao encontrado. Cadastre o usuario primeiro.");
                        break;
                    }
                    System.out.println("\nDigite o tipo de veiculo (1 para Carro, 2 para Moto):");
                    int tipoVeiculo = scanner.nextInt();
                    System.out.println("\nDigite o modelo:");
                    String modelo = scanner.next();
                    System.out.println("\nDigite a cor:");
                    String cor = scanner.next();

                    Veiculo veiculoNovo;
                    if (tipoVeiculo == 1) {
                        veiculoNovo = new Carro(placaVeiculo, modelo, cor);
                    } else if (tipoVeiculo == 2) {
                        veiculoNovo = new Moto(placaVeiculo, modelo, cor);
                    } else {
                        System.out.println("\nTipo de veiculo invalido");
                        break;
                    }

                    cadastroVeiculo.cadastrarVeiculo(placaVeiculo, veiculoNovo);
                    System.out.println("\nVeiculo cadastrado com sucesso.");
                    break;
                case 6:
                    System.out.println("\nSaindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("\nEscolha invalida");
                    break;
            }
        }
    }
}
