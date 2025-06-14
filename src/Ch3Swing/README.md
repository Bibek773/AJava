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

The Swing class hierarchy builds upon AWT classes and adds a comprehensive set of components. Some of the key classes include:

- `javax.swing.JComponent` - Base class for all Swing components
  - `JLabel`
  - `JButton`
  - `JTextField`
  - `JTextArea`
  - `JPanel`
  - `JFrame`
  - `JDialog`
  - `JCheckBox`
  - `JRadioButton`
  - `JTable`
  - `JTree`
  - `JList`

## 4. Components and Containers

### Components
These are the basic building blocks of a GUI, representing visual elements like buttons, labels, text fields, etc.

Examples:
- `JButton`
- `JLabel`
- `JTextField`

### Containers
Containers are components that hold and organize other components.

Types of containers:
- `JPanel` - A generic container.
- `JFrame` - A top-level window with a title and border.
- `JDialog` - A pop-up dialog window.

Swing components must be added to containers for them to be displayed in the GUI.

---
