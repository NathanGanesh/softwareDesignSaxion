package database;

import model.Medicine;
import model.MedicineType;

import java.util.HashMap;
import java.util.Map;

public class MedicineDB {
    private static Map<String, Medicine> medicines = new HashMap();

    public  void insertMedicine(String name, MedicineType medicineType) {
        medicines.put(name, new Medicine(name, medicineType));
    }

    public  Medicine findMedicine(String medicineName) {
        return medicines.get(medicineName);
    }
}
