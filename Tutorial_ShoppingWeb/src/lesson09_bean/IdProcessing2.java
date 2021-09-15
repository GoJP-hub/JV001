package lesson09_bean;

/**
 * Java入門 ID処理クラス.
 */
public class IdProcessing2 {

	/**
	 * 指定されたIDに紐づくユーザ情報を返却します.
	 * @param id ID
	 * @return ユーザ情報
	 */
	public SampleUserBean getUserData(String id) {

		SampleUserBean bean = new SampleUserBean();

		// 引数のIDを判定
		if("web01".equals(id)) {

			// IDがweb01の場合
			// BeanにIDを設定
			bean.setId(id);
			// Beanに名前を設定
			bean.setName("すく太郎");
			// Beanに年齢を設定
			bean.setAge(17);
			// 管理者権限を設定
			bean.setAuth(1);

		} else if ("web02".equals(id)) {

			// IDがweb02の場合
			// BeanにIDを設定
			bean.setId(id);
			// Beanに名前を設定
			bean.setName("すく次郎");
			// Beanに年齢を設定
			bean.setAge(10);
			// 一般権限を設定
			bean.setAuth(0);

		} else {

			// IDが合致しない場合はnullを代入
			bean = null;
		}

		return bean;
	}
}