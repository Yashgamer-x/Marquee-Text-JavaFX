# MarqueeText

A reusable JavaFX control that scrolls text horizontally when it exceeds the available width. 
Distributed as a **plain library JAR** and intended to be consumed via **Maven**.

---

## Requirements

- **Java** 25 or newer  
- **JavaFX** 25 or newer (not bundled)  
- **Maven** for building and installing the artifact

---

## Build and install

Build the plain JAR from the project root:

```bash
mvn clean package install
```

This will install the dependency to your local maven repository

---

## How to use it in your project:
### Add the library
```xml
<dependency>
  <groupId>org.yashgamerx</groupId>
  <artifactId>marquee_text</artifactId>
  <version>1.0</version>
</dependency>

<dependency>
  <groupId>org.openjfx</groupId>
  <artifactId>javafx-controls</artifactId>
  <version>25.0.1</version>
</dependency>
```
**Note:** JavaFX is not bundled. 
The consuming application must provide the JavaFX runtime
---

## Usage examples
### FXML
```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import org.yashgamerx.marquee_text.MarqueeText?>

<MarqueeText
    prefWidth="300"
    prefHeight="40"
    text="This text will scroll when it exceeds the width"
    durationSeconds="10"/>
```
* **Attribute:** `text` maps to `setText(String);`
`durationSeconds` controls scroll speed.
* **Behavior:** animation starts automatically when the text exceeds the available width.

### Java Code
```java
import org.yashgamerx.marquee_text.MarqueeText;

MarqueeText marquee = new MarqueeText();
marquee.setText("Scrolling text");
marquee.setDurationSeconds(10);
```
---

## Modular and non modular usage:
### Modular:
```java
module your.app {
    requires javafx.controls;
    requires org.yashgamerx.marquee_text;
}
```
