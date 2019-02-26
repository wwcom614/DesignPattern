package com.ww.design_pattern.principle.dependencyreverse;

import lombok.extern.java.Log;

@Log
public class ItemMouse implements IBuyItem {
    @Override
    public void buyItem() {
        log.info("Buy a mouse!");
    }
}
