package dk.project.entity;

public class BadgeDefinition {

    // Attributes
    private int id;
    private String code;
    private String label;

    // ______________________________________________
    // Unit Test

    public BadgeDefinition(){}

    // ______________________________________________

    public BadgeDefinition(int id, String code, String label){
        this.id = id;
        this.code = code;
        this.label = label;
    }

    // ______________________________________________
    // Mapper

    public BadgeDefinition(String code, String label){
        this.id = id;
        this.code = code;
        this.label = label;
    }

    // ______________________________________________

    public String getCode() {
        return code;
    }

    // ______________________________________________

    public void setCode(String code) {
        this.code = code;
    }

    // ______________________________________________

    public int getId() {
        return id;
    }

    // ______________________________________________

    public void setId(int id) {
        this.id = id;
    }

    // ______________________________________________

    public String getLabel() {
        return label;
    }

    // ______________________________________________

    public void setLabel(String label) {
        this.label = label;
    }

}