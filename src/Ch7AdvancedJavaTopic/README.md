
# Advanced Java Topic

## ORM (Object Relation Mapping)
- To map Java object with database table
- Database Table to java object

## ORM Framework
- Hibernate
- JPA
- Spring Data
- MyBatis

### Hibernate
- Hibernate is an ORM framework that provides a way to map Java objects to database tables.
- It simplifies database interactions by allowing developers to work with Java objects instead of SQL queries.
- Hibernate supports various database operations such as CRUD (Create, Read, Update, Delete) and provides features like caching, lazy loading, and transaction management.
- It is widely used in Java applications to handle database operations efficiently and effectively.
- Hibernate provides a powerful query language called HQL (Hibernate Query Language) that allows developers to write database queries using Java-like syntax.
 
1. Create a Maven project in your IDE.
2. Add Hibernate dependencies to your `pom.xml` file:
```xml
<dependency>
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.4.32.Final</version>
    </dependency>
-- jakarta.persistence
-- mysql-connector-java
```
3. Create a Hibernate configuration file (`hibernate.cfg.xml`) in the `src/main/resources` directory:
```xml
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database</property>
        <property name="hibernate.connection.username">your_username</property>
        <property name="hibernate.connection.password">your_password</property>
        <mapping class="com.example.YourEntityClass"/>
    </session-factory>

</hibernate-configuration>
``` 
4. Create a table in your MySQL database
5. Create an entity class that represents the table.
6. Create main class to work with ORM.

#### Entity Class
```java
@entity
class employee {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @column(name = "id")
    int id;
    @column(name = "emp-name")
    String Name;
    // getters and setters
    
}
```

**Example**

```java
import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.*;
import org.hibernate.cfg.*;

import javax.security.auth.login.Configuration;

public class HibernateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Employee e = new Employee();
        e.setName("Bibek");
        e.setSalary(50000);
        e.setPersist(e);
        session.getTransaction().commit();
        session.close();
        session = factory.openSession();
        Emp;loyee emp = session.get(Employee.class, 1);
        System.out.println("Employee Name: " + emp.getName());
        session.BeginTransaction();
        e1.setSalary(60000);
        session.Merge(e1);
        session.getTransaction().commit();
        session.close();
    }
}
```

## WebFramework

- A web framework is a software framework designed to aid the development of web applications including web services, web resources, and web APIs.

<u>Java Based web Framework</u>
- Spring Boot\MVC
- JSF (JavaServer Faces)
- Stmts
**Features**
- Security
- Templating
- MVC pattern
- REST
- ORM


## Threading

- Process
- Multithreading
 - To run process at a same time
 ![NO image to show](multithreading-in-java.png)

#### To Create Thread
- By inheriting from thread
- By implementing Runnable interface

#### Life Cycle of Thread

![alt text](thread_life_cycle.jpg)



*Example of thread*
```java
class ThreadDemo implements Runnable{
    Thread t;
    ThreadDemo(){
        t= new Thread(this);
        t.start();
    }
    public void run(){
        for( int i= 0; i<10;i++){
            System.out.println("Hello:"+i);
            try{
                t.sleep(1000);
                
            }catch (Exception e){}
        }
    }
    public static void main(String[] args){
        ThreadDemo obj = new ThreadDemo();
        ThreadDemo obj1 = new ThreadDemo();
        
    }
}
```
###  ️Synchronization
Prevent form accusing sam resources at a time.
#### Types
- Method
- Block


**Example**
```java
class Bank
{
    int Balance = 1000;
    public syncronize void withdraw(string n, int amt) {
        if (Balance >= amt) {
            System.out.println("Successfull Witdraw by " + amt);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                balance -= amt;
            }
        }
        else{
            System.out.println("Balance is not Enough");
        }
    }   
}
```

```java
class BankWithdraw extends Thread{
    BankAccount acc;
    String name;
    int amt;
    BankWithdraw(BankAccount acc, int amt, String n){
        this.acc = acc;
        this.amt = amt;
        this.name = n;
    }
    public void run(){
        acc.withdraw(n,amt);
    }
}

```
```java
class caller
{
    public static void main(String[] args){
        BankAccount AC = new BankAccount();
        BankWithdraw obj1 = new Bankwithdraw(AC, 500, "hari");
        BankWithdraw obj1 = new Bankwithdraw(AC, 400, "Ram");
    }
}

```

---

### Design Pattern
- Design pattern sare proven, reusable solution for common problems in Software design.
#### Types
i. **Singleton** -> Ensure only one instance of a class os created.<br>
![img_1.png](img_1.png)<br>
ii. **Factory** -> Create the object without exposing the instantiation logic.<br>

iii. **Abstract Factory** -> Product Families of related objects without specifying concrete classes.<br>

**Example of Singleton**
```java
class Singleton {
 // Step 1: private static instance
 private static Singleton instance;

 // Step 2: private constructor to prevent instantiation
 private Singleton() {
  System.out.println("Singleton instance created");
 }

 // Step 3: public static method to return the single instance (Thread-safe)
 public static synchronized Singleton getInstance() {
  if (instance == null) {
   instance = new Singleton();
  }
  return instance;
 }
}

class SingletonDemo{
    public static void main(String[] args){
        Singleton obj = Singleton.getinstance();
        Singleton obj1 = Singleton.getInstance();
 }
}
```