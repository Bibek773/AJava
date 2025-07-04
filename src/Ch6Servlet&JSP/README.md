# 📘 Unit 6: Servlets and JSP (6 Hours)

---

## 6.1 Overview of Web Application

A **Web Application** is a client-server application that runs in a browser and communicates over HTTP/HTTPS protocol. It allows users to interact with server-side applications through web browsers.

### 🏗️ Key Components:

* **Client (Frontend)**: Web browser (Chrome, Firefox, Safari, Edge)
* **Web Server**: Apache Tomcat, Jetty, WebLogic (handles HTTP requests)
* **Backend**: Servlet/JSP/Java code (business logic)
* **Database**: MySQL, Oracle, PostgreSQL (data storage)

### 🔄 Web Application Architecture:

```
[Browser] ←→ [Web Server] ←→ [Servlet/JSP] ←→ [Database]
   HTTP          HTTP         Java Code       SQL
```

### 📊 Web App Request-Response Flow:

1. **User Action**: User clicks button/submits form in browser
2. **HTTP Request**: Browser sends HTTP request to server
3. **Server Processing**: Web server receives and forwards to servlet
4. **Business Logic**: Servlet processes request, interacts with database
5. **Response Generation**: Servlet creates HTTP response
6. **Display**: Browser receives and displays response to user

### 🌐 Types of Web Applications:

* **Static Web Apps**: HTML, CSS, JavaScript (no server processing)
* **Dynamic Web Apps**: Server-side processing with Servlets/JSP
* **Single Page Apps (SPA)**: JavaScript frameworks with REST APIs

---

## 6.2 HTTP Methods and Responses

### 🔁 HTTP Methods (Verbs):

| Method | Purpose | Example Use Case |
|--------|---------|------------------|
| **GET** | Retrieve data | Loading a webpage, search results |
| **POST** | Submit data | Login forms, file uploads |
| **PUT** | Update entire resource | Update user profile |
| **DELETE** | Delete resource | Delete a record |
| **PATCH** | Partial update | Update specific fields |
| **HEAD** | Get headers only | Check if resource exists |

### 📨 HTTP Status Codes:

#### ✅ Success Codes (2xx):
* `200 OK`: Request successful
* `201 Created`: Resource created successfully
* `204 No Content`: Success but no content to return

#### ↩️ Redirection Codes (3xx):
* `301 Moved Permanently`: Resource permanently moved
* `302 Found`: Temporary redirect
* `304 Not Modified`: Resource hasn't changed

#### ❌ Client Error Codes (4xx):
* `400 Bad Request`: Invalid request syntax
* `401 Unauthorized`: Authentication required
* `403 Forbidden`: Access denied
* `404 Not Found`: Resource not found
* `405 Method Not Allowed`: HTTP method not supported

#### 🔥 Server Error Codes (5xx):
* `500 Internal Server Error`: Server crashed
* `502 Bad Gateway`: Invalid response from upstream
* `503 Service Unavailable`: Server temporarily unavailable

### 🔍 HTTP Request Structure:

```
GET /search?q=java HTTP/1.1
Host: www.example.com
User-Agent: Mozilla/5.0...
Accept: text/html
Cookie: sessionid=abc123
```

### 📤 HTTP Response Structure:

```
HTTP/1.1 200 OK
Content-Type: text/html
Content-Length: 1234
Set-Cookie: sessionid=xyz789

<html>
<body>Response content here</body>
</html>
```

---

## 6.3 Life Cycle of Web Servlets

### 🔄 Servlet Life Cycle Phases:

A servlet goes through these phases during its lifetime:

#### 1. **Loading & Instantiation**
* Servlet class is loaded by the web container
* Single instance of servlet is created
* Happens when first request arrives or at server startup

#### 2. **Initialization**
* `init()` method is called **once** after instantiation
* Used for one-time setup (database connections, configuration)
* Servlet becomes ready to handle requests

#### 3. **Request Handling**
* `service()` method is called for **each request**
* `service()` determines HTTP method and calls appropriate `doXXX()` method
* Multiple requests can be handled simultaneously (multi-threading)

#### 4. **Destruction**
* `destroy()` method is called **once** before servlet is unloaded
* Used for cleanup (closing connections, releasing resources)
* Servlet is garbage collected after this

### 🔁 Servlet Life Cycle Methods:

```java
public class MyServlet extends HttpServlet {
    
    // Called once when servlet is first loaded
    public void init() throws ServletException {
        System.out.println("Servlet initialized");
        // Initialize database connections, load config
    }
    
    // Called for each request
    public void service(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        System.out.println("Service method called");
        super.service(req, res); // Calls doGet/doPost based on method
    }
    
    // Called once before servlet is destroyed
    public void destroy() {
        System.out.println("Servlet destroyed");
        // Close database connections, cleanup resources
    }
}
```

### 📊 Life Cycle Example:

```java
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {
    
    private int requestCount = 0;
    
    @Override
    public void init() throws ServletException {
        System.out.println("🚀 Servlet Initialized at: " + new Date());
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        requestCount++;
        System.out.println("📨 Request #" + requestCount + " handled");
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Request #" + requestCount + " processed</h2>");
        out.close();
    }
    
    @Override
    public void destroy() {
        System.out.println("💥 Servlet destroyed. Total requests: " + requestCount);
    }
}
```

---

## 6.4 Writing Servlet Programs with Servlet APIs

### 🛠️ Creating Your First Servlet:

#### Step 1: Basic Servlet Structure

```java
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        
        // Get writer to send response
        PrintWriter out = response.getWriter();
        
        // Write HTML response
        out.println("<html><body>");
        out.println("<h1>Hello, World!</h1>");
        out.println("<p>This is my first servlet</p>");
        out.println("</body></html>");
        
        out.close();
    }
}
```

### 🔧 Essential Servlet APIs:

#### HttpServletRequest Methods:

```java
// Get request parameters
String name = request.getParameter("name");
String[] hobbies = request.getParameterValues("hobby");
Enumeration<String> params = request.getParameterNames();

// Get request headers
String userAgent = request.getHeader("User-Agent");
String contentType = request.getContentType();

// Get request information
String method = request.getMethod();
String uri = request.getRequestURI();
String remoteAddr = request.getRemoteAddr();

// Session and cookies
HttpSession session = request.getSession();
Cookie[] cookies = request.getCookies();
```

#### HttpServletResponse Methods:

```java
// Set response properties
response.setContentType("text/html");
response.setCharacterEncoding("UTF-8");
response.setStatus(HttpServletResponse.SC_OK);

// Send response
PrintWriter out = response.getWriter();
out.println("Hello World");

// Redirect
response.sendRedirect("welcome.html");

// Add cookies
Cookie cookie = new Cookie("username", "john");
response.addCookie(cookie);
```

### 📂 Project Structure:

```
MyWebApp/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── MyServlet.java
│       └── webapp/
│           ├── WEB-INF/
│           │   └── web.xml
│           ├── index.html
│           └── styles.css
└── pom.xml (if using Maven)
```

### 🔗 URL Mapping:

#### Using Annotations:
```java
@WebServlet("/hello")           // Maps to /hello
@WebServlet("/user/*")          // Maps to /user/anything
@WebServlet("*.do")             // Maps to any URL ending with .do
```

#### Using web.xml:
```xml
<servlet>
    <servlet-name>HelloServlet</servlet-name>
    <servlet-class>com.example.HelloServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>HelloServlet</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
```

---

## 6.5 Reading and Processing Forms

### 📋 HTML Form Basics:

```html
<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
    <h2>User Registration</h2>
    <form method="post" action="register">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><input type="number" name="age" min="1" max="120"></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="gender" value="Male"> Male
                    <input type="radio" name="gender" value="Female"> Female
                </td>
            </tr>
            <tr>
                <td>Hobbies:</td>
                <td>
                    <input type="checkbox" name="hobby" value="Reading"> Reading<br>
                    <input type="checkbox" name="hobby" value="Sports"> Sports<br>
                    <input type="checkbox" name="hobby" value="Music"> Music
                </td>
            </tr>
            <tr>
                <td>Country:</td>
                <td>
                    <select name="country">
                        <option value="Nepal">Nepal</option>
                        <option value="India">India</option>
                        <option value="USA">USA</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Comments:</td>
                <td><textarea name="comments" rows="4" cols="40"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Register">
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
```

### 🔧 Form Processing Servlet:

```java
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Read form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String comments = request.getParameter("comments");
        
        // Read multiple values (checkboxes)
        String[] hobbies = request.getParameterValues("hobby");
        
        // Generate response
        out.println("<html><body>");
        out.println("<h2>Registration Successful!</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Age:</strong> " + age + "</p>");
        out.println("<p><strong>Gender:</strong> " + gender + "</p>");
        out.println("<p><strong>Country:</strong> " + country + "</p>");
        
        // Display hobbies
        out.println("<p><strong>Hobbies:</strong> ");
        if (hobbies != null) {
            for (String hobby : hobbies) {
                out.println(hobby + " ");
            }
        } else {
            out.println("None");
        }
        out.println("</p>");
        
        out.println("<p><strong>Comments:</strong> " + comments + "</p>");
        out.println("<a href='index.html'>Back to Form</a>");
        out.println("</body></html>");
        
        out.close();
    }
}
```

### 🛡️ Input Validation:

```java
// Validate required fields
if (name == null || name.trim().isEmpty()) {
    out.println("<p style='color:red'>Name is required!</p>");
    return;
}

// Validate email format
if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
    out.println("<p style='color:red'>Invalid email format!</p>");
    return;
}

// Validate age
try {
    int ageValue = Integer.parseInt(age);
    if (ageValue < 1 || ageValue > 120) {
        out.println("<p style='color:red'>Age must be between 1 and 120!</p>");
        return;
    }
} catch (NumberFormatException e) {
    out.println("<p style='color:red'>Invalid age format!</p>");
    return;
}
```

---

## 6.6 Handling GET/POST Requests

### 🔄 GET vs POST Methods:

| Aspect | GET | POST |
|--------|-----|------|
| **Data Location** | URL parameters | Request body |
| **Data Visibility** | Visible in URL | Hidden from URL |
| **Data Length** | Limited (~2048 chars) | Unlimited |
| **Security** | Less secure | More secure |
| **Caching** | Can be cached | Not cached |
| **Bookmarking** | Can be bookmarked | Cannot be bookmarked |
| **Use Cases** | Search, filter, view | Login, submit forms |

### 📥 Handling GET Requests:

```java
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String query = request.getParameter("q");
        String category = request.getParameter("category");
        
        out.println("<html><body>");
        out.println("<h2>Search Results</h2>");
        
        if (query != null && !query.trim().isEmpty()) {
            out.println("<p>You searched for: <strong>" + query + "</strong></p>");
            
            if (category != null) {
                out.println("<p>Category: <strong>" + category + "</strong></p>");
            }
            
            // Simulate search results
            out.println("<ul>");
            out.println("<li>Result 1 for " + query + "</li>");
            out.println("<li>Result 2 for " + query + "</li>");
            out.println("<li>Result 3 for " + query + "</li>");
            out.println("</ul>");
        } else {
            out.println("<p>Please enter a search query.</p>");
        }
        
        out.println("<a href='search.html'>New Search</a>");
        out.println("</body></html>");
        
        out.close();
    }
}
```

### 📤 Handling POST Requests:

```java
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        out.println("<html><body>");
        
        // Simple authentication (in real apps, use database)
        if ("admin".equals(username) && "password123".equals(password)) {
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<p>Login successful.</p>");
            out.println("<a href='dashboard.html'>Go to Dashboard</a>");
        } else {
            out.println("<h2>Login Failed</h2>");
            out.println("<p style='color:red'>Invalid username or password.</p>");
            out.println("<a href='login.html'>Try Again</a>");
        }
        
        out.println("</body></html>");
        out.close();
    }
}
```

### 🔄 Handling Both GET and POST:

```java
@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Show contact form
        showContactForm(response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Process form submission
        processContactForm(request, response);
    }
    
    private void showContactForm(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Contact Us</h2>");
        out.println("<form method='post' action='contact'>");
        out.println("Name: <input type='text' name='name' required><br><br>");
        out.println("Email: <input type='email' name='email' required><br><br>");
        out.println("Message: <textarea name='message' required></textarea><br><br>");
        out.println("<input type='submit' value='Send Message'>");
        out.println("</form>");
        out.println("</body></html>");
        
        out.close();
    }
    
    private void processContactForm(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        
        out.println("<html><body>");
        out.println("<h2>Thank You!</h2>");
        out.println("<p>Your message has been sent successfully.</p>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<a href='contact'>Send Another Message</a>");
        out.println("</body></html>");
        
        out.close();
    }
}
```

---

## 6.7 Database Connectivity through Servlets

### 🗃️ Database Integration:

#### Step 1: Add Database Dependencies

For MySQL (add to `pom.xml` if using Maven):
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

#### Step 2: Database Configuration

```java
public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/myapp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found", e);
        }
    }
}
```

#### Step 3: Create Database and Table

```sql
CREATE DATABASE myapp;
USE myapp;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 👤 User Registration with Database:

```java
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        
        try {
            int age = Integer.parseInt(ageStr);
            
            // Insert into database
            if (insertUser(name, email, age)) {
                out.println("<html><body>");
                out.println("<h2>Registration Successful!</h2>");
                out.println("<p>Welcome, " + name + "!</p>");
                out.println("<a href='users'>View All Users</a>");
                out.println("</body></html>");
            } else {
                out.println("<html><body>");
                out.println("<h2>Registration Failed</h2>");
                out.println("<p>Email already exists or database error.</p>");
                out.println("<a href='register.html'>Try Again</a>");
                out.println("</body></html>");
            }
        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h2>Invalid Age</h2>");
            out.println("<a href='register.html'>Try Again</a>");
            out.println("</body></html>");
        }
        
        out.close();
    }
    
    private boolean insertUser(String name, String email, int age) {
        String sql = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, age);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
```

### 📋 Display Users from Database:

```java
@WebServlet("/users")
public class UserListServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>All Users</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Age</th><th>Created</th></tr>");
        
        String sql = "SELECT * FROM users ORDER BY created_at DESC";
        
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getInt("age") + "</td>");
                out.println("<td>" + rs.getTimestamp("created_at") + "</td>");
                out.println("</tr>");
            }
            
        } catch (SQLException e) {
            out.println("<tr><td colspan='5'>Error loading users: " + e.getMessage() + "</td></tr>");
        }
        
        out.println("</table>");
        out.println("<br><a href='register.html'>Add New User</a>");
        out.println("</body></html>");
        
        out.close();
    }
}
```

### 🔍 Search Users:

```java
@WebServlet("/search-users")
public class UserSearchServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String searchTerm = request.getParameter("search");
        
        out.println("<html><body>");
        out.println("<h2>Search Users</h2>");
        
        // Search form
        out.println("<form method='get' action='search-users'>");
        out.println("Search: <input type='text' name='search' value='" + 
                   (searchTerm != null ? searchTerm : "") + "'>");
        out.println("<input type='submit' value='Search'>");
        out.println("</form><br>");
        
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            out.println("<h3>Results for: " + searchTerm + "</h3>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Age</th></tr>");
            
            String sql = "SELECT * FROM users WHERE name LIKE ? OR email LIKE ?";
            
            try (Connection conn = DatabaseConfig.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                String searchPattern = "%" + searchTerm + "%";
                pstmt.setString(1, searchPattern);
                pstmt.setString(2, searchPattern);
                
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                
                while (rs.next()) {
                    found = true;
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("id") + "</td>");
                    out.println("<td>" + rs.getString("name") + "</td>");
                    out.println("<td>" + rs.getString("email") + "</td>");
                    out.println("<td>" + rs.getInt("age") + "</td>");
                    out.println("</tr>");
                }
                
                if (!found) {
                    out.println("<tr><td colspan='4'>No users found</td></tr>");
                }
                
            } catch (SQLException e) {
                out.println("<tr><td colspan='4'>Search error: " + e.getMessage() + "</td></tr>");
            }
            
            out.println("</table>");
        }
        
        out.println("</body></html>");
        out.close();
    }
}
```

---

## 6.8 Cookies and Sessions

### 🍪 Working with Cookies:

Cookies are small pieces of data stored on the client's browser. They're used to remember user preferences, login status, shopping cart contents, etc.

#### Creating and Setting Cookies:

```java
@WebServlet("/set-cookie")
public class SetCookieServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String theme = request.getParameter("theme");
        
        // Create cookies
        Cookie userCookie = new Cookie("username", username);
        Cookie themeCookie = new Cookie("theme", theme);
        
        // Set cookie properties
        userCookie.setMaxAge(60 * 60 * 24 * 7); // 7 days
        themeCookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
        
        userCookie.setPath("/"); // Available to entire application
        themeCookie.setPath("/");
        
        // Add cookies to response
        response.addCookie(userCookie);
        response.addCookie(themeCookie);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Cookies Set Successfully!</h2>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Theme: " + theme + "</p>");
        out.println("<a href='get-cookie'>View Cookies</a>");
        out.println("</body></html>");
        
        out.close();
    }
}
```

#### Reading Cookies:

```java
@WebServlet("/get-cookie")
public class GetCookieServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Your Cookies</h2>");
        
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null) {
            out.println("<table border='1'>");
            out.println("<tr><th>Name</th><th>Value</th></tr>");
            
            for (Cookie cookie : cookies) {
                out.println("<tr>");
                out.println("<td>" + cookie.getName() + "</td>");
                out.println("<td>" + cookie.getValue() + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            
            // Get specific cookie
            String username = getCookieValue(cookies, "username");
            String theme = getCookieValue(cookies, "theme");
            
            if (username != null) {
                out.println("<p>Welcome back, " + username + "!</p>");
            }
            
            if (theme != null) {
                out.println("<p>Your theme: " + theme + "</p>");
            
            
        } else {
            out.println("<p>No cookies found.</p>");
        }
        
        out.println("<br><a href='cookie-form.html'>Set New Cookies</a>");
        out.println("</body></html>");
        
        out.close();
    }
    
    private String getCookieValue(Cookie[] cookies, String cookieName) {
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
```

#### Deleting Cookies:

```java
@WebServlet("/delete-cookie")
public class DeleteCookieServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String cookieName = request.getParameter("name");
        
        if (cookieName != null) {
            // Create cookie with same name but set max age to 0
            Cookie cookie = new Cookie(cookieName, "");
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Cookie Deleted</h2>");
        out.println("<p>Cookie '" + cookieName + "' has been deleted.</p>");
        out.println("<a href='get-cookie'>View Remaining Cookies</a>");
        out.println("</body></html>");
        
        out.close();
    }
}
```

### 🔐 Working with Sessions:

Sessions are server-side storage mechanisms that maintain user state across multiple requests. Unlike cookies, session data is stored on the server.

#### Session Management:

```java
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Simple authentication
        if (authenticateUser(username, password)) {
            // Create or get existing session
            HttpSession session = request.getSession();
            
            // Set session attributes
            session.setAttribute("username", username);
            session.setAttribute("loginTime", new java.util.Date());
            session.setAttribute("isLoggedIn", true);
            
            // Set session timeout (in seconds)
            session.setMaxInactiveInterval(30 * 60); // 30 minutes
            
            out.println("<html><body>");
            out.println("<h2>Login Successful!</h2>");
            out.println("<p>Welcome, " + username + "!</p>");
            out.println("<p>Session ID: " + session.getId() + "</p>");
            out.println("<a href='dashboard'>Go to Dashboard</a>");
            out.println("</body></html>");
            
        } else {
            out.println("<html><body>");
            out.println("<h2>Login Failed</h2>");
            out.println("<p style='color:red'>Invalid credentials!</p>");
            out.println("<a href='login.html'>Try Again</a>");
            out.println("</body></html>");
        }
        
        out.close();
    }
    
    private boolean authenticateUser(String username, String password) {
        // In real application, check against database
        return "admin".equals(username) && "password123".equals(password);
    }
}
```

#### Using Session Data:

```java
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get existing session (don't create new one)
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("isLoggedIn") != null) {
            String username = (String) session.getAttribute("username");
            java.util.Date loginTime = (java.util.Date) session.getAttribute("loginTime");
            
            out.println("<html><body>");
            out.println("<h2>Dashboard</h2>");
            out.println("<p>Welcome, " + username + "!</p>");
            out.println("<p>Login Time: " + loginTime + "</p>");
            out.println("<p>Session ID: " + session.getId() + "</p>");
            out.println("<p>Session Creation Time: " + new java.util.Date(session.getCreationTime()) + "</p>");
            out.println("<p>Last Accessed: " + new java.util.Date(session.getLastAccessedTime()) + "</p>");
            out.println("<p>Max Inactive Interval: " + session.getMaxInactiveInterval() + " seconds</p>");
            
            out.println("<br><a href='profile'>View Profile</a>");
            out.println(" | <a href='logout'>Logout</a>");
            out.println("</body></html>");
            
        } else {
            // Session doesn't exist or user not logged in
            out.println("<html><body>");
            out.println("<h2>Access Denied</h2>");
            out.println("<p>Please login first.</p>");
            out.println("<a href='login.html'>Login</a>");
            out.println("</body></html>");
        }
        
        out.close();
    }
}
```

#### Session Logout:

```java
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            String username = (String) session.getAttribute("username");
            session.invalidate(); // Destroy session
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            out.println("<html><body>");
            out.println("<h2>Logout Successful</h2>");
            out.println("<p>Goodbye, " + username + "!</p>");
            out.println("<p>Your session has been terminated.</p>");
            out.println("<a href='login.html'>Login Again</a>");
            out.println("</body></html>");
            
            out.close();
        } else {
            response.sendRedirect("login.html");
        }
    }
}
```

### 🛒 Shopping Cart Example using Sessions:

```java
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String productName = request.getParameter("product");
        String priceStr = request.getParameter("price");
        
        HttpSession session = request.getSession();
        
        // Get existing cart or create new one
        @SuppressWarnings("unchecked")
        java.util.List<String> cart = (java.util.List<String>) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new java.util.ArrayList<>();
            session.setAttribute("cart", cart);
        }
        
        // Add item to cart
        cart.add(productName + " - $" + priceStr);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Item Added to Cart</h2>");
        out.println("<p>" + productName + " has been added to your cart.</p>");
        out.println("<p>Cart size: " + cart.size() + " items</p>");
        out.println("<a href='view-cart'>View Cart</a>");
        out.println(" | <a href='products.html'>Continue Shopping</a>");
        out.println("</body></html>");
        
        out.close();
    }
}

@WebServlet("/view-cart")
public class ViewCartServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        @SuppressWarnings("unchecked")
        java.util.List<String> cart = (java.util.List<String>) session.getAttribute("cart");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Shopping Cart</h2>");
        
        if (cart != null && !cart.isEmpty()) {
            out.println("<ul>");
            for (String item : cart) {
                out.println("<li>" + item + "</li>");
            }
            out.println("</ul>");
            out.println("<p>Total items: " + cart.size() + "</p>");
            out.println("<a href='checkout'>Checkout</a>");
            out.println(" | <a href='clear-cart'>Clear Cart</a>");
        } else {
            out.println("<p>Your cart is empty.</p>");
        }
        
        out.println("<br><a href='products.html'>Continue Shopping</a>");
        out.println("</body></html>");
        
        out.close();
    }
}
```

### 🍪 vs 🔐 Cookies vs Sessions Comparison:

| Feature | Cookies | Sessions |
|---------|---------|----------|
| **Storage Location** | Client browser | Server memory/database |
| **Data Size** | Limited (~4KB) | Unlimited (server dependent) |
| **Security** | Less secure (client-side) | More secure (server-side) |
| **Persistence** | Can persist after browser close | Ends when session expires |
| **Performance** | Faster (no server lookup) | Slower (server processing) |
| **User Control** | User can disable/delete | User cannot directly access |
| **Data Types** | Only strings | Any Java object |

---

## 6.9 Introduction to JSP (JavaServer Pages)

### 📄 What is JSP?

JSP (JavaServer Pages) is a technology that allows embedding Java code in HTML pages. It simplifies the development of dynamic web pages by separating presentation (HTML) from business logic (Java).

### 🔄 JSP vs Servlets:

| Aspect | Servlets | JSP |
|--------|----------|-----|
| **Purpose** | Business logic | Presentation layer |
| **Code Style** | Java with HTML strings | HTML with Java code |
| **Maintenance** | Hard to maintain UI | Easy to maintain UI |
| **Performance** | Faster | Slightly slower (compilation) |
| **Best For** | Controllers, APIs | Views, Reports |

### 🏗️ JSP Architecture:

```
[JSP Page] → [Translation] → [Servlet] → [Compilation] → [Execution]
    .jsp         Phase        .java         Phase         .class
```

### 📝 Basic JSP Syntax:

#### JSP Elements:

```jsp
<!-- JSP Comment (not sent to client) -->
<%-- This is a JSP comment --%>

<!-- HTML Comment (sent to client) -->
<!-- This is an HTML comment -->

<!-- Scriptlet: Java code -->
<% 
    String name = "John";
    int age = 25;
    out.println("Hello, " + name);
%>

<!-- Expression: Print value -->
<%= name %>
<%= age + 5 %>

<!-- Declaration: Define methods/variables -->
<%! 
    private int counter = 0;
    
    public String formatDate(java.util.Date date) {
        return date.toString();
    }
%>

<!-- Directive: Page configuration -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
```

### 🌟 Your First JSP Page:

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>My First JSP Page</title>
</head>
<body>
    <h1>Welcome to JSP!</h1>
    
    <%-- Java code to get current date --%>
    <% 
        java.util.Date currentDate = new java.util.Date();
        String welcomeMessage = "Today is " + currentDate;
    %>
    
    <p><%= welcomeMessage %></p>
    
    <%-- Loop example --%>
    <h2>Numbers 1 to 5:</h2>
    <ul>
        <% for(int i = 1; i <= 5; i++) { %>
            <li>Number: <%= i %></li>
        <% } %>
    </ul>
    
    <%-- Conditional example --%>
    <% 
        int hour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY);
        String greeting;
        
        if (hour < 12) {
            greeting = "Good Morning!";
        } else if (hour < 17) {
            greeting = "Good Afternoon!";
        } else {
            greeting = "Good Evening!";
        }
    %>
    
    <h2><%= greeting %></h2>
</body>
</html>
```

### 🎯 JSP Directives:

#### Page Directive:

```jsp
<%@ page 
    contentType="text/html;charset=UTF-8" 
    language="java"
    import="java.util.*,java.sql.*"
    session="true"
    buffer="8kb"
    autoFlush="true"
    isThreadSafe="true"
    errorPage="error.jsp"
    isErrorPage="false"
%>
```

#### Include Directive:

```jsp
<%@ include file="header.jsp" %>
<main>
    <h1>Main Content</h1>
    <p>This is the main page content.</p>
</main>
<%@ include file="footer.jsp" %>
```

#### Taglib Directive:

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${users}" var="user">
    <p>${user.name}</p>
</c:forEach>
```

### 🔧 JSP Implicit Objects:

JSP provides built-in objects that can be used directly:

```jsp
<%-- request - HttpServletRequest --%>
<p>Your IP: <%= request.getRemoteAddr() %></p>
<p>Parameter 'name': <%= request.getParameter("name") %></p>

<%-- response - HttpServletResponse --%>
<% response.setHeader("Cache-Control", "no-cache"); %>

<%-- session - HttpSession --%>
<% session.setAttribute("user", "John"); %>
<p>Session ID: <%= session.getId() %></p>

<%-- application - ServletContext --%>
<% application.setAttribute("appName", "MyApp"); %>
<p>App Name: <%= application.getAttribute("appName") %></p>

<%-- out - PrintWriter --%>
<% out.println("<p>Hello from out object!</p>"); %>

<%-- config - ServletConfig --%>
<p>Servlet Name: <%= config.getServletName() %></p>

<%-- page - Current JSP page object --%>
<p>Page Class: <%= page.getClass().getName() %></p>

<%-- pageContext - PageContext --%>
<% pageContext.setAttribute("message", "Hello World"); %>
<p>Message: <%= pageContext.getAttribute("message") %></p>

<%-- exception - Exception object (only in error pages) --%>
<%@ page isErrorPage="true" %>
<p>Error: <%= exception.getMessage() %></p>
```

### 📋 Form Processing with JSP:

#### registration.jsp:

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration</h2>
    <form method="post" action="process-registration.jsp">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><input type="number" name="age" min="1" max="120"></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="gender" value="Male"> Male
                    <input type="radio" name="gender" value="Female"> Female
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Register">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
```

#### process-registration.jsp:

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
</head>
<body>
    <%
        // Get form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        String gender = request.getParameter("gender");
        
        // Validate input
        if (name == null || name.trim().isEmpty()) {
            out.println("<h2>Error: Name is required!</h2>");
            out.println("<a href='registration.jsp'>Go Back</a>");
            return;
        }
        
        try {
            int age = Integer.parseInt(ageStr);
            
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/myapp", "root", "password");
            
            // Insert user
            String sql = "INSERT INTO users (name, email, age, gender) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, age);
            pstmt.setString(4, gender);
            
            int result = pstmt.executeUpdate();
            
            if (result > 0) {
                out.println("<h2>Registration Successful!</h2>");
                out.println("<p><strong>Name:</strong> " + name + "</p>");
                out.println("<p><strong>Email:</strong> " + email + "</p>");
                out.println("<p><strong>Age:</strong> " + age + "</p>");
                out.println("<p><strong>Gender:</strong> " + gender + "</p>");
            } else {
                out.println("<h2>Registration Failed!</h2>");
            }
            
            conn.close();
            
        } catch (NumberFormatException e) {
            out.println("<h2>Error: Invalid age format!</h2>");
        } catch (Exception e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    %>
    
    <br>
    <a href="registration.jsp">Register Another User</a>
    <a href="user-list.jsp">View All Users</a>
</body>
</html>
```

### 📊 Database Operations in JSP:

#### user-list.jsp:

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>All Users</h2>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Created At</th>
        </tr>
        
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myapp", "root", "password");
                
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM users ORDER BY created_at DESC");
                
                while (rs.next()) {
        %>
                    <tr>
                        <td><%= rs.getInt("id") %></td>
                        <td><%= rs.getString("name") %></td>
                        <td><%= rs.getString("email") %></td>
                        <td><%= rs.getInt("age") %></td>
                        <td><%= rs.getString("gender") %></td>
                        <td><%= rs.getTimestamp("created_at") %></td>
                    </tr>
        <%
                }
                
                conn.close();
            } catch (Exception e) {
                out.println("<tr><td colspan='6'>Error: " + e.getMessage() + "</td></tr>");
            }
        %>
    </table>
    
    <br>
    <a href="registration.jsp">Add New User</a>
</body>
</html>
```

### 🔍 JSP Best Practices:

1. **Minimize Java Code in JSP**: Use JSP primarily for presentation
2. **Use JSP Standard Tag Library (JSTL)**: Reduce scriptlets
3. **Separate Concerns**: Use MVC pattern (Model-View-Controller)
4. **Error Handling**: Always use try-catch blocks
5. **Close Resources**: Always close database connections
6. **Input Validation**: Validate all user inputs
7. **Use Include Directives**: For reusable components

### 🎯 JSP with MVC Pattern:

```jsp
<!-- login.jsp (View) -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
    
    <form method="post" action="LoginController">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Login">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
```

---
technologies.