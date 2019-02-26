package com.ww.design_pattern.pattern.structural.composite;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompositeTest {

    @Test
    public void testComposite() throws Exception {
        CatalogComponent hatItem = new ItemLeaf("hatItem", 22.5);
        CatalogComponent shirtItem = new ItemLeaf("shirtItem", 50.6);
        CatalogComponent trousersItem = new ItemLeaf("trousersItem", 88.8);

        CatalogComponent clothesCatalog = new CatalogComposite("clothesCatolog",2);
        clothesCatalog.add(hatItem);
        clothesCatalog.add(shirtItem);
        clothesCatalog.add(trousersItem);

        CatalogComponent sugarItem = new ItemLeaf("sugarItem", 6.6);
        CatalogComponent appleItem = new ItemLeaf("appleItem", 7.7);
        CatalogComponent meatItem = new ItemLeaf("meatItem", 18.9);

        CatalogComponent foodCatalog = new CatalogComposite("foodCatolog",2);
        foodCatalog.add(sugarItem);
        foodCatalog.add(appleItem);
        foodCatalog.add(meatItem);

        CatalogComponent mainCatalog = new CatalogComposite("mainCatalog",1);
        mainCatalog.add(clothesCatalog);
        mainCatalog.add(foodCatalog);
        mainCatalog.print();
    }

}