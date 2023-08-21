package contrellers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.Cliente;

@WebServlet("/CreateAndFind")
public class ClienteCreateAndFind extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public ClienteCreateAndFind() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// captura o que foi mandado no campo de pesquisa
		String pesquisa = request.getParameter( "pesquisa" );
		
		// se for null coloca "" para evitar erro
		if (pesquisa == null) {
			pesquisa = "";
		}
		
		// lista os clientes existentes de acordo com a pesquisa
		List<Cliente> clientes = ClienteDao.find(pesquisa);
		
		// Passa a lista para o arquivo .jsp com o nome escolhido
		request.setAttribute("clientes" , clientes);
		//
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("lista.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instancia um novo cliente com seus dados
		Cliente cliente = new Cliente();
		
		cliente.setNome( request.getParameter("nome") );
		cliente.setCpf( request.getParameter("cpf") );
		cliente.setNascimento( request.getParameter("nascimento") );
		cliente.setSituacao( request.getParameter("situacao") );
		
		// Coloca o cliente criado no BD
		ClienteDao.create(cliente);
		
		// Toda vez que um cliente for cadastrado, mostra a lista de cadastrados
		doGet(request, response);
	}

}
