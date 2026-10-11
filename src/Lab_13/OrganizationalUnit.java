package Lab_13;

public abstract class OrganizationalUnit {
    private static int counter = 0;
    private int id;
    private String name;
    private String status;

    public OrganizationalUnit(String name, String status) {
        this.id = ++counter;
        setName(name);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Без названия";
        } else {
            this.name = name.trim();
        }
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            this.status = "Не указан";
        } else {
            this.status = status.trim();
        }
    }

    // Неабстрактный метод
    public String getBasicInfo() {
        return String.format("ID: %d | Название: %s | Статус: %s", id, name, status);
    }

    // Абстрактный метод
    public abstract void calculateEfficiency();

    // Статический метод
    public static int getTotalUnitsCreated() {
        return counter;
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}