public class Laptops {
    public String model;
    public String manufacturer;
    public String cpu_model;
    public String graphic_card_model;
    public int ram_volume;
    public String diagonal;
    public int disk_size;
    public String os;
    public String color;

    public Laptops(String model, String manufacturer, String cpu_model, String graphic_card_model, int ram_volume, String diagonal, int disk_size, String os, String color){
        this.model = model;
        this.manufacturer = manufacturer;
        this.cpu_model = cpu_model;
        this.graphic_card_model = graphic_card_model;
        this.ram_volume = ram_volume;
        this. diagonal = diagonal;
        this.disk_size = disk_size;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return this.manufacturer + " " + this.model + " " + this.diagonal + "inch " + this.cpu_model + " " + this.ram_volume + "/" + this.disk_size + " " + this.color;
    }
}
