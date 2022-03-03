package homework_2;

public class Notebook implements Comparable<Notebook> {
    private String manufacturer;
    private int manufacturerIndex;
    private int ram;
    private int ramIndex;
    private int price;
    private int priceIndex;

    private final String listManufacturer = "Lenovo, Asos, MacNote, Acer, Xiaomi";
    private int[] rams = new int[]{4, 8, 12, 16, 20, 24};

    public Notebook() {
        int manufacturerIndex = (int) Math.round(Math.random() * (listManufacturer.split(", ").length - 1));
        setManufacturerIndex(manufacturerIndex);
        setManufacturer(getListManufacturer(manufacturerIndex));
        int index = (int) (Math.random() * rams.length);
        setRamIndex(index);
        setRam(rams[index]);
        int indexPrice = (int) (Math.random() * 31);
        setPriceIndex(indexPrice);
        setPrice(500 + 50 * indexPrice);
    }

    public int getPriceIndex() {
        return priceIndex;
    }

    public void setPriceIndex(int priceIndex) {
        this.priceIndex = priceIndex;
    }

    public int getRamIndex() {
        return ramIndex;
    }

    public void setRamIndex(int ramIndex) {
        this.ramIndex = ramIndex;
    }

    public int getManufacturerIndex() {
        return manufacturerIndex;
    }

    public void setManufacturerIndex(int manufacturerIndex) {
        this.manufacturerIndex = manufacturerIndex;
    }

    public String getListManufacturer(int s) {
        return listManufacturer.split(", ")[s];
    }

    public int getListManufacturerLength() {
        return listManufacturer.split(", ").length;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getRamsLength() {
        return rams.length;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public int getPriceLength() {
        return ((2000-500)/50 + 1);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Производитель = '").append(manufacturer).append('\'');
        sb.append(",  Оперативная память = ").append(ram);
        sb.append(",  цена = ").append(price);
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Notebook o) {
        return this.getPrice() - o.getPrice();
    }
}
