package a22_�����ͺ��̽�.dto;

import a22_�����ͺ��̽�.domain.user.User;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SigninDto {
	private String username;
	private String password;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.build();
	}

	
}
