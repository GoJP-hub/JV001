package lesson10_login;

/**
 * Java入門 ログイン処理クラス.
 */
public class Login {

	/**
	 * 指定されたIDとパスワードに紐づくユーザ情報を返却します.
	 * @param id	ID
	 * @param pass	パスワード
	 * @return ユーザ情報
	 */
	public LoginUserBean getUserData(String id, String pass) {

		// TODO:⑧Beanクラスを新規作成する
		LoginUserBean bean = new LoginUserBean();

		// 引数のIDとパスワードを判定
		// TODO:⑨判定処理を追加する（条件はIDとパスワードが一致している場合）
		if("web01".equals(id) && "HelloWorld".equals(pass)) {

			// IDがweb01の場合
			// BeanにIDを設定
			// TODO:⑪ID設定
			bean.setId(id);

			// Beanに名前を設定
			// TODO:⑫名前設定
			bean.setName("Mr Sample");

			// Beanに年齢を設定
			// TODO:⑬年齢設定
			bean.setAge(17);


		// TODO:⑩判定処理を追加する（条件はIDとパスワードが一致している場合）
		} else if ("web02".equals(id) && "HelloWorld".equals(pass)) {

			// IDがweb02の場合
			// BeanにIDを設定
			// TODO:⑭ID設定
			bean.setId(id);

			// Beanに名前を設定
			// TODO:⑮名前設定
			bean.setName("Mrs Sample");

			// Beanに年齢を設定
			// TODO:⑯年齢設定
			bean.setAge(15);

		} else {

			// IDが合致しない場合はnullを代入
			bean = null;
		}

		return bean;
	}
}