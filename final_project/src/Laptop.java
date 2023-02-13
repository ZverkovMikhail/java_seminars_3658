import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * класс Ноутбук для магазина техники
 */
public class Laptop {
    private String brand;
    private String model;
    private String color;
    private String os;
    private int hddSize;
    private int ramSize;
    private int cpuSpeed;

    public Laptop(String brand, String model, String color, String os, int hddSize, int ramSize, int cpuSpeed) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.os = os;
        this.hddSize = hddSize;
        this.ramSize = ramSize;
        this.cpuSpeed = cpuSpeed;
    }

    public String brand() {
        return brand;
    }

    public String model() {
        return model;
    }

    public String color() {
        return color;
    }

    public String os() {
        return os;
    }

    public int hddSize() {
        return hddSize;
    }

    public int ramSize() {
        return ramSize;
    }

    public int cpuSpeed() {
        return cpuSpeed;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", os='" + os + '\'' +
                ", hddSize=" + hddSize +
                ", ramSize=" + ramSize +
                ", cpuSpeed=" + cpuSpeed +
                '}';
    }

    /**
     * Проверяет соответствует ли ноутбук критериям фильтрации
     * @param criteria кретерии фильтрации
     * @return отвечает ли ноутбук критериям поиска
     */
    public boolean isMeets(Map<String, Object> criteria) {
        boolean isMeets = true;
        for (Map.Entry<String, Object> ent : criteria.entrySet()) {
            try {
                Method method = this.getClass().getMethod(ent.getKey());
                Object selfValue = method.invoke(this);
                Object value = ent.getValue();

                if (selfValue instanceof String && value instanceof String) {
                    selfValue = ((String) selfValue).toLowerCase();
                    value = ((String) value).toLowerCase();

                        isMeets = selfValue.equals(value);

                } else if (selfValue instanceof Integer && value instanceof Integer) {

                        isMeets = (int) selfValue >= (int) value;

                }


            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                isMeets = false;
            }
            // если одно из значений не соответствует
            if (!isMeets)
                return false;
        }

        return true;
    }
}
