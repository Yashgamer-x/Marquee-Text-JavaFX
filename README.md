# MarqueeText

A reusable JavaFX control that scrolls text horizontally when it exceeds the available width. 
Distributed as a **plain library JAR** and intended to be consumed via **Maven**.

---

## Requirements

- **Java** 21 or newer  
- **JavaFX** 25 or newer (not bundled)  
- **Maven** for building and installing the artifact

---

## Build and install

Build the plain JAR from the project root:

```bash
mvn clean package install
```

This will install the dependency to your local maven repository


## How to use it in your project:
### Add the library
```xml
<dependency>
  <groupId>org.yashgamerx</groupId>
  <artifactId>marquee_text</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>

<dependency>
  <groupId>org.openjfx</groupId>
  <artifactId>javafx-controls</artifactId>
  <version>25.0.1</version>
</dependency>
```
