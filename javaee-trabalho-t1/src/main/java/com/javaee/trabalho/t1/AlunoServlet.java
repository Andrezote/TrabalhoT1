package com.javaee.trabalho.t1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlunoServlet", urlPatterns = { "/ListaAluno" })
public class AlunoServlet extends HttpServlet {

	private static List<Aluno> listaAluno = new ArrayList<Aluno>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String idade = req.getParameter("idade");

		Aluno bean = new Aluno();
		bean.setNome(nome);
		bean.setIdade(idade);

		listaAluno.add(bean);
		// adicionar bean no retorno

		req.setAttribute("bean", tabela(listaAluno));

		RequestDispatcher dispatcher = req.getRequestDispatcher("lista.jsp");
		dispatcher.forward(req, resp);

	}

	private String tabela(List<Aluno> lista) {
		StringBuilder sb = new StringBuilder();
		sb.append("<table style='width:50%' border=1 cellspacing=0 cellpadding=2 bordercolor='000000'>")
		.append("<tr>").append("<th>").append("Nome").append("</th>").append("<th>")
				.append("Idade").append("</th>").append("<tr>");
		
		for (Aluno aluno : lista) {
			sb.append("<tr>").append("<td>").append(aluno.getNome()).append("</td>").append("<td>")
					.append(aluno.getIdade()).append("</td>").append("</tr>");
		}

		sb.append("</table>");

		return sb.toString();

	}

}
