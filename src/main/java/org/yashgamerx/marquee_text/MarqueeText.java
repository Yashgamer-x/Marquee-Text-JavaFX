package org.yashgamerx.marquee_text;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MarqueeText extends Pane {
    private final Label label;
    private final TranslateTransition transition = new TranslateTransition();
    private final DoubleProperty durationSeconds = new SimpleDoubleProperty(this, "durationSeconds", 0);

    public MarqueeText(){
        this(new Label());
    }

    public MarqueeText(Label label){
        this.label = label;
        initialize();
    }

    private void initialize() {
        var rectangleClip = new Rectangle();
        rectangleClip.widthProperty().bind(this.widthProperty());
        rectangleClip.heightProperty().bind(this.heightProperty());
        this.setClip(rectangleClip);

        this.getChildren().add(label);

        transition.setNode(label);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.setCycleCount(Animation.INDEFINITE);

        // Listen for width changes to trigger animation
        this.widthProperty().addListener((obs, oldVal, newVal) -> {
            // Re-check layout bounds after the UI has had a chance to render
            Platform.runLater(this::checkAndStart);
        });
    }

    private void checkAndStart() {
        double containerWidth = this.getWidth();
        double textWidth = label.getLayoutBounds().getWidth();

        // Only start if text is longer than the container
        if (textWidth > containerWidth && containerWidth > 0 && durationSeconds.get() != 0) {
            startAnimation(containerWidth, textWidth);
        } else {
            transition.stop();
            label.setTranslateX(0); // Reset position if it fits
        }
    }

    private void startAnimation(double containerWidth, double textWidth) {
        transition.stop();

        // Start from the right edge, move to the left edge
        transition.setFromX(containerWidth);
        transition.setToX(-textWidth);

        // Use the property value here
        transition.setDuration(Duration.seconds(getDurationSeconds()));
        transition.play();
    }

    // --- FXML Property Accessors ---

    public double getDurationSeconds() {
        return durationSeconds.get();
    }

    public DoubleProperty durationSecondsProperty() {
        return durationSeconds;
    }

    public void setDurationSeconds(double durationSeconds) {
        this.durationSeconds.set(durationSeconds);
    }

    public String getText(){
        return label.getText();
    }

    public void setText(String text){
        label.setText(text);
        Platform.runLater(this::checkAndStart);
    }
}