package Objeto.Hotel;

import java.util.*;

public class Menu {
    
    public static Scanner scan = new Scanner(System.in);
    public static List<Quarto> listaQuartos = new ArrayList<>();
    public static List<Reserva> listaReservas = new ArrayList<>();
    public static List<Reserva> historicoReservas = new ArrayList<>();

    public static void main(String[] args) {
        inicializaDadosDeTeste();
        boolean menuAtivo = true;

        while (menuAtivo) {
            System.out.println("Escolha uma das opções:\n");
            System.out.println("1 Cadastrar quarto\n2 Listar Quartos\n3 Fazer reserva\n4 Fazer check-out\n5 Histórico de reservas\n6 Quartos ocupados\n7 Sair");
            int opcao = scan.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    cadastrarQuarto();
                    break;
                case 2:
                    listarQuartos();
                    break;
                case 3:
                    checkIn();
                    break;
                case 4:
                    checkOut();
                    break;
                case 5:
                    mostrarHistoricoReservas();
                    break;
                case 6:
                    mostrarQuartosOcupados();
                    break;
                case 7:
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void cadastrarQuarto() {
        Quarto quarto = new Quarto(0, null, 0, true);
        
        scan.nextLine();
        System.out.println("Número do quarto:");
        quarto.setNumero(scan.nextInt());
        scan.nextLine();
        System.out.println("Tipo do quarto:");
        quarto.setTipo(scan.nextLine());
        System.out.println("Preço do quarto:");
        quarto.setPreco(scan.nextDouble());
        
        listaQuartos.add(quarto);
        System.out.println("Quarto cadastrado com sucesso!");
    }

    public static void listarQuartos() {
        if (listaQuartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
        } else {
            for (Quarto quarto : listaQuartos) {
                System.out.println(quarto);
            }
        }
    }

    public static void checkIn() {
        scan.nextLine();
        
        System.out.println("Número do quarto:");
        int numeroQuarto = scan.nextInt();
        scan.nextLine();
        
        for (Quarto quarto : listaQuartos) {
            if (quarto.getNumero() == numeroQuarto && quarto.isDisponivel()) {
                Reserva reserva = new Reserva(null, null, null, null);
                System.out.println("Nome do hóspede:");
                reserva.setHospede(scan.nextLine());
                System.out.println("Data de check-in:");
                reserva.setCheckIn(scan.nextLine());
                System.out.println("Data de check-out:");
                reserva.setCheckOut(scan.nextLine());
                reserva.setTipoQuarto(quarto.getTipo());
                
                quarto.setDisponivel(false);
                listaReservas.add(reserva);
                historicoReservas.add(reserva);
                System.out.println("Check-in realizado com sucesso!");
                return;
            }
        }
        System.out.println("Quarto indisponível.");
    }

    public static void checkOut() {
        scan.nextLine();
        
        System.out.println("Nome do hóspede:");
        String nomeHospede = scan.nextLine();
        
        boolean encontrouReserva = false;
        
        for (Reserva reserva : listaReservas) {
            if (reserva.getHospede().equalsIgnoreCase(nomeHospede)) {
                listaReservas.remove(reserva);
                encontrouReserva = true;

                for (Quarto quarto : listaQuartos) {
                    if (quarto.getTipo().equals(reserva.getTipoQuarto())) {
                        quarto.setDisponivel(true);
                        System.out.println("Check-out realizado com sucesso!");
                        return;
                    }
                }
            }
        }
        if (!encontrouReserva) {
            System.out.println("Hóspede não encontrado.");
        }
    }

    public static void mostrarHistoricoReservas() {
        if (historicoReservas.isEmpty()) {
            System.out.println("Nenhuma reserva no histórico.");
        } else {
            for (Reserva reserva : historicoReservas) {
                System.out.println(reserva);
            }
        }
    }

    public static void mostrarQuartosOcupados() {
        for (Reserva reserva : listaReservas) {
            System.out.println("Hóspede " + reserva.getHospede() + " Tipo de Quarto: " + reserva.getTipoQuarto() + " Check-in: " + reserva.getCheckIn() + " Check-out: " + reserva.getCheckOut());
        }
    }

    public static void inicializaDadosDeTeste() {
        Quarto quarto1 = new Quarto(101, "Solteiro", 150, true);
        listaQuartos.add(quarto1);
        Quarto quarto2 = new Quarto(102, "Casal", 210, true);
        listaQuartos.add(quarto2);
    }
}
