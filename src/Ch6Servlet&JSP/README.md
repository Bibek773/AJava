
# 📘 Unit 6: Servlets and JSP (6 Hours)

---

## Overview of Web Application

A **Web Application** is a client-server application that runs in a browser and communicates over HTTP/HTTPS.

### Key Components:

* **Client**: Browser (Chrome, Firefox, etc.)
* **Web Server**: Apache Tomcat (handles requests)
* **Backend**: Servlet/JSP/Java code
* **Database**: MySQL, Oracle, etc.

### Web App Flow:

1. User sends request from browser
2. Server receives request (HTTP)
3. Servlet processes logic and interacts with DB
4. Response is sent back to client

---

## HTTP Methods and Responses

### 🔁 HTTP Methods:

| Method | Purpose       |
| ------ | ------------- |
| GET    | Retrieve data |
| POST   | Submit data   |
| PUT    | Update data   |
| DELETE | Delete data   |

### 📨 HTTP Responses:

* Status Codes:

    * `200 OK`: Successful
    * `404 Not Found`: Resource not found
    * `500 Internal Server Error`: Server crash
    * `302 Found`: Redirect

---

## Servlets
- A **Servlet** is a Java class that handles HTTP requests and generates responses.
- Java program to Accept Request process and generate the response.

### To creat servlets
- Inherit from HttpServlet.

### 🚦 Servlet Life Cycle:

1. **Loading**: Servlet class is loaded.
2. **Instantiation**: Object of servlet is created.
3. **Initialization**: `init()` method called once.
4. **Request Handling**: `service()` → `doGet()` / `doPost()` called multiple times.
5. **Destroying**: `destroy()` called before servlet is unloaded.

### 🔁 Servlet Methods:

```java
public void init() throws ServletException { }
public void service(ServletRequest req, ServletResponse res) { }
public void destroy() { }
```

---

## 6.4 Writing Servlet Programs with Servlet APIs

### ✅ Steps to Write a Servlet:

1. Extend `HttpServlet`
2. Override `doGet()` or `doPost()`
3. Map the servlet in `web.xml` or use `@WebServlet` annotation

### 📌 Example: Basic Servlet

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>Hello from Servlet</h1>");
    }
}
```

---

## 6.5 Reading and Processing Forms

### 🧾 HTML Form:

```html
<form action="login" method="post">
  Username: <input type="text" name="username" />
  Password: <input type="password" name="password" />
  <input type="submit" value="Login" />
</form>
```

### 🔄 Servlet to Read Form:

```java
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        
        PrintWriter out = res.getWriter();
        out.println("Username: " + user + "<br>Password: " + pass);
    }
}
```

---

## 6.6 Handling GET/POST Requests

### 📥 GET vs POST:

* **GET**: Parameters visible in URL, limited size, used for retrieval
* **POST**: Hidden parameters, larger data, used for form submission

### Example Servlet for Both:

```java
@WebServlet("/method")
public class MethodServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        res.getWriter().println("GET method called");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        res.getWriter().println("POST method called");
    }
}
```

---

## 6.7 Database Connectivity Through Servlets

### ✅ Required:

* MySQL connector JAR
* JDBC connection setup in Servlet

### 📌 Example: Login Validation with MySQL

#### 🧾 Database Table: `user`

| id | username | password |
| -- | -------- | -------- |
| 1  | admin    | 1234     |

#### Servlet Code:

```java
@WebServlet("/validate")
public class DBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM user WHERE username=? AND password=?");

            ps.setString(1, uname);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            PrintWriter out = res.getWriter();
            res.setContentType("text/html");

            if (rs.next()) {
                out.println("<h2>Login Successful</h2>");
            } else {
                out.println("<h2>Login Failed</h2>");
            }

            rs.close(); ps.close(); con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## 🛠️ Tools You Need:

* **Apache Tomcat** (Web server)
* **MySQL** (Database)
* **Eclipse/IntelliJ** (IDE)
* **Servlet API** (Included in Tomcat lib folder)

---

Let me know if you want:

* PDF version of this note ✅
* JSP coverage for Unit 7 or continuation ✅
* Lab-based programs from this unit ✅
