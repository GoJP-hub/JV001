package lesson07_mvc;

/**
 * Java入門 ID処理クラス.
 */
public class IdProcessing {

	/**
	 * 指定されたIDに紐づくユーザ情報を返却します.
	 * @param id ID
	 * @return ユーザ情報
	 */
	public UserBean getUserData(String id) {

		UserBean bean = new UserBean();

		switch (id) {
		case "web01":
			bean = setUserData(id, "スク太郎", 17);
			break;
		case "web02":
			bean = setUserData(id, "スク次郎", 10);
			break;
		default:
			System.out.println("[ERROR]ID is not valid");
			bean = null;

		}

		//		// 引数のIDを判定
		//		if("web01".equals(id)) {
		//
		//			// IDがweb01の場合
		//			// BeanにIDを設定
		//			bean.setId(id);
		//			// Beanに名前を設定
		//			bean.setName("すく太郎");
		//			// Beanに年齢を設定
		//			bean.setAge(17);
		//
		//		} else if ("web02".equals(id)) {
		//
		//			// IDがweb02の場合
		//			// BeanにIDを設定
		//			bean.setId(id);
		//			// Beanに名前を設定
		//			bean.setName("すく次郎");
		//			// Beanに年齢を設定
		//			bean.setAge(10);
		//
		//		} else {
		//
		//			// IDが合致しない場合はnullを代入
		//			bean = null;
		//		}

		return bean;
	}

	private UserBean setUserData(String id, String name, int age) {
		UserBean bean = new UserBean();
		bean.setId(id);
		bean.setName(name);
		bean.setAge(age);
		return bean;

	}
}