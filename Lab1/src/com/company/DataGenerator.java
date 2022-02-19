package com.company;

public class DataGenerator {
        private static final String[] NAMES = {"Vlad", "Peter", "Paul", "Lucy", "Jone", "Dmytro", "Alex", "David", "Bogdan", "Mary", "Max", "Tom", "Jane", "Jack"};
    private static final String[] SURNAMES = {"Smith", "Miller", "Taylor", "Anderson", "Johnson", "Reich", "Teague", "Hanlon", "Klovatch", "Haskins", "Robb", "Jackson"};
    private static final String[] PATRONYMICS = {"Wesley", "Eugene", "Lynn", "Roland", "Sue", "James", "Paul", "Loraine", "Marie", "Daniel", "Rebecca", "Kaccy", "Divia", "Ado"};
    private static final String[] ADDRESSES = {"420 N. Santa Anita, Arcadia, CA 91006", "1075 W. I-20, Arlington, TX 76017", "1170 W. Branch St., Arroyo Grande, CA 93420",
            "555 Willie Stargell Ave., Alameda, CA 94501", "190 E. Stacy Rd., Alen, TX 75002", "601 W. Main St. American Fork, UT 84003",
            "600 S. Brookhurst, Anaheim, CA 92804", "1210 N. Atlantic Blvd., Alhambra, CA 91801", "Main Street, Lincoln, NE 68509", "8910 Elmore Lane Greensboro, NC 08322"};
    private static final String[] DIAGNOSES = {"Disc herniation", "Fracture", "Cauda Equina", "Arrhythmia", "Arthritis", "Autism", "Chronic Pain", "Diabetes", "Fibromyalgia", "Fibroids",
            "Heart Disease", "Hepatitis", "Hypothyroidism", "Influenza", "Leukemia", "Liver Failure", "Multiple Sclerosis", "Osteoporosis", "Osteoarthritis", "Pneumonia", "Quadriplegia"};

    public static Patient getRandomPatient() {
        return new Patient(
                (long) (Math.random() * 1e10),
                NAMES[(int) (Math.random() * NAMES.length)],
                SURNAMES[(int) (Math.random() * SURNAMES.length)],
                PATRONYMICS[(int) (Math.random() * PATRONYMICS.length)],
                ADDRESSES[(int) (Math.random() * ADDRESSES.length)],
                "+" + (long) (Math.random() * 1e12),
                (long) (Math.random() * 1e6),
                DIAGNOSES[(int) (Math.random() * DIAGNOSES.length)]
        );
    }
}
