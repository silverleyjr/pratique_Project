// esta classe sera responsavel pela escrita dos dados no arquivo Evento.data

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Dados {
	public static void guardarTodosEventos() {
		ArrayList<Evento> ListaDeEventos = new ArrayList<Evento>(TesteCompleto.getEventosLista());
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter("Events.data.txt"));
			int i = 0;
			escritor.write("Nome         | Data       | horario    | cidade         | Descrição          |");
			while (i < ListaDeEventos.size()) {
				escritor.write(ListaDeEventos.get(i).toString());
				i++;
			}
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void guardarTodosUsuarios() {
		ArrayList<Usuario> ListaDeUsuarios = new ArrayList<Usuario>(TesteCompleto.getUsuariosLista());
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter("TodosUsuarios.data.txt"));
			int i = 0;
			escritor.write("Login    | Nome       | email    | cidade    |");
			while (i < ListaDeUsuarios.size()) {
				escritor.write(ListaDeUsuarios.get(i).toString());
				i++;
			}
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void guardarTodosEventosUsuarios() {
		ArrayList<EventoUsuario> ListaDeEventosUsuarios = new ArrayList<EventoUsuario>(
				EventoUsuario.getEventosUsuariosLista());
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter("TodosEventosUsuarios.data.txt"));
			int i = 0;
			escritor.write("Evento    | participante    |");
			while (i < ListaDeEventosUsuarios.size()) {
				escritor.write(ListaDeEventosUsuarios.get(i).toString());
				i++;
			}
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Usuario> lerUsuarios() {
		ArrayList<Usuario> ListaUsuariosLido = new ArrayList<Usuario>();
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("TodosUsuarios.data.txt"));
			leitor.readLine();
			String linha;
			while ((linha = leitor.readLine()) != null) {
				String[] partes = linha.split("\\|");
				if (partes.length >= 4) {
					String login = partes[0].trim();
					String nome = partes[1].trim();
					String email = partes[2].trim();
					String cidade = partes[3].trim();
					Usuario usuarioLido = new Usuario(nome, email, cidade, login);
					ListaUsuariosLido.add(usuarioLido);
				}
			}
			leitor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ListaUsuariosLido;
	}

	public static ArrayList<Evento> lerEventos() {
		ArrayList<Evento> ListaEventosLido = new ArrayList<Evento>();
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("Events.data.txt"));
			leitor.readLine();
			String linha;
			while ((linha = leitor.readLine()) != null) {
				String[] partes = linha.split("\\|");
				if (partes.length >= 5) {
					String nome = partes[0].trim();
					String data = partes[1].trim();
					String horario = partes[2].trim();
					String cidade = partes[3].trim();
					String descricao = partes[4].trim();
					Evento EventoLido = new Evento(nome, data, horario, cidade, descricao);
					ListaEventosLido.add(EventoLido);
				}
			}
			leitor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ListaEventosLido;
	}

	public static ArrayList<EventoUsuario> lerEventosUsuarios() {
		ArrayList<EventoUsuario> ListaEventosUsuariosLido = new ArrayList<EventoUsuario>();
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("TodosEventosUsuarios.data.txt"));
			leitor.readLine();
			String linha;
			while ((linha = leitor.readLine()) != null) {
				String[] partes = linha.split("\\|");
				if (partes.length >= 2) {
					String evento = partes[0].trim();
					String usuario = partes[1].trim();
					EventoUsuario EventoUsuarioLido = new EventoUsuario(usuario, evento);
					ListaEventosUsuariosLido.add(EventoUsuarioLido);
				}
			}
			leitor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ListaEventosUsuariosLido;
	}
}
