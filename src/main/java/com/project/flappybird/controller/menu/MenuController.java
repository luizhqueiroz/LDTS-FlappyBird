package com.project.flappybird.controller.menu;

import com.project.flappybird.controller.Controller;
import com.project.flappybird.model.menu.Menu;


public abstract class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

}
