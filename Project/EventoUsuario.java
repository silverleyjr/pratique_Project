import java.util.ArrayList;
import java.util.Scanner;

public class EventoUsuario {
	public static ArrayList<EventoUsuario> EventosUsuariosLista = new ArrayList<EventoUsuario>(
			Dados.lerEventosUsuarios());
	Scanner entrada = new Scanner(System.in).useDelimiter("\n");
	String NomeDoParticipante;
	String NomeDoEventoParticipado;

	@Override
	public String toString() {
		return String.format(
				"\n%s | %s |", NomeDoEventoParticipado, NomeDoParticipante);
	}

	public EventoUsuario(Usuario usuarioParticipante, Evento eventoParticipado) {
		NomeDoParticipante = usuarioParticipante.getNome();
		NomeDoEventoParticipado = eventoParticipado.getNomeDeEvento();
		EventoUsuario eventoUsuarioAgendado = new EventoUsuario(NomeDoParticipante,
				NomeDoEventoParticipado);
		EventosUsuariosLista.add(eventoUsuarioAgendado);
	}

	public EventoUsuario(String usuario, String evento) {
		NomeDoParticipante = usuario;
		NomeDoEventoParticipado = evento;
	}

	public String getParticipantes() {
		return NomeDoParticipante;
	}

	public String getEventoParticipado() {
		return NomeDoEventoParticipado;
	}

	public static void participacoes(Usuario usuario) {
		System.out.println("Os eventos que você agendou a participação:");
		for (EventoUsuario UsuarioNoEvento : EventosUsuariosLista) {
			if (UsuarioNoEvento.getParticipantes().equals(usuario.getNome()))
				System.out.println("\n" + UsuarioNoEvento.getEventoParticipado());
		}
	}

	public static ArrayList<EventoUsuario> getEventosUsuariosLista() {
		return EventosUsuariosLista;
	}
}
