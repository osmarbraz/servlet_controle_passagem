package com.controle;

import com.entidade.ControladorVoo;
import com.entidade.ControladorVooImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osmar
 */
public class ServletMarcarVoo extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Mostra a reposta do servidor.
     *
     * @param respostaServidor
     * @return String de resposta
     */
    public String mostrarResultado(int respostaServidor) {
        switch (respostaServidor) {
            case 0:
                return "Voo e assento dispon&iacute;vel";
            case 1:
                return "Assento indispon&iacute;vel";
            case 2:
                return "Assento inexistente";
            case 3:
                return "Voo inexistente";
            case 4:
                return "Assento marcado";
            default:
                return "Voo inexistente";
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Servlet Marcar Voo</title></head><body>");
        out.println("<h1>Servlet Marcar Voo</h1>");

        //Recupera os parâmetros
        String codigoVoo = request.getParameter("codigoVoo");
        int numeroAssento = Integer.parseInt(request.getParameter("numeroAssento"));

        //Instancia o controlador do voo
        ControladorVoo controladorvoo = new ControladorVooImpl();

        //Chama o método marcar voo
        int retorno = controladorvoo.marcarVoo(codigoVoo, numeroAssento);

        //Processa o resultado de retorno
        String resultado = mostrarResultado(retorno);

        //Mostra o resultado
        out.println("<h2> Resultado: " + resultado + "</h1>");

        out.print("<a href=\"" + request.getContextPath() + "/index.html\"> Menu </a><p>");
        out.println("</body></html>");
        out.close();
    }
}
