// Esse é o exercicio pratique do segundo trimestre
// Feito por Silverley

import java.util.ArrayList;
import java.util.Scanner;

public class TesteCompleto {
	public static ArrayList<Usuario> UsuariosLista = new ArrayList<Usuario>(Dados.lerUsuarios());
	public static ArrayList<Evento> EventosLista = new ArrayList<Evento>(Dados.lerEventos());
	public static Scanner entrada = new Scanner(System.in).useDelimiter("\n");

	public static void main(String args[]) {
		Usuario usuarioAtivo = null;
		while (usuarioAtivo == null) {
			System.out.println("\nola gostaria de entrar ou cadastrar ?");
			String EntrarOuCadastrar = entrada.next();
			switch (EntrarOuCadastrar) {
				case "entrar":
					usuarioAtivo = Entrar(entrada);
					break;

				case "cadastrar":
					usuarioAtivo = Cadastrar(entrada);
					break;
				default:
					System.out.println("\npor favor digite 'entrar' ou 'cadastrar'");
			}
		}

		boolean loopVerCadastrar = false;
		while (!loopVerCadastrar) {
			System.out.println("\nola gostaria de ver eventos ou gostaria de cadastrar eventos ?");
			String verCadastrar = entrada.next();
			switch (verCadastrar) {
				case "ver eventos":
					loopVerCadastrar = VerEventos(entrada);
					break;
				case "cadastrar eventos":
					loopVerCadastrar = CadastrarEvento(entrada);
					break;
				default:
					System.out.println("\nresponda apenas 'ver eventos' ou 'cadastrar eventos'");
			}
		}

		boolean loopAgendar = false;
		System.out.println("\ngostaria de participar de algum evento ?");
		while (!loopAgendar) {
			String participar = entrada.next();
			switch (participar) {
				case "sim":
					loopAgendar = AgendarParticipacao(usuarioAtivo);
				case "nao":
					System.out.println("ok");
					loopAgendar = true;
					break;
				default:
					System.out.println(
							"gostaria de participar de algum evento responda apenas 'sim' ou 'nao'");
			}
		}

		boolean sair = false;
		while (!sair) {
			System.out.println("\ngostaria de ver os eventos agendados ou gostaria de sair ?");
			String Consultar = entrada.next();
			switch (Consultar) {
				case "ver eventos":
					EventoUsuario.participacoes(usuarioAtivo);
					sair = true;
					break;
				case "sair":
					System.out.println("ok programa concluido muito obrigado volte sempre");
					sair = true;
					break;
				default:
					System.out.println("por favor escolha entre 'sair' ou 'ver eventos'");
			}
		}
		entrada.close();

	}

	public static Usuario Entrar(Scanner entrada) {
		while (true) {
			System.out.println("\nQual é seu nome de usuario :");
			String nomeUsuario = entrada.next();
			System.out.println("\nQual é seu email :");
			String emailEntrar = entrada.next();
			for (Usuario usuario : UsuariosLista) {
			//	System.out.println("|" + nomeUsuario + "|"
			//			+ usuario.getLogin()
			//			+ "|");
			//	System.out.println("|" + emailEntrar + "|"
			//			+ usuario.getEmail()
			//			+ "|");
				boolean verdadeiroLogin = nomeUsuario.trim().equals(usuario.getLogin());
				boolean verdadeiroEmail = emailEntrar.trim().equals(usuario.getEmail());
				if (verdadeiroLogin && verdadeiroEmail) {
					System.out.print("seja bem vindo " + nomeUsuario + "\n");
					return usuario;
				}
			}
		}
	}

	public static Usuario Cadastrar(Scanner entrada) {
		System.out.println("\nseu nome de usuario");
		String loginUnico = entrada.next();
		System.out.println("\nnome:");
		String nomeCadastrar = entrada.next();
		System.out.println("\ncidade:");
		String cidadeCadastrar = entrada.next();
		System.out.println("\nemail:");
		String emailCadastrar = entrada.next();
		Usuario usuarioSeraCadastrado = new Usuario(nomeCadastrar, emailCadastrar,
				cidadeCadastrar, loginUnico);
		UsuariosLista.add(usuarioSeraCadastrado);
		Dados.guardarTodosUsuarios();
		System.out.println(
				"indice do usuario cadastrado "
						+ UsuariosLista.indexOf(usuarioSeraCadastrado));
		System.out.printf(
				"to string do usuario cadastrado faz \nLogin    | Nome       | email    | cidade    |"
						+ UsuariosLista.get(UsuariosLista
								.indexOf(usuarioSeraCadastrado))
								.toString());
		return usuarioSeraCadastrado;
	}

	public static boolean VerEventos(Scanner entrada) {
		int i = 1;
		for (Evento evento : EventosLista) {
			System.out.printf("Evento " + i + "" + evento.toString() + "\n");
			i++;
		}
		return true;
	}

	public static boolean CadastrarEvento(Scanner entrada) {
		System.out.println("\nnome do evento:");
		String nomeEvento = entrada.next();
		System.out.println("\ndescrição do evento:");
		String descricaoEvento = entrada.next();
		System.out.println("\ndata do evento:");
		String dataEvento = entrada.next();
		System.out.println("\nhorario do evento");
		String horarioEvento = entrada.next();
		System.out.println("\ncidade do evento:");
		String cidadeEvento = entrada.next();
		Evento eventoCadastrado = new Evento(nomeEvento, dataEvento, horarioEvento,
				cidadeEvento, descricaoEvento);
		EventosLista.add(eventoCadastrado);
		Dados.guardarTodosEventos();
		return false;
	}

	public static ArrayList<Usuario> getUsuariosLista() {
		return UsuariosLista;
	}

	public static ArrayList<Evento> getEventosLista() {
		return EventosLista;
	}

	public static boolean AgendarParticipacao(Usuario usuarioAtivo) {
		System.out.println("\nqual numero do evento que voce pretende ir ?");
		int qualEvento = entrada.nextInt();
		new EventoUsuario(usuarioAtivo,
				EventosLista.get(qualEvento - 1));
		Dados.guardarTodosEventosUsuarios();
		System.out.println("\ngostaria de participar de mais algum evento");
		return false;
	}
}
