package model;

public class Medicine {
    private String name;
    private MedicineType medicineType;

    public Medicine(String name, MedicineType medicineType) {
        this.name = name;
        this.medicineType = medicineType;
    }

    @Override
    public String toString() {
        return name + "(" + medicineType +")";
    }
}
