
# ✅ JDBC Complete Notes 

## 📌 Java Database Connectivity (JDBC)

JDBC (Java Database Connectivity) is an API that enables Java applications to interact with databases. It allows you to:

* Connect to a database
* Run SQL queries
* Retrieve and manipulate data

---

## 🏗️ JDBC Architecture

![JDBC Architecture](https://www.researchgate.net/profile/Mamta-Mittal/publication/343944247/figure/fig1/AS:932834531999746@1598925874000/JDBC-architecture.png)

---

## 🔄 Types of JDBC Drivers

| Type   | Name                    | Description                                                 |
| ------ | ----------------------- | ----------------------------------------------------------- |
| Type 1 | JDBC-ODBC Bridge        | Uses ODBC to connect. Deprecated now.                       |
| Type 2 | Native-API Driver       | Uses DB-specific native libraries like Oracle OCI.          |
| Type 3 | Network Protocol Driver | Connects through middleware server (e.g., App Server).      |
| Type 4 | Thin Driver ✅           | 100% Java driver. Communicates directly with DB. Most used. |

---

## 🧰 Key Interfaces & Classes

| Interface / Class   | Role                                                    |
| ------------------- | ------------------------------------------------------- |
| `DriverManager`     | Loads JDBC driver and manages DB connections            |
| `Connection`        | Establishes session with the database                   |
| `Statement`         | Executes static SQL queries                             |
| `PreparedStatement` | Executes dynamic parameterized queries                  |
| `CallableStatement` | Calls stored procedures                                 |
| `ResultSet`         | Holds result returned from a query                      |
| `ResultSetMetaData` | Provides metadata of resultset (columns, types, etc.)   |
| `RowSet`            | Enhanced ResultSet that works offline and is scrollable |

---

## 🪜 Steps to Use JDBC

1. Import packages:

   ```java
   import java.sql.*;
   ```

2. Load Driver:

   ```java
   Class.forName("com.mysql.cj.jdbc.Driver");
   ```

3. Connect to DB:

   ```java
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "password");
   ```

4. Create Statement / PreparedStatement

   ```java
   Statement stmt = con.createStatement();
   ```

5. Execute SQL

   ```java
   ResultSet rs = stmt.executeQuery("SELECT * FROM students");
   ```

6. Process Result

   ```java
   while(rs.next()) {
     System.out.println(rs.getString("name"));
   }
   ```

7. Close Resources

   ```java
   rs.close(); stmt.close(); con.close();
   ```

---

## 🧾 ResultSetMetaData

Used to retrieve column details from a `ResultSet`.

### Common Methods:

* `getColumnCount()`
* `getColumnName(int index)`
* `getColumnTypeName(int index)`
* `getTableName(int index)`

---

## ⚖️ Statement vs PreparedStatement

| Feature             | Statement | PreparedStatement        |
| ------------------- | --------- | ------------------------ |
| Query Type          | Static    | Dynamic                  |
| SQL Injection Risk  | High      | Low (prevents injection) |
| Performance         | Slower    | Faster (precompiled)     |
| Placeholder Support | ❌         | ✅ (`?` placeholders)     |
| Reusability         | Less      | High                     |

---

## 🔁 RowSet in JDBC

### What is RowSet?

A **RowSet** is a wrapper around a `ResultSet` that provides scrollable, updatable, and disconnected access to data.

### ✅ Benefits:

* Works **offline** (disconnected)
* Scrollable and updatable
* Can be serialized and passed over network
* Can be used in GUI (Swing apps)

---

### 🧩 Types of RowSet

| Type             | Description                                    |
| ---------------- | ---------------------------------------------- |
| `JdbcRowSet`     | Connected RowSet, always connected to DB       |
| `CachedRowSet` ✅ | Disconnected RowSet (data cached in memory)    |
| `WebRowSet`      | CachedRowSet with XML support                  |
| `FilteredRowSet` | Filter rows based on criteria                  |
| `JoinRowSet`     | Combine data from multiple RowSets (like JOIN) |

---

## 💻 CachedRowSet Program (from your notebook)

```java
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetDemo {
    public static void main(String[] args) {
        try {
            // Create CachedRowSet instance
            CachedRowSet cr = RowSetProvider.newFactory().createCachedRowSet();

            // Set DB connection info
            cr.setUrl("jdbc:mysql://localhost:3306/mydb");
            cr.setUsername("root");
            cr.setPassword("root");

            // Set SQL query
            cr.setCommand("SELECT * FROM user");

            // Execute query
            cr.execute();

            // Iterate through the result
            while (cr.next()) {
                String name = cr.getString("name");
                System.out.println("Name: " + name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

> ✅ *This example uses a `CachedRowSet` to fetch data from `user` table, and prints the name column.*

---

## 🧠 Extra Notes:

* **RowSetProvider** is used to get RowSetFactory (Java 7+).
* You need `mysql-connector-java` jar in your classpath.
* Don't forget to **enable MySQL server**, and verify your **DB, username, password** are correct.

---

