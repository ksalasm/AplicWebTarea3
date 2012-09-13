package domain;

import java.util.*;

public class GroupRepository {
  private Map<String,Group> groups;

  GroupRepository() {
    groups = new HashMap<String,Group>();
  }
  public boolean insertGroup(Group group) {
    if (groups.containsKey(group.getId()))
      return false;
    else
      groups.put(group.getId()+"",group);
    return true;
  }
  public boolean deleteGroup(Group group) {
    if (!groups.containsKey(group.getId()+""))
      return false;
    else
      groups.remove(group.getId()+"");
    return true;
  }
  public Group findGroup(String id) {
    if (!groups.containsKey(id))
      return null;
    else
      return groups.get(id);
  }
  
  public boolean updateGroup(Group group) {
    if (!groups.containsKey(group.getId()+""))
      return false;
    else
      groups.put(group.getId()+"",group);
    return true;
  }
  public Collection findAllGroup() {
    return groups.values();
  } 
  
  public void setGroups(Map groups) {
    this.groups = groups;
  }
  
  public Collection findByProfesorID(String idProfesor) {  
	List groupList = new ArrayList();
	for(Iterator<String> iter = groups.keySet().iterator();iter.hasNext();) {
		String key = iter.next();
		Group group = (Group)groups.get(key);		
		if(group.getCedulaProfesor().equals(idProfesor)){
			groupList.add(group);		
		}
    }
	return groupList;
  } 
}