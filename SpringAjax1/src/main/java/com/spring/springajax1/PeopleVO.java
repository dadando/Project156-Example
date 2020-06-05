package com.spring.springajax1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@ToString, @EqualAndHashCode, @Getter,@Setter, @RequiredArgsConstructor 어노테이션 사용가능
//=> @Data에 모두 포함되어 있음
//@RequiredArgsConstrucotr : final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만듬.
//lombok이 제공하는 어노테이션
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleVO {
	private String id;
	private String name;
	private String job;
	private String address;
	private String bloodtype;
}
