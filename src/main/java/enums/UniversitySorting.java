package enums;

public enum UniversitySorting {
    ID("ПО ID"),
    FULLNAME("ПО ПОЛНОМУ ИМЕНИ"),
    SHORTNAME("ПО КОРОТКОМУ ИМЕНИ"),
    YEAROFFOUNDATION("ПО ГОДУ ОСНОВАНИЯ"),
    PROFILE("ПО ОСНОВНОМУ ПРОФИЛЮ");

    private String sortingVariant;

    public String getSortingVariant() {
        return sortingVariant;
    }

    UniversitySorting(String sortingVariant) {
        this.sortingVariant = sortingVariant;
    }
}
