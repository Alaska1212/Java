package hw3.B03_13;
import java.util.Objects;

public class House {
    private int number;
    private double area;
    private String address;
    private int serviceLife;

    public House() {
        this(0, 0.0, "", 0);
    }

    public House(int number, double area, String address, int serviceLife) {
        this.number = number;
        this.area = area;
        this.address = address == null ? "" : address.trim();
        this.serviceLife = serviceLife;
    }

    public House(House other) {
        this(other.number, other.area, other.address, other.serviceLife);
    }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address == null ? "" : address.trim(); }

    public int getServiceLife() { return serviceLife; }
    public void setServiceLife(int serviceLife) { this.serviceLife = serviceLife; }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof House))
            return false;
        House house = (House) o;
        return number == house.number &&
                Objects.equals(address, house.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, address);
    }

    @Override
    public String toString() {
        return String.format("№%d, %.2f м^2, %s, термін: %d р.",
                number, area, address, serviceLife);
    }

    public static House[] filterByServiceLife(House[] src, int minYearsExclusive) {
        if (src == null) return new House[0];
        int cnt = 0;
        for (House h : src)
            if (h != null && h.serviceLife > minYearsExclusive) cnt++;
        House[] res = new House[cnt];
        int i = 0;
        for (House h : src)
            if (h != null && h.serviceLife > minYearsExclusive)
                res[i++] = new House(h);
        return res;
    }

    public static House[] sortedByAreaAtAddress(House[] src, String addr) {
        if (src == null)
            return new House[0];
        String key = addr == null ? "" : addr.trim();
        int counter = 0;
        for (House h : src)
            if (h != null && h.address.equalsIgnoreCase(key))
                counter++;
        House[] res = new House[counter];
        int i = 0;
        for (House h : src)
            if (h != null && h.address.equalsIgnoreCase(key))
                res[i++] = new House(h);

        java.util.Arrays.sort(res, java.util.Comparator.comparingDouble(House::getArea));
        return res;
    }
}
