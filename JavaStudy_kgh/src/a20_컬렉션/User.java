package a20_�÷���;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor //��ü ������
@NoArgsConstructor  //�⺻ ������
@Data
public class User {
	private String Username;
	private String password;
	private String name;
	private String email;

}
