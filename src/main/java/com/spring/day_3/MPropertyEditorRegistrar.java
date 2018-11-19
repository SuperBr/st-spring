package com.spring.day_3;

import com.spring.day_3.bean.BeanA;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.PropertyValuesEditor;

import java.beans.PropertyEditorSupport;

/**
 * @author wangyongchao
 * @date 2018/11/13  20:00
 */
public class MPropertyEditorRegistrar implements PropertyEditorRegistrar {
    public void registerCustomEditors(final PropertyEditorRegistry registry) {
        registry.registerCustomEditor(BeanA.class, new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                this.setValue(new BeanA().setName(text));
            }
        });
    }
}
