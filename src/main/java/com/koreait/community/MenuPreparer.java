package com.koreait.community;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MenuPreparer")
public class MenuPreparer implements ViewPreparer {

    @Autowired
    private CommonMapper mapper;

    @Override
    public void execute(Request request, AttributeContext attributeContext) {
        System.out.println("--------------Called MenuPreparer-execute method--------------");
        attributeContext.putAttribute(Const.MENU_LIST,
                new Attribute(mapper.selMenuCategoryList()), true);
    }
}
