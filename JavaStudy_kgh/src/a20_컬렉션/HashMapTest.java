package a20_�÷���;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//put�� add
//set�� ���� iterator

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, User> userMap = new HashMap<String, User>(); //String���� key��, User�� ��ü
		
		userMap.put("junill",new User("junil","1234","������","skjil1218@gmail.com"));
		userMap.put("junil2",new User("junil","1234","������","skjil1218@gmail.com"));
		userMap.put("junil3",new User("junil","1234","������","skjil1218@gmail.com"));
		userMap.put("junil4",new User("junil","1234","������","skjil1218@gmail.com"));
		userMap.put("junil5",new User("junil","1234","������","skjil1218@gmail.com"));
		userMap.put("junil1",new User("junil2","4321","������2","skjil1218@gmail.com"));//�߰��ɶ� ���� ��ü��
		userMap.replace("junil5",new User("junil3","12345644","������","skjil1218@gmail.com"));//�����ɶ� ���� ��ü��
		
		String username = "junil2";
				
		Set<String> keySet = userMap.keySet();//key���� set���·� �ٲ���
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
