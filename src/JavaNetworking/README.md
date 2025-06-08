# Java Networking

Java Networking enables communication between computers over a network using the Java platform. It is part of the `java.net` package, which provides classes for both low-level and high-level network communication.

---

## 📡 Key Concepts

### 1. **IP Address**
- A unique address that identifies a device on the internet or local network.
- Types: IPv4 (32-bit), IPv6 (128-bit), public, private
- port: point of communication

### 2. **Port Number**
- Logical address used to identify specific processes/services on a device.
- Ranges from 0 to 65535.

### 3. **Socket**
- Endpoint for communication between two machines.
- Used in both TCP and UDP protocols.

---

## 🔌 Important Classes in `java.net`

| Class         | Description                                              |
|---------------|----------------------------------------------------------|
| `InetAddress` | Represents an IP address.                                |
| `Socket`      | Implements a client socket (TCP).                        |
| `ServerSocket`| Waits for requests from clients and establishes a connection. |
| `DatagramSocket` | Enables sending and receiving UDP packets.          |
| `DatagramPacket` | Represents a UDP packet of data.                     |
| `URL`         | Represents a Uniform Resource Locator.                   |
| `URLConnection`| Communicates with the resource referenced by a URL.     |

---

## 🔄 TCP vs UDP

| TCP                                | UDP                             |
|-------------------------------------|----------------------------------|
| Connection-oriented                 | Connectionless                   |
| Reliable (acknowledgment-based)     | Unreliable                       |
| Slower                              | Faster                           |
| Web, Email, File Transfer           | Streaming, Gaming, VoIP          |
| Acknoledgement                      | NoAcknowdlege                    |
| HandShaking                         | NoHandshaking                    |

---

## 💻 TCP Example (Client & Server)

### TCP Server
```java
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        Socket socket = server.accept();
        DataInputStream input = new DataInputStream(socket.getInputStream());
        System.out.println("Client says: " + input.readUTF());
        input.close();
        socket.close();
        server.close();
    }
}
