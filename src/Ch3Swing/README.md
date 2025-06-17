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

Here is a complete note on **Java GUI Controls** covering both **Swing** and **JavaFX**, which you can use in your README file or as documentation:

---



## ✳️ GUI Control

Java provides powerful libraries for creating Graphical User Interfaces (GUIs). The two main libraries are:

* **Swing** – part of Java’s standard library, built on top of AWT.
* **JavaFX** – a modern, rich-client GUI framework.

---

#### 🌀 Java Swing GUI Controls

Swing components are part of the `javax.swing` package. They are lightweight, platform-independent, and more flexible than AWT.

#### 🔹 Common Swing Controls

| Control            | Class                | Description                           |
| ------------------ | -------------------- | ------------------------------------- |
| **Label**          | `JLabel`             | Displays text or image (non-editable) |
| **Button**         | `JButton`            | Triggers action on click              |
| **Text Field**     | `JTextField`         | Single-line text input                |
| **Password Field** | `JPasswordField`     | Input for passwords (masked)          |
| **Text Area**      | `JTextArea`          | Multi-line text input                 |
| **Check Box**      | `JCheckBox`          | Select/deselect options               |
| **Radio Button**   | `JRadioButton`       | Choose one option in a group          |
| **Button Group**   | `ButtonGroup`        | Groups radio buttons                  |
| **Combo Box**      | `JComboBox`          | Dropdown selection list               |
| **List**           | `JList`              | Select one or more items              |
| **Table**          | `JTable`             | Displays data in tabular form         |
| **Tree**           | `JTree`              | Displays hierarchical data            |
| **Slider**         | `JSlider`            | Choose value from a range             |
| **Progress Bar**   | `JProgressBar`       | Shows progress of a task              |
| **Menu**           | `JMenu`, `JMenuItem` | Create menus                          |
| **Panel**          | `JPanel`             | Container for components              |
| **Frame**          | `JFrame`             | Top-level window                      |
| **Dialog**         | `JDialog`            | Pop-up window for input or messages   |
| **ToolTip**        | `setToolTipText()`   | Help messages when hovered            |
| **Scroll Pane**    | `JScrollPane`        | Adds scrollable area                  |

#### 🧱 Swing Layout Managers

Used to arrange components in containers.

* `FlowLayout`
* `BorderLayout`
* `GridLayout`
* `BoxLayout`
* `GridBagLayout`
* `GroupLayout` (used in NetBeans GUI Builder)

---

### 🎨 JavaFX GUI Controls

JavaFX is the successor to Swing. It supports modern UI elements, CSS styling, and FXML for UI design.

#### 🔹 Common JavaFX Controls

| Control            | Class             | Description                             |
| ------------------ | ----------------- | --------------------------------------- |
| **Label**          | `Label`           | Display text or graphics                |
| **Button**         | `Button`          | Performs actions                        |
| **Text Field**     | `TextField`       | Single-line text input                  |
| **Password Field** | `PasswordField`   | Password input                          |
| **Text Area**      | `TextArea`        | Multi-line text input                   |
| **Check Box**      | `CheckBox`        | Multiple selection options              |
| **Radio Button**   | `RadioButton`     | Single choice options                   |
| **Toggle Group**   | `ToggleGroup`     | Group radio buttons                     |
| **Combo Box**      | `ComboBox<T>`     | Dropdown menu                           |
| **List View**      | `ListView<T>`     | Scrollable list                         |
| **Table View**     | `TableView<T>`    | Data in table form                      |
| **Tree View**      | `TreeView<T>`     | Hierarchical data                       |
| **Slider**         | `Slider`          | Value range input                       |
| **Progress Bar**   | `ProgressBar`     | Progress indicator                      |
| **Menu Bar**       | `MenuBar`, `Menu` | Menus and submenus                      |
| **ImageView**      | `ImageView`       | Displays images                         |
| **WebView**        | `WebView`         | Displays HTML content                   |
| **AnchorPane**     | `AnchorPane`      | Absolute positioning                    |
| **VBox/HBox**      | `VBox`, `HBox`    | Vertical or horizontal layout           |
| **BorderPane**     | `BorderPane`      | Top, Bottom, Left, Right, Center layout |
| **StackPane**      | `StackPane`       | Stacks children on top of each other    |
| **Scene**          | `Scene`           | Container for UI                        |
| **Stage**          | `Stage`           | Top-level window                        |

---

### ⚖️ Swing vs JavaFX

| Feature          | Swing                | JavaFX                        |
| ---------------- | -------------------- | ----------------------------- |
| Styling          | Basic, no CSS        | CSS-based styling             |
| UI Design Tool   | NetBeans GUI Builder | SceneBuilder (FXML)           |
| Performance      | Slower than JavaFX   | Better graphics and animation |
| Layout           | Complex (manual)     | Flexible (layout panes)       |
| Graphics Support | Limited              | Rich graphics API             |
| Modern UI        | Outdated             | Modern and responsive         |

---

### ✅ Sample Code (Swing)

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

### ✅ Sample Code (JavaFX)

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


## 🧾 Menu Elements in Java GUI

Menus are used to group commands or options in GUI applications.

### 🔷 Swing Menu Components

| Component              | Description                        |
| ---------------------- | ---------------------------------- |
| `JMenuBar`             | Top-level menu bar container       |
| `JMenu`                | Represents a single drop-down menu |
| `JMenuItem`            | A menu item inside `JMenu`         |
| `JCheckBoxMenuItem`    | Checkbox in a menu                 |
| `JRadioButtonMenuItem` | Radio button inside a menu         |
| `JPopupMenu`           | Right-click context menu           |
| `JSeparator`           | Horizontal line separator          |

#### ✅ Example (Swing Menu)

```java
JMenuBar menuBar = new JMenuBar();

JMenu fileMenu = new JMenu("File");
JMenuItem openItem = new JMenuItem("Open");
JMenuItem exitItem = new JMenuItem("Exit");

exitItem.addActionListener(e -> System.exit(0));
fileMenu.add(openItem);
fileMenu.addSeparator();  // adds a line
fileMenu.add(exitItem);

menuBar.add(fileMenu);
frame.setJMenuBar(menuBar);
```

---

### 🟢 JavaFX Menu Components

| Component           | Description              |
| ------------------- | ------------------------ |
| `MenuBar`           | Top menu bar             |
| `Menu`              | Drop-down menu           |
| `MenuItem`          | Basic menu item          |
| `CheckMenuItem`     | Checkbox-style menu item |
| `RadioMenuItem`     | Radio-style menu item    |
| `ContextMenu`       | Right-click popup menu   |
| `SeparatorMenuItem` | Divider inside a menu    |

#### ✅ Example (JavaFX Menu)

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

ToolTips show helpful text when a user hovers over a GUI element.

### 🔷 Swing ToolTip

* Use `setToolTipText("your message")` on any Swing component.

#### ✅ Example

```java
JButton button = new JButton("Hover Me");
button.setToolTipText("Click this to perform action");
```

### 🟢 JavaFX Tooltip

* Use `Tooltip` class and `Tooltip.install(node, tooltip)` method.

#### ✅ Example

```java
Button button = new Button("Hover Me");
Tooltip tooltip = new Tooltip("Click this to perform action");
Tooltip.install(button, tooltip);
```

You can also directly set it like this:

```java
button.setTooltip(new Tooltip("Click this to perform action"));
```

---
