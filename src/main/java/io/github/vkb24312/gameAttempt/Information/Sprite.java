package io.github.vkb24312.gameAttempt.Information;

import java.awt.*;

public class Sprite {
    public Image icon;

    public Image[] spr_walk_up = new Image[4];
    public Image[] spr_walk_down = new Image[4];
    public Image[] spr_walk_right = new Image[4];
    public Image[] spr_walk_left = new Image[4];

    public Image spr_still_up;
    public Image spr_still_down;
    public Image spr_still_left;
    public Image spr_still_right;

    Sprite setAll(Image i){
        icon = i;
        spr_still_down = i;
        spr_still_left = i;
        spr_still_right = i;
        spr_still_up = i;

        for (int j = 0; j < 4; j++) {
            spr_walk_up[j] = i;
            spr_walk_down[j] = i;
            spr_walk_left[j] = i;
            spr_walk_right[j] = i;
        }
        return this;
    }


}
