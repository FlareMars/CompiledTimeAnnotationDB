package com.flaremars.interstingdb.db;


import android.content.ContentValues;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by FlareMars on 2016/10/21.
 */
public class ExampleBaseStorage1 {

    private static ExampleBaseStorage1 instance;

    private ExampleBaseStorage1() {

    }

    public static ExampleBaseStorage1 getIntance() {
        if (instance == null) {
            synchronized(ExampleBaseStorage1.class) {
                if (instance == null) {
                    instance = new ExampleBaseStorage1();
                }
            }
        }
        return instance;
    }

    public boolean save(Example example) {
        if (example.getName() == null) {
            return false;
        }
        if (example.getDescription() == null) {
            return false;
        }
        return example.save();
    }

    public boolean update(Example example) {
        ContentValues cv = new ContentValues();
        cv.put("name", example.getName());
        cv.put("number", example.getNumber());
        return DataSupport.update(Example.class, cv, example.getId()) > 0;
    }

    public boolean saveOrUpdate(Example example) {
        if (example.getId() != null && example.getId() != 0L) {
            return update(example);
        } else {
            return save(example);
        }
    }

    public boolean delete(Example example) {
        if (example.getId() == null && example.getId() == 0L) {
            return false;
        }
        return delete(example.getId());
    }

    public boolean delete(Long id) {
        return DataSupport.delete(Example.class, id) > 0;
    }

    public Example findById(Long id) {
        return DataSupport.find(Example.class, id);
    }

    public Example findByName(String name) {
        if (name == null) {
            return null;
        }
        List<Example> temp = DataSupport.where("name == ?", name).find(Example.class);
        if (temp.size() > 0) {
            return temp.get(0);
        }
        return null;
    }
}
