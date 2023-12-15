package menu.domain;

import menu.domain.enums.Category;
import menu.domain.enums.Day;

public class MenuRecommend {
    private final Day day;
    private final Category category;
    private final String dish;

    public MenuRecommend(Day day, Category category, String dish) {
        this.day = day;
        this.category = category;
        this.dish = dish;
    }

    public Day getDay() {
        return day;
    }

    public Category getCategory() {
        return category;
    }

    public String getDish() {
        return dish;
    }
}
