package model;

public class Prescription {
    private String amount;
    private Medicine medicine;
    private String dosage;
    private String frequency;
    private int refills;

    public Prescription(Medicine medicine, String amount, String dosage, String frequency, int refills) {
        this.medicine = medicine;
        this.amount = amount;
        this.dosage = dosage;
        this.frequency = frequency;
        this.refills = refills;
    }

    public String toString() {
        return String.format("%s, %s: - %-10s %-10s (%d refills)", medicine.toString(), amount, dosage, frequency, refills);
    }

    public int getRemainingRefills() {
        return refills;
    }

    public void decreaseRefills() {
        if (refills > 0) {
            refills--;
        }
    }

    public String getMedicine() {
        return medicine.toString();
    }

    public String getAmount() {
        return amount;
    }
}
