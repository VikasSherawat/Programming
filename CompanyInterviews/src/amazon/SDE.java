package amazon;
import java.util.*;
public class SDE {
public static void main(String[] args) {
	
}

/*
 * import java.util.*;
 * import java.io.*;
 */
 public List<String> getDirectFriendsForUser(String user){
	 return null;
 }
 
 public List<String> getAttendedCoursesForUser(String user){
	 return null;
 }
 

public List<String> getRankedCourses(String user) {
	
	
	Map<String,Integer> courseCount = new TreeMap<String, Integer>();
	//used to check if the current  user if already counted
	Map<String,Boolean> userChecked = new TreeMap<String, Boolean>();

	List<String> courseListMain = getAttendedCoursesForUser(user);
	//get direct friends
	Queue<String> friendQueue = new ArrayDeque<String>();
	userChecked.put(user, true);
		List<String> directFriends = getDirectFriendsForUser(user);
		for (Iterator iterator = directFriends.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			friendQueue.add(string);
			
		}
		while(friendQueue.size()>0){
			String directFriend = friendQueue.remove();
			userChecked.put(directFriend, true);
			List<String> courseList = getAttendedCoursesForUser(directFriend);
			//adding the course attended by direct user
			for(String courseAdd: courseList){
				if(!courseListMain.contains(courseAdd)){	
					if(courseCount.containsKey(courseAdd)){
						courseCount.put(courseAdd, courseCount.get(courseAdd)+1);
					}else{
						courseCount.put(courseAdd, 1);
					}
				}
			}
			courseList.clear();
			directFriends = getDirectFriendsForUser(directFriend);
			for(String str: directFriends){
				
				if(!userChecked.containsKey(str)){
					userChecked.put(str, true);
			
				courseList = getAttendedCoursesForUser(str);
				//adding the course attended by direct user
				for(String courseAdd: courseList){
					if(!courseListMain.contains(courseAdd)){	
						if(courseCount.containsKey(courseAdd)){
							courseCount.put(courseAdd, courseCount.get(courseAdd)+1);
						}else{
							courseCount.put(courseAdd, 1);
						}
					}
				}

			}
		}
	}//while loop ends here
	
	Map<Integer,String> courseSort = new TreeMap<Integer, String>();
		
		for(Map.Entry<String, Integer> map: courseCount.entrySet()){
		courseSort.put(map.getValue(), map.getKey());
	}
		
	List<String> result = new ArrayList<String>();
	for(Map.Entry<Integer, String> map: courseSort.entrySet()){
		result.add(map.getValue());
	}
	Collections.reverse(result);
	return result;
}
}
