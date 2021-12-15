package a20_컬렉션;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//put이 add
//set을 통해 iterator

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, User> userMap = new HashMap<String, User>(); //String값이 key값, User가 객체
		
		userMap.put("junill",new User("junil","1234","김준일","skjil1218@gmail.com"));
		userMap.put("junil2",new User("junil","1234","김준일","skjil1218@gmail.com"));
		userMap.put("junil3",new User("junil","1234","김준일","skjil1218@gmail.com"));
		userMap.put("junil4",new User("junil","1234","김준일","skjil1218@gmail.com"));
		userMap.put("junil5",new User("junil","1234","김준일","skjil1218@gmail.com"));
		userMap.put("junil1",new User("junil2","4321","김준일2","skjil1218@gmail.com"));//추가될때 값이 대체됨
		userMap.replace("junil5",new User("junil3","12345644","김준일","skjil1218@gmail.com"));//수정될때 값이 대체됨
		
		String username = "junil2";
				
		Set<String> keySet = userMap.keySet();//key값을 set형태로 바꿔줌
		System.out.println(keySet);
		Iterator<String> ir = keySet.iterator();
		while(ir.hasNext()) {
			User user = userMap.get(ir.next());
			
			if(user.getUsername().equals(username)) {
				System.out.println(user);
			}
		}
		System.out.println(userMap);
		
		
	}

}
