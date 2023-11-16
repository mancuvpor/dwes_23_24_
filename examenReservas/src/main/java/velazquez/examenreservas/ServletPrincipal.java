package velazquez.examenreservas;

import Model.LoginBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "ServletPrincipal")
public class ServletPrincipal extends HttpServlet {

    static final Logger log = LoggerFactory.getLogger(ServletPrincipal.class);
    private static final String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(regexPattern);

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Realizando Get");
        // Muestra la página principal con el botón de entrada
        request.getRequestDispatcher("/WEB-INF/view/botonEntrar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Ejecutando Post");
        log.info("VALOR DEL ATRIBUTO boton_entrar " + req.getParameter("boton_entrar"));
        // Verifica si el botón presionado es "Entrar"
        HttpSession session = req.getSession();
        if (req.getParameter("boton_entrar").equals("Entrar")) {

            String usuario = req.getParameter("Usuario");

            // Validación para el usuario
            if (usuario == null || usuario.length() < 3) {
                String mensajeError = "El usuario debe contener al menos 3 caracteres";
                log.error(mensajeError);
                session.setAttribute("error", mensajeError);
                resp.sendRedirect(req.getContextPath() + "/ServletPrincipal");
                return;
            }

            String password = req.getParameter("Password");
            String password2 = req.getParameter("Password2");

            // Validación para los passwords
            if (!(password.equals(password2))) {
                String mensajeError = "Los password deben de ser iguales";
                log.error(mensajeError);
                session.setAttribute("error", mensajeError);
                resp.sendRedirect(req.getContextPath() + "/ServletPrincipal");
                return;
            }

            String email = req.getParameter("Email");

            // Validación para el email
            if (!PASSWORD_PATTERN.matcher(email).matches()) {
                String mensajeError = "Email no válido";
                log.error(mensajeError);
                session.setAttribute("error", mensajeError);
                resp.sendRedirect(req.getContextPath() + "/ServletPrincipal");
                return;
            }

            // Creación de un objeto LoginBean con la información proporcionada
            LoginBean login = new LoginBean();
            login.setUsuario(req.getParameter("Usuario"));
            login.setPassword(req.getParameter("Password"));
            login.setPassword2(req.getParameter("Password2"));
            login.setEmail(req.getParameter("Email"));

            log.info(login.toString());

            session.setAttribute("loginBean", login);
            log.info("Log en la aplicación");
            session.setAttribute("error", "");
            resp.sendRedirect(req.getContextPath() + "/SeleccionServlet");
        } else {
            log.error("Se ha recibido un parámetro erróneo");
            session.invalidate();
            resp.sendRedirect(req.getContextPath() + "/ServletPrincipal");
        }
    }

    public void destroy() {
    }
}