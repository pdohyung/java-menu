package menu.domain;

import menu.domain.enums.Category;
import menu.domain.enums.Days;

public class MenuRecommend {
    private final Days day;
    private final Category category;
    private final String dish;

    public MenuRecommend(Days day, Category category, String dish) {
        this.day = day;
        this.category = category;
        this.dish = dish;
    }

    public Days getDay() {
        return day;
    }

    public Category getCategory() {
        return category;
    }

    public String getDish() {
        return dish;
    }
}
