package model;

enum Currency{
    EUR("Euro", "978"),
    GBP("Great Britain Codes", "826" ),
    USD("United State Dollars", "876"),
    NZD("New Zealand Dolars", "345");

    private String name;
    private String numericCode;

    Currency(String name, String numericCode) {
        this.name = name;
        this.numericCode = numericCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }
}
