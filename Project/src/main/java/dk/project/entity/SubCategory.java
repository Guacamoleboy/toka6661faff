package dk.project.entity;

public class SubCategory {

    // Attributes
    private int id;
    private int categoryId;
    private String name;
    private String description;

    // ___________________________________________________________

    public SubCategory(){}

    // ___________________________________________________________

    public SubCategory(int id, int categoryId, String name, String description){
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    // ___________________________________________________________

    public SubCategory(int categoryId, String name, String description){
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    // ___________________________________________________________

    public String getName() {
        return name;
    }

    // ___________________________________________________________

    public void setName(String name) {
        this.name = name;
    }

    // ___________________________________________________________

    public int getId() {
        return id;
    }

    // ___________________________________________________________

    public void setId(int id) {
        this.id = id;
    }

    // ___________________________________________________________

    public int getCategoryId() {
        return categoryId;
    }

    // ___________________________________________________________

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    // ___________________________________________________________

    public String getDescription() {
        return description;
    }

    // ___________________________________________________________

    public void setDescription(String description) {
        this.description = description;
    }

}