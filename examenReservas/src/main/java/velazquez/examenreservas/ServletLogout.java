package velazquez.examenreservas;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/ServletLogout")
public class ServletLogout extends HttpServlet {
    // Declaración del logger (registrador) utilizando la biblioteca SLF4J
    static final Logger log = LoggerFactory.getLogger(velazquez.examenreservas.SeleccionServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        // Registra un mensaje en el registro (log) indicando que se está cerrando la sesión
        log.info("Cerrando sesión");
        // Invalida la sesión actual, lo que elimina la información de la sesión
        session.invalidate();
        // Redirige al contexto de la aplicación, generalmente la página de inicio
        response.sendRedirect(request.getContextPath());
    }

}
