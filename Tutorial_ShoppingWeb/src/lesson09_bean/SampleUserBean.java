package lesson09_bean;

import java.io.Serializable;

public class SampleUserBean implements Serializable{
	/**
	 *JavaBeanは、プロパティを扱うクラス
	 *Beanクラスであるための原則
	 *   ・publicで引数無しのコンストラクタ
	 *   ・privateのメンバ変数定義（データのプロパティ）
	 *        ※メンバ変数＝クラスで定義されているもの。ローカル変数＝メソッド内で定義されているもの
	 *   ・メンバ変数へのアクセスメソッド
	 *   ・直列化（恐らくID作成用？）のためにSerializableインターフェイスの実装
	 *
	 *その他のルール
	 *   クラス名は、「●●●Bean」であること
	 *   serialVersionUIDであること
	 *   アクセスメソッドは、Getter/Setterであること
	 */
	// Serial Number
	private static final long serialVersionUID = 1L;

	// Data property
	private String id;
	private String name;
	private int age;
	private int auth;

	// Constructor: Initialize the property
	public SampleUserBean() {
		this.id = "";
		this.name = "";
		this.age = 0;
		this.auth = 0;
	}

	// Setter Getter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
}
