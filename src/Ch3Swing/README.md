# Introduction to AWT and Swing

## 1. Concept

### AWT (Abstract Window Toolkit)
AWT is Java's original platform-dependent windowing, graphics, and user-interface widget toolkit. It provides the foundation for building graphical user interfaces (GUIs) in Java.

- It is part of the Java Foundation Classes (JFC).
- AWT components are "heavyweight" because they rely on the underlying operating system's windowing components.

### Swing

Swing is a GUI widget toolkit for Java, developed as a part of the Java Foundation Classes (JFC). It is built on top of AWT and provides a richer set of GUI components.

- Swing components are "lightweight" as they are written entirely in Java and do not rely on native GUI components.
- It provides a more flexible and customizable interface than AWT.

## 2. Applets

Applets are small Java programs that can be embedded in a webpage and run in the context of a browser.

- They extend the `java.applet.Applet` class (AWT-based) or `javax.swing.JApplet` class (Swing-based).
- Applets are now considered outdated and are not commonly used in modern Java applications due to security and compatibility issues.

## 3. Swing Class Hierarchy
![not available](SwingClasshierrarchy.png)


### 🔺 Top Level: `Object`

- The root of all Java classes.
- Every class in Java implicitly extends `Object`.

### 🔹 `Component`

- The superclass for all AWT (Abstract Window Toolkit) components.
- It provides basic GUI features like size, location, and visibility.


### 🔹 `Container` (extends `Component`)

- A `Component` that can contain other components.
- Key for building UI layouts.

### 🔹 From `Container` it splits into three branches:
#### 📦 1. **Window → Frame → JFrame**
- `Window`: A top-level window with no borders or menu.
- `Frame`: A decorated window (with title, buttons, etc.).
- `JFrame`: A Swing version of `Frame`, commonly used for main application windows.

#### 📦 2. **Panel → Applet → JApplet**

- `Panel`: A generic container for organizing components.
- `Applet`: A container for Java applets (browser-embedded mini-apps).
- `JApplet`: Swing-based version of `Applet` with richer features.

#### 📦 3. **JComponent** (Core of Swing Components)

- All lightweight Swing components extend `JComponent`.
- Provides support for pluggable look-and-feel, double buffering, etc.

### ▶️ Under `JComponent`, it branches into:

#### ➤ `AbstractButton` → `JButton`, `JToggleButton` → `JCheckBox`

- `AbstractButton`: Base class for buttons.
- `JButton`: A push button.
- `JToggleButton`: A button that maintains its state (on/off).
- `JCheckBox`: A checkbox (a special kind of toggle button).

#### ➤ `JLabel`

- A component that displays a short string or an image icon.

#### ➤ `JComboBox`

- A drop-down list for selecting one item.


#### ➤ `JList`

- Displays a list of items for selection.

#### ➤ `JProgressBar`

- Displays progress visually for a task.

---

| Java AWT                                           | Java Swing                                                                            |
|----------------------------------------------------|---------------------------------------------------------------------------------------|
| ` It is an api to develop GUI application in Java. | It is the part of java  Foundation Classes and is used to create various application. |
|   Components of AWT are heavy weighted.            |  The components of Java Swing are lightweight.                                      |
|   Components are platform dependent.              |       Components are platform independent.                                            |
|   Execution Time is more than Swing.             |          Execution Time is less than AWT.                    |
|   AWT components require java.awt package.              |       Swing components requires javax.swing package.                          |



---

## ✳️ GUI Control in Java

Java offers powerful tools to create Graphical User Interfaces (GUIs). The two primary libraries are:

* **Swing** – Part of Java’s standard library, built on top of AWT.
* **JavaFX** – A modern framework with support for styling, animation, and FXML.

---

## 🌀 Java Swing Controls

Swing components reside in the `javax.swing` package. They are:

* Lightweight
* Platform-independent
* More flexible than AWT

### 🔹 Common Swing Components

| **Control**    | **Class**            | **Purpose**                        |
| -------------- | -------------------- | ---------------------------------- |
| Label          | `JLabel`             | Display text/image (non-editable)  |
| Button         | `JButton`            | Triggers an action on click        |
| Text Field     | `JTextField`         | Single-line text input             |
| Password Field | `JPasswordField`     | Input field for passwords (masked) |
| Text Area      | `JTextArea`          | Multi-line text input              |
| Check Box      | `JCheckBox`          | Multiple-choice selection          |
| Radio Button   | `JRadioButton`       | Single-choice option               |
| Button Group   | `ButtonGroup`        | Groups radio buttons               |
| Combo Box      | `JComboBox`          | Drop-down selection                |
| List           | `JList`              | List of selectable items           |
| Table          | `JTable`             | Displays data in tabular format    |
| Tree           | `JTree`              | Hierarchical data display          |
| Slider         | `JSlider`            | Select value in a range            |
| Progress Bar   | `JProgressBar`       | Indicates progress                 |
| Menu           | `JMenu`, `JMenuItem` | Creates menus                      |
| Panel          | `JPanel`             | Container for components           |
| Frame          | `JFrame`             | Top-level application window       |
| Dialog         | `JDialog`            | Pop-up window for input/messages   |
| ToolTip        | `setToolTipText()`   | Hover-help messages                |
| Scroll Pane    | `JScrollPane`        | Adds scrollable area               |

### 🧱 Layout Managers in Swing

Control component arrangement within containers:

* `FlowLayout`
* `BorderLayout`
* `GridLayout`
* `BoxLayout`
* `GridBagLayout`
* `GroupLayout` (NetBeans GUI Builder)

---

## 🎨 JavaFX Controls

JavaFX is the modern alternative to Swing with enhanced features like:

* CSS styling
* FXML for UI design
* Smooth graphics and animation

### 🔹 Common JavaFX Components

| **Control**    | **Class**         | **Purpose**                   |
| -------------- | ----------------- | ----------------------------- |
| Label          | `Label`           | Display text or graphic       |
| Button         | `Button`          | Triggers an action            |
| Text Field     | `TextField`       | Single-line text input        |
| Password Field | `PasswordField`   | Password input                |
| Text Area      | `TextArea`        | Multi-line text input         |
| Check Box      | `CheckBox`        | Multiple-choice selection     |
| Radio Button   | `RadioButton`     | Single-choice option          |
| Toggle Group   | `ToggleGroup`     | Groups radio buttons          |
| Combo Box      | `ComboBox<T>`     | Drop-down menu                |
| List View      | `ListView<T>`     | Scrollable item list          |
| Table View     | `TableView<T>`    | Data in a table               |
| Tree View      | `TreeView<T>`     | Hierarchical data             |
| Slider         | `Slider`          | Value range input             |
| Progress Bar   | `ProgressBar`     | Task progress indicator       |
| Menu Bar       | `MenuBar`, `Menu` | Menus and submenus            |
| ImageView      | `ImageView`       | Display images                |
| WebView        | `WebView`         | HTML content view             |
| AnchorPane     | `AnchorPane`      | Absolute layout               |
| VBox / HBox    | `VBox`, `HBox`    | Vertical or horizontal layout |
| BorderPane     | `BorderPane`      | 5-region layout               |
| StackPane      | `StackPane`       | Stack components              |
| Scene          | `Scene`           | Holds the UI                  |
| Stage          | `Stage`           | Top-level window              |

---

## ⚖️ Comparison: Swing vs JavaFX

| **Feature**      | **Swing**            | **JavaFX**                |
| ---------------- | -------------------- | ------------------------- |
| Styling          | Basic (no CSS)       | CSS-based styling         |
| UI Design Tool   | NetBeans GUI Builder | SceneBuilder (FXML)       |
| Performance      | Slower               | Better graphics/animation |
| Layout           | Manual/complex       | Declarative and flexible  |
| Graphics Support | Limited              | Rich multimedia support   |
| UI Design        | Outdated             | Modern and responsive     |

---

## ✅ Sample Code: Swing

```java
import javax.swing.*;

public class SwingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing GUI Example");
        JButton button = new JButton("Click Me");

        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Hello, Swing!"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(button);
        frame.setVisible(true);
    }
}
```

---

## ✅ Sample Code: JavaFX

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXExample extends Application {
    public void start(Stage stage) {
        Button btn = new Button("Click Me");
        btn.setOnAction(e -> System.out.println("Hello, JavaFX!"));

        StackPane root = new StackPane(btn);
        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("JavaFX GUI Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```

---

## 🧾 Menus in Java GUI

### 🔷 Swing Menu Components

| **Component**          | **Description**            |
| ---------------------- | -------------------------- |
| `JMenuBar`             | Menu bar container         |
| `JMenu`                | Drop-down menu             |
| `JMenuItem`            | Menu item                  |
| `JCheckBoxMenuItem`    | Menu checkbox option       |
| `JRadioButtonMenuItem` | Menu radio button          |
| `JPopupMenu`           | Context menu (right-click) |
| `JSeparator`           | Separator line             |

**Example:**

```java
JMenuBar menuBar = new JMenuBar();
JMenu fileMenu = new JMenu("File");
JMenuItem openItem = new JMenuItem("Open");
JMenuItem exitItem = new JMenuItem("Exit");

exitItem.addActionListener(e -> System.exit(0));
fileMenu.add(openItem);
fileMenu.addSeparator();
fileMenu.add(exitItem);

menuBar.add(fileMenu);
frame.setJMenuBar(menuBar);
```

---

### 🟢 JavaFX Menu Components

| **Component**       | **Description**          |
| ------------------- | ------------------------ |
| `MenuBar`           | Top menu bar             |
| `Menu`              | Drop-down menu           |
| `MenuItem`          | Standard menu option     |
| `CheckMenuItem`     | Checkbox-style menu item |
| `RadioMenuItem`     | Radio-style menu item    |
| `ContextMenu`       | Right-click menu         |
| `SeparatorMenuItem` | Menu divider             |

**Example:**

```java
MenuBar menuBar = new MenuBar();
Menu fileMenu = new Menu("File");

MenuItem open = new MenuItem("Open");
MenuItem exit = new MenuItem("Exit");
exit.setOnAction(e -> Platform.exit());

fileMenu.getItems().addAll(open, new SeparatorMenuItem(), exit);
menuBar.getMenus().add(fileMenu);

VBox root = new VBox(menuBar);
Scene scene = new Scene(root, 400, 300);
stage.setScene(scene);
```

---

## 💡 ToolTips in Java GUI

ToolTips provide quick hints when hovering over elements.

### 🔷 Swing

```java
JButton button = new JButton("Hover Me");
button.setToolTipText("Click this to perform action");
```

### 🟢 JavaFX

```java
Button button = new Button("Hover Me");
Tooltip tooltip = new Tooltip("Click this to perform action");
Tooltip.install(button, tooltip);
```

Or:

```java
button.setTooltip(new Tooltip("Click this to perform action"));
```

---

## 🪟 Windows & Dialogs in Java GUI

### 🧱 Java Swing - `JFrame` (Main Window)

```java
JFrame frame = new JFrame("My Window");
frame.setSize(400, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
```

**Key Methods:**

* `setTitle()`
* `setSize()`
* `setVisible()`
* `setDefaultCloseOperation()`
* `add(Component)`

---

### 💬 Swing Dialogs

**1. JOptionPane** – Quick built-in dialogs

```java
JOptionPane.showMessageDialog(null, "Hello!");
int choice = JOptionPane.showConfirmDialog(null, "Continue?");
String name = JOptionPane.showInputDialog("Enter name:");
```

**2. JDialog** – Custom dialog window

```java
JDialog dialog = new JDialog(frame, "Custom Dialog", true);
dialog.setSize(200, 150);
dialog.setLayout(new FlowLayout());
dialog.add(new JLabel("Custom Dialog"));
dialog.setVisible(true);
```

---

### 🧱 JavaFX - `Stage` (Window)

```java
@Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("JavaFX Window");
    StackPane root = new StackPane(new Label("Hello JavaFX!"));
    Scene scene = new Scene(root, 400, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
}
```

**Create another window:**

```java
Stage newStage = new Stage();
newStage.setTitle("Second Window");
newStage.setScene(new Scene(new StackPane(new Label("Another window")), 200, 100));
newStage.show();
```

---

### 💬 JavaFX Dialogs

**1. Alert**

```java
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Info");
alert.setHeaderText("Header");
alert.setContentText("This is an info alert");
alert.showAndWait();
```

**2. TextInputDialog**

```java
TextInputDialog dialog = new TextInputDialog("default");
dialog.setTitle("Input");
dialog.setHeaderText("Enter your name");
Optional<String> result = dialog.showAndWait();
result.ifPresent(name -> System.out.println("Name: " + name));
```

**3. ChoiceDialog**

```java
List<String> choices = Arrays.asList("Red", "Green", "Blue");
ChoiceDialog<String> dialog = new ChoiceDialog<>("Green", choices);
dialog.setTitle("Choose Color");
dialog.setContentText("Pick one:");
Optional<String> result = dialog.showAndWait();
result.ifPresent(color -> System.out.println("You chose: " + color));
```


---

## 📌 What is Event Handling?

Event handling is the mechanism that controls the event and decides what should happen if an event occurs (e.g., button click, key press, mouse movement).

**Three main steps:**

1. **Event Source** – the component that generates the event (e.g., a button).
2. **Event Object** – contains information about the event.
3. **Event Listener** – interface that receives and handles the event.

---

## ✅ Event Handling in Swing

Swing uses the **delegation event model**.

### 🔸 Common Listener Interfaces

| Listener Interface    | Triggered By                       |
| --------------------- | ---------------------------------- |
| `ActionListener`      | Buttons, menu items                |
| `ItemListener`        | Checkbox, radio buttons            |
| `MouseListener`       | Mouse events (click, press, enter) |
| `MouseMotionListener` | Mouse motion (drag, move)          |
| `KeyListener`         | Keyboard inputs                    |
| `WindowListener`      | Window events (close, open)        |
| `FocusListener`       | Focus gained/lost                  |

---

### ✅ Example: ActionListener (Button Click)

```java
import javax.swing.*;
import java.awt.event.*;

public class EventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Example");
        JButton button = new JButton("Click Me");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button Clicked!");
            }
        });

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
        frame.setVisible(true);
    }
}
```

---

### 🧠 Tips:

* You can use **lambda expressions** (Java 8+) for cleaner code:

```java
button.addActionListener(e -> System.out.println("Clicked"));
```

---

## ✅ Event Handling in JavaFX

JavaFX uses a more modern approach with **Event Handlers**, **Lambdas**, and **Property Bindings**.

### 🔸 Common Event Classes

| Event Class   | Used For                |
| ------------- | ----------------------- |
| `ActionEvent` | Button click, menu item |
| `MouseEvent`  | Mouse actions           |
| `KeyEvent`    | Keyboard actions        |
| `WindowEvent` | Stage/window events     |

---

### ✅ Example: Button Click in JavaFX

```java
Button btn = new Button("Click Me");
btn.setOnAction(e -> System.out.println("Button clicked"));
```

#### Traditional way with `EventHandler`:

```java
btn.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Button clicked");
    }
});
```

---

### 🔹 Other JavaFX Events

```java
scene.setOnKeyPressed(e -> System.out.println("Key Pressed: " + e.getCode()));

button.setOnMouseEntered(e -> System.out.println("Mouse entered button"));
```


---



# ⚔️ JavaFX vs Swing – Java GUI Toolkit Comparison

Java has two main GUI frameworks: **Swing** (older) and **JavaFX** (modern). Here’s how they compare:

## 🧱 1. **Overview**

| Feature      | Swing                     | JavaFX                   |
| ------------ | ------------------------- | ------------------------ |
| Release Year | 1997 (Java 1.2)           | 2011 (Java 8 integrated) |
| Type         | Lightweight GUI toolkit   | Modern, rich GUI toolkit |
| Look & Feel  | Old-style, OS-native look | Customizable, modern UI  |
| Architecture | MVC-like                  | Scene Graph              |

---

## 🎨 2. **UI Components**

| Swing                     | JavaFX                      |
| ------------------------- | --------------------------- |
| `JFrame`, `JButton`, etc. | `Stage`, `Button`, etc.     |
| Components = widgets      | Nodes in a scene graph      |
| Less customizable         | CSS-styled, rich components |
| Complex custom UIs hard   | Easy animations & effects   |

---

## 🎭 3. **Design Approach**

| Feature        | Swing            | JavaFX                       |
| -------------- | ---------------- | ---------------------------- |
| Layout         | Layout Managers  | AnchorPane, VBox, HBox, etc. |
| Styling        | Java code/manual | CSS-based                    |
| UI Separation  | Not ideal        | Uses FXML for separation     |
| Declarative UI | ❌                | ✅ (FXML + SceneBuilder)      |

---

## ⚙️ 4. **Event Handling**

| Aspect         | Swing                         | JavaFX                       |
| -------------- | ----------------------------- | ---------------------------- |
| Listeners      | Implement listener interfaces | Use lambdas or EventHandlers |
| Lambda Support | Java 8+ only                  | Fully supported              |
| Simplicity     | Verbose                       | Clean and modern             |

---

## 🎞️ 5. **Multimedia & Animation**

| Feature        | Swing             | JavaFX                             |
| -------------- | ----------------- | ---------------------------------- |
| Video/Audio    | Hard to implement | Built-in support via `Media`       |
| 2D/3D Graphics | Basic             | Advanced 2D/3D API                 |
| Animation      | Manual            | Easy with `Timeline`, `Transition` |

---

## 🌐 6. **Web Integration**

| Feature     | Swing             | JavaFX                |
| ----------- | ----------------- | --------------------- |
| HTML/CSS UI | Not supported     | Supported             |
| Web View    | No browser engine | `WebView` uses WebKit |

---

## 🛠️ 7. **Development Tools**

| Tooling Support | Swing          | JavaFX                         |
| --------------- | -------------- | ------------------------------ |
| IDE Support     | All major IDEs | All major IDEs                 |
| UI Designer     | None official  | **SceneBuilder** (Drag & Drop) |
| FXML            | ❌              | ✅ XML-based UI files           |

---

## 🚀 8. **Performance & Modern Use**

| Feature        | Swing                        | JavaFX                              |
| -------------- | ---------------------------- | ----------------------------------- |
| Performance    | Faster startup (lightweight) | Slightly heavier but smoother       |
| Mobile Support | No                           | Limited (via Gluon for Android/iOS) |
| Active Dev     | Maintenance only             | Actively developed (OpenJFX)        |

---

## 🧮 9. Summary Table

| Category   | Swing                   | JavaFX                |
| ---------- | ----------------------- | --------------------- |
| Maturity   | Very mature             | Newer but growing     |
| Styling    | Basic                   | CSS-powered           |
| UI Design  | Code-heavy              | SceneBuilder + FXML   |
| Multimedia | Poor                    | Strong support        |
| Best For   | Legacy apps, simple UIs | Modern apps, rich UIs |

---

## ✅ Which One to Use?

| Use Case                                 | Recommended |
| ---------------------------------------- | ----------- |
| Maintaining legacy applications          | **Swing**   |
| Building modern, stylish Java apps       | **JavaFX**  |
| Need rich media, animation, and effects  | **JavaFX**  |
| Learning for future Java GUI development | **JavaFX**  |

---
