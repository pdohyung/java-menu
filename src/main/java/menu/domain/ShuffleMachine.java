package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.enums.Category;
import menu.domain.enums.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShuffleMachine {
    public ShuffleMachine() {
        List<String> shuffleMenus = new ArrayList<>();
    }

    public String getShuffleMenu() {
        return shuffle().get(0);
    }

    private List<String> shuffle() {
        Category category = getCategory(Randoms.pickNumberInRange(1, 5));
        List<String> menus = Arrays.stream(Menu.values())
                .filter(menu -> menu.getCategory() == category)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getDishes();
        return Randoms.shuffle(menus);
    }

    private Category getCategory(int randomNumber) {
        return Arrays.stream(Category.values())
                .filter(category -> category.getValue() == randomNumber)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
