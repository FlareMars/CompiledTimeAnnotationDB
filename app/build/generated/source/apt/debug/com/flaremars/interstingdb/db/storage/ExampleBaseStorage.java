package com.flaremars.interstingdb.db.storage;

import android.content.ContentValues;
import java.util.List;
import org.litepal.crud.DataSupport;

public class ExampleBaseStorage {
  private static ExampleBaseStorage instance;

  private ExampleBaseStorage() {
  }

  public static ExampleBaseStorage getInstance() {
    if (instance == null) {
      synchronized(ExampleBaseStorage.class) {
        if (instance == null) {
          instance = new ExampleBaseStorage();
        }
      }
    }
    return instance;
  }

  public boolean save(com.flaremars.interstingdb.db.Example example) {
    if (example.getName() == null) {
      return false;
    }
    if (example.getDescription() == null) {
      return false;
    }
    return example.save();
  }

  public boolean update(com.flaremars.interstingdb.db.Example example) {
    ContentValues cv = new ContentValues();
    cv.put("number", example.getNumber());
    cv.put("name", example.getName());
    return DataSupport.update(com.flaremars.interstingdb.db.Example.class, cv, example.getId()) > 0;
  }

  public boolean saveOrUpdate(com.flaremars.interstingdb.db.Example example) {
    if (example.getId() != null && example.getId() != 0L) {
      return update(example);
    }
    return save(example);
  }

  public boolean delete(com.flaremars.interstingdb.db.Example example) {
    if (example.getId() == null || example.getId() == 0L) {
      return false;
    }
    return delete(example.getId());
  }

  public boolean delete(long id) {
    return DataSupport.delete(com.flaremars.interstingdb.db.Example.class, id) > 0;
  }

  public com.flaremars.interstingdb.db.Example findByName(java.lang.String name) {
    if (name == null) {
      return null;
    }
    List<com.flaremars.interstingdb.db.Example> temp = DataSupport.where("name == ?", name).find(com.flaremars.interstingdb.db.Example.class);
    if (temp.size() > 0) {
      return temp.get(0);
    }
    return null;
  }

  public com.flaremars.interstingdb.db.Example findById(java.lang.Long id) {
    return DataSupport.find(com.flaremars.interstingdb.db.Example.class, id);
  }
}
