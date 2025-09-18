import java.util.Objects;

//TODO risolvere problema loglevel

public class CustomLogLevel {
    private String level;
    private String color;
    private boolean activation;

    public CustomLogLevel(String level, String color, boolean activation){
        this.level = level;
        this.color = color;
        this.activation = activation;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isActivation() {
        return activation;
    }

    public void setActivation(boolean activation) {
        this.activation = activation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LogLevel logLevel = (LogLevel) o;
        return Objects.equals(level, logLevel.level);
    }

    @Override
    public String toString() {
        return "LogLevel{" +
                "level='" + level + '\'' +
                ", color='" + color + '\'' +
                ", activation=" + activation +
                '}';
    }
}
