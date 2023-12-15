package menu.repository;

import menu.domain.Coach;
import menu.domain.MenuRecommend;
import menu.domain.ShuffleMachine;
import menu.domain.enums.Category;
import menu.domain.enums.Day;
import menu.domain.enums.Menu;

import java.util.*;

public class MenuRecommendRepository {
    private final Map<Coach, List<MenuRecommend>> menuRecommendResult;

    public MenuRecommendRepository() {
        this.menuRecommendResult = new LinkedHashMap<>();
    }

    public Map<Coach, List<MenuRecommend>> getMenuRecommendResult() {
        return menuRecommendResult;
    }

    public void createRecommend(Day day, Coach coach) {
        MenuRecommend menuRecommend = generateValidMenuRecommend(day, coach);
        List<MenuRecommend> menuRecommends = menuRecommendResult.getOrDefault(coach, new ArrayList<>());
        menuRecommends.add(menuRecommend);
        menuRecommendResult.put(coach, menuRecommends);
    }

    private MenuRecommend generateValidMenuRecommend(Day day, Coach coach) {
        ShuffleMachine shuffleMachine = new ShuffleMachine();
        String shuffleMenu;
        Category category;
        do {
            shuffleMenu = shuffleMachine.getShuffleMenu();
            category = getCategory(shuffleMenu);
        } while (isInvalidMenu(coach, shuffleMenu, category));

        return new MenuRecommend(day, category, shuffleMenu);
    }

    private boolean isInvalidMenu(Coach coach, String menu, Category category) {
        return isExistMenuRecommend(coach) &&
                (isCanNotEat(coach, menu) || isMoreThanTwo(coach, category) || isDuplicateMenu(coach, menu));
    }

    private boolean isCanNotEat(Coach coach, String menu) {
        return coach.getCanNotEatMenus().contains(menu);
    }

    private boolean isExistMenuRecommend(Coach coach) {
        List<MenuRecommend> recommends = menuRecommendResult.getOrDefault(coach, Collections.emptyList());
        return !recommends.isEmpty();
    }


    private boolean isDuplicateMenu(Coach coach, String menu) {
        List<MenuRecommend> menuRecommends = menuRecommendResult.get(coach);
        return menuRecommends.stream()
                .anyMatch(menuRecommend -> menuRecommend.getDish().equals(menu));
    }

    private boolean isMoreThanTwo(Coach coach, Category category) {
        List<MenuRecommend> menuRecommends = menuRecommendResult.get(coach);
        long count = menuRecommends.stream()
                .filter(menuRecommend -> menuRecommend.getCategory().equals(category))
                .count();
        return count > 2;
    }

    private Category getCategory(String menu) {
        return Arrays.stream(Menu.values())
                .filter(m -> m.getDishes().contains(menu))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getCategory();
    }
}
