package contrellers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;

@WebServlet("/ClienteDestroy")
public class ClienteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClienteDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int clienteId = Integer.parseInt(request.getParameter("clienteId"));
		ClienteDao.delete(clienteId);
		
		// volta para a lista de clientes
		ClienteCreateAndFind clienteCreateAndFind = new ClienteCreateAndFind();
		clienteCreateAndFind.doGet(request, response);
	}

}
