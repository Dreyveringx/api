package com.app.api.domain;

public class Category {
    private int categoryId;
    private String category;
    private Boolean Active;

    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Boolean getActive() {
        return Active;
    }
    public void setActive(Boolean active) {
        Active = active;
    }  
}
