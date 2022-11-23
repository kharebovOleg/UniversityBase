package Enums;

public enum StudentsSorting {
    ID("ПО ID УНИВЕРА"),
    FULLNAME("ПО ИМЕНИ"),
    COURSE("ПО КУРСУ"),
    AVGEXAM("ПО СРЕДНЕЙ ОЦЕНКЕ");

    StudentsSorting(String sortingVariant) {
        this.sortingVariant = sortingVariant;
    }

    public String getSortingVariant() {
        return sortingVariant;
    }

    private String sortingVariant;
}
