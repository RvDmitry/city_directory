package name.dmitryrazumov.directory.model;

/**
 * Class City
 * Класс характеризует город.
 * @author Dmitry Razumov
 * @version 1
 */
public class City {
    /**
     * Наименование города.
     */
    private String name;
    /**
     * Регион.
     */
    private String region;
    /**
     * Федеральный округ.
     */
    private String district;
    /**
     * Количество жителей города.
     */
    private int population;
    /**
     * Дата основания или первое упоминание.
     */
    private int foundation;

    public City(String name, String region, String district, int population, int foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getFoundation() {
        return foundation;
    }

    public void setFoundation(int foundation) {
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "City{"
                + "name='" + name + '\''
                + ", region='" + region + '\''
                + ", district='" + district + '\''
                + ", population='" + population + '\''
                + ", foundation='" + foundation + '\''
                + '}';
    }
}
