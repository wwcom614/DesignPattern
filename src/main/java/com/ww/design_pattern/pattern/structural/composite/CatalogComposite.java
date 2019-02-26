package com.ww.design_pattern.pattern.structural.composite;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
//商品归属的类目Catalog是该组合模式的Composite(容器构件)，
//其内部可以add父类CatalogComponent--这样可以add商品Itemleaf，也可以add类目CatalogComposite
// --组合模式的核心实现
public class CatalogComposite extends CatalogComponent {
    private List<CatalogComponent> catalogComponents = new ArrayList<>();
    private String name;
    //目录层级标识
    private Integer level;


    public CatalogComposite(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    //类目支持增加商品
    @Override
    public void add(CatalogComponent catalogComponent) {
        catalogComponents.add(catalogComponent);
    }

    //类目支持删除商品
    @Override
    public void remove(CatalogComponent catalogComponent) {
        catalogComponents.remove(catalogComponent);
    }

    //可以获取类目名称
    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    //类目打印要打印自身的类目名称，以及该类目下的类目名称和商品信息
    @Override
    public void print() {
        //首先打印类目名称
        log.info(this.name);
        for(CatalogComponent catalogComponent : catalogComponents){
            if(this.level != null){//商品的目录层次为null
                for(int  i = 0; i < this.level; i++){
                    log.info("--");
                }
            }
            catalogComponent.print();
        }
    }

}
