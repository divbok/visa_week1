package com.visa.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.PersistenceException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJdbcImpl;
import com.visa.prj.entity.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			List<Product> prds =productDao.getProducts();
			request.setAttribute("products", prds);
			//server side redirection
			request.getRequestDispatcher("products.jsp").forward(request, response);
		} catch (FetchException e) {
			e.printStackTrace();
		}
		
		/*
		 * PrintWriter out = response.getWriter(); // opens a character stream to
		 * client-Browser // ServletOutputStream out = response.getOutputStream();
		 * //opens byte stream to // client response.setContentType("text/html"); //
		 * MIME type out.print("<html><body>"); out.print("<h1>Product List</h1>");
		 * out.print("<table border='1'>");
		 * out.print("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");
		 * 
		 * ProductDao productDao = new ProductDaoJdbcImpl(); try { List<Product> prds =
		 * productDao.getProducts(); for (Product p : prds) { out.print("<tr>");
		 * out.print("<td>" + p.getId() + "</td>"); out.print("<td>" + p.getName() +
		 * "</td>"); out.print("<td>" + p.getPrice() + "</td>"); out.print("</tr>"); }
		 * 
		 * } catch (FetchException e) { e.printStackTrace();
		 * out.println(e.getMessage()); } out.print("</table></body></html>");
		 */	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product p = new Product();
		p.setName(request.getParameter("name"));
		p.setCategory(request.getParameter("category"));
		p.setPrice(Double.parseDouble(request.getParameter("price")));
		p.setCount(Integer.parseInt(request.getParameter("count")));
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			int id = productDao.addProduct(p);
			response.setContentType("text/html");
			response.getWriter().println("Product added with id " + id);
			response.getWriter().println("<br /> <a href='index.html'>Back</a>");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

}
