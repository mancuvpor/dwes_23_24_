package velazquez.examenreservas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/ReservaConfirmadaServlet")
public class ServletReservaConfirmada extends HttpServlet {

    // Declaración del logger (registrador) utilizando la biblioteca SLF4J
    static final Logger log = LoggerFactory.getLogger(ServletReservaConfirmada.class);

    public void init() {
    }

    // Método doGet que maneja las peticiones HTTP GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando Get");

        // Obtiene la sesión actual o crea una nueva si no existe
        HttpSession session = req.getSession();

        // Verifica la autenticación del usuario y si hay una sesión existente
        if (!session.isNew()) {
            // Si está autenticado, registra la información de la reserva y redirige a la página de reserva
            log.info(session.getAttribute("reservaBean").toString());
            req.getRequestDispatcher("/WEB-INF/view/reservar.jsp").forward(req, resp);
        } else {
            // Si no está autenticado o no hay una sesión existente, registra un error, invalida la sesión y redirige al contexto de la aplicación
            log.error("No se ha recibido la sesión adecuada");
            session.invalidate();
            resp.sendRedirect(req.getContextPath());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
