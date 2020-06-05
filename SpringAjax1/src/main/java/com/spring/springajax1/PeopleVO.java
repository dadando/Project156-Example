package com.spring.springajax1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@ToString, @EqualAndHashCode, @Getter,@Setter, @RequiredArgsConstructor ������̼� ��밡��
//=> @Data�� ��� ���ԵǾ� ����
//@RequiredArgsConstrucotr : final�̳� @NonNull�� �ʵ� ���� �Ķ���ͷ� �޴� �����ڸ� ����.
//lombok�� �����ϴ� ������̼�
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
