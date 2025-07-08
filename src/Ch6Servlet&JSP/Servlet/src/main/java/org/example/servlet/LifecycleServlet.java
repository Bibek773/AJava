//package org.example.servlet;
//
//import jakarta.servlet.annotation.WebServlet;  // Annotation to declare servlet and URL mapping
//import jakarta.servlet.http.HttpServlet;       // Base class for HTTP servlets
//import jakarta.servlet.ServletException;       // Exception thrown by servlet methods
//import jakarta.servlet.http.HttpServletRequest;  // Represents client request
//import jakarta.servlet.http.HttpServletResponse; // Represents server response
//
//import java.io.*;  // For PrintWriter and IO exceptions
//
//// @WebServlet annotation maps this servlet to the URL pattern "/lifecycle"
//// When the server receives a request for "/lifecycle", this servlet will handle it
//@WebServlet("/lifecycle")
//public class LifecycleServlet extends HttpServlet {
//
//    /**
//     * init() method is called by the servlet container exactly once
//     * when the servlet is first loaded into memory.
//     *
//     * This method is used for initialization tasks like
//     * setting up resources (database connections, reading config, etc.)
//     */
//    @Override
//    public void init() throws ServletException {
//        System.out.println("Servlet is being initialized");
//    }
//
//    /**
//     * service() method is called by the servlet container
//     * for each HTTP request (GET, POST, PUT, DELETE, etc.).
//     * It determines the request type and dispatches to
//     * appropriate methods like doGet(), doPost(), etc.
//     *
//     * Here, we override it directly to handle all requests in one method.
//     *
//     * @param req HttpServletRequest object - contains info about client request
//     * @param resp HttpServletResponse object - used to send response to client
//     * @throws ServletException in case of general servlet errors
//     * @throws IOException in case of input/output errors
//     */
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Print to server console/log which HTTP method was called
//        System.out.println("service() called - HTTP method: " + req.getMethod());
//
//        // Set the response content type to HTML so browser renders it correctly
//        resp.setContentType("text/html");
//
//        // Get PrintWriter object to send character text response to client
//        PrintWriter out = resp.getWriter();
//
//        // Build simple HTML response dynamically
//        out.println("<html><body>");
//        out.println("<h2>Service Method Executed</h2>");
//        out.println("<p>HTTP Method: " + req.getMethod() + "</p>");
//        out.println("</body></html>");
//    }
//
//    /**
//     * destroy() method is called by the servlet container once
//     * just before the servlet instance is removed from service.
//     *
//     * This is the place to release any resources held (DB connections,
//     * threads, files, etc.) and perform cleanup.
//     */
//    @Override
//    public void destroy() {
//        System.out.println("destroy() called - Servlet is being destroyed");
//    }
//}