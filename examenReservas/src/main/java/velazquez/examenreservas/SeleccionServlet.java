package velazquez.examenreservas;

import Model.ReservaBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet("/SeleccionServlet")
public class SeleccionServlet extends HttpServlet {

    static final Logger log = LoggerFactory.getLogger(SeleccionServlet.class);
//    private static final String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
//    private static final Pattern PASSWORD_PATTERN = Pattern.compile(regexPattern);

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("Realizando Get");
        HttpSession session = request.getSession();
        // Verifica la sesión y redirige según la autenticación
        if (!session.isNew()) {
            // Si está autenticado, redirige a la página de formulario
            request.getRequestDispatcher("/WEB-INF/view/formulario.jsp").forward(request, response);
        } else {
            // Si no está autenticado, invalida la sesión y redirige al contexto de la aplicación
            log.error("No se ha recibido la sesión adecuada");
            session.invalidate();
            response.sendRedirect(request.getContextPath());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (!session.isNew()) {
            log.info("Realizando Post");
            // Obtiene parámetros del formulario
            Enumeration<String> parametros = req.getParameterNames();
            while (parametros.hasMoreElements()) {
                String param = parametros.nextElement();
                log.info(param + ": " + req.getParameter(param));
            }
            String[] seleccion = req.getParameterValues("servicios");
            log.info("El valor de Servicio es: " + Arrays.toString(seleccion));

            // Validación de datos
            if (seleccion == null) {
                String mensajeError = "Se deben de rellenar todos los campos";
                log.error(mensajeError);
                session.setAttribute("error", mensajeError);
                resp.sendRedirect(req.getContextPath() + "/SeleccionServlet");
                return;
            }

            // Creación de un objeto ReservaBean con la información proporcionada
            ReservaBean reserva = new ReservaBean();
            reserva.setFecha_inicio(req.getParameter("fecha_inicio"));
            reserva.setFecha_fin(req.getParameter("fecha_fin"));
            reserva.setN_personas(Integer.parseInt(req.getParameter("n_personas")));
            List<String> servicios = Arrays.asList(seleccion);
            reserva.setServicios(servicios);

            log.info(reserva.toString());

            // Guarda el objeto en la sesión y redirige a /ReservaConfirmadaServlet
            session.setAttribute("reservaBean", reserva);

            resp.sendRedirect(req.getContextPath() + "/ReservaConfirmadaServlet");
        } else {
            // Si no está autenticado, invalida la sesión y redirige al contexto de la aplicación
            log.error("No se ha recibido la sesión adecuada");
            session.invalidate();
            resp.sendRedirect(req.getContextPath());
        }

    }

    public void destroy() {
    }
}
