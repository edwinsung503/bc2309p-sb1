package service.impl;

import org.springframework.stereotype.Service;
import model.Database;
import service.DatabaseService;

@Service
public class DatabaseServiceimpl implements DatabaseService {

  @Override
  public String getName(int index) {
    return Database.getString(index);
  }

  @Override
  public void setName(int index, String name){
     Database.setString(index, name);
  }
}
  