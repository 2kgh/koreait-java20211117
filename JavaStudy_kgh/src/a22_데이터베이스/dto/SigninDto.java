package a22_데이터베이스.dto;

import a22_데이터베이스.domain.user.User;

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
