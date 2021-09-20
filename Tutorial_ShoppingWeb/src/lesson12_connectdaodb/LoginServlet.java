package lesson12_connectdaodb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Java入門 ログイン機能.
 */
@WebServlet("/LoginServletDB")
public class LoginServlet extends HttpServlet {
	/**
	 *   【振り返り】
	 *    ・DAO：DB処理用のクラス.... DB接続・実行・結果処理などを行う
	 *    ・Bean：プロパティ定義用クラス....オブジェクトごとに作成することが多く、プロパティ定義とgetter/setterを設定する
	 *
	 *   【基本設計】
	 *    ・クライアント側
	 *        どんな部品がある？
	 *        ・login：リクエスト側
	 *        ・loginNG/OK：リスポンス側
	 *
	 *        どんな流れで構成されている？
	 *        ・loginからサーバの処理をキックし、処理結果に基づき、対応するリスポンスの画面に遷移する
	 *
	 *    ・サーバー側
	 *        どんな部品がある？
	 *        ・LoginServlet：Controller...リクエストを受取り、内部処理をキックする。判定結果で、該当リスポンスを返す。
	 *        ・LoginDB:Model(内部処理)...Modelの実行処理を担う→①Beanのインスタンス化、②DAOの利用
	 *             ・Login：Model（内部処理）...DAOを利用しない簡素的な処理。オーバーライドしているため、影響はなし
	 *        ・LoginUserBean：Model（Bean）...Beanの役割を担う
	 *        ・LoginDao：Model（DAO）...DAOの役割（DB接続・SQL実行など）を担う→SQLの一部を引数で代入できるようにしている
	 *
	 *        どんな流れで構成されている？
	 *        ・「リクエスト」→Controller→Model（内部処理　※DAOとBeanを利用）→Controller→「リスポンス」
	 *    【補足説明】
	 *    ①セッションの利用について
	 *        ・セッションインスタンスを作成して、格納場所を用意する
	 *        ・インスタンスに、HashMapのように、KeyでObjectに保持出来る
	 *        用途例
	 *        ・ステータス（ログイン中であること）を、String値で保持しても良し
	 *        ・Beanのオブジェクトを保持しても良し→オーバーライドも可能
	 *    ②DB接続のデバック
	 *        ・基本的な構文には問題なし
	 *        ・セットアップ時に、EclipseのSQL実行・ビューから行うとサーバーサイドのMySQLに反映しない可能性あり
	 *        ・サーバー側で実行するか、Eclipse上での再接続による確認も必要かもしれない
	 *
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ.
	 */
    public LoginServlet() {
        super();
    }

    /**
     * POSTメソッドでリクエストされた場合の処理.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ① クリックされたボタンの判定
		// ①-1 ボタン名の文字化けを防ぐために文字コードを設定してから取得
		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("submit");

		// ② 画面移動の準備
		HttpSession session = request.getSession();	// セッション
		RequestDispatcher rd;						// 画面の情報

		if("ログイン".equals(btn)) {

			// ③-1 クリックされたボタンが「ログイン」の場合はログイン処理を実施
			// ③-1-1 ログイン画面で入力されたIDとパスワードを取得
			String id  = request.getParameter("id");
			String pass= request.getParameter("pass");

			// ③-1-2 ユーザ情報をモデルに格納するために指示
			// ③-1-3 ログイン処理クラスをインスタンス化
			LoginDB login = new LoginDB();

			// ③-1-4 ID処理クラスに②-1-1で取得したIDを渡してユーザ情報をモデルに格納
			LoginUserBean bean = login.getUserData(id, pass);

			// ③-2 モデルの情報を判定
			if(bean != null) {

				// ③-2-1 モデルの情報が存在する場合はsetAttributeメソッドを使ってセッションに情報をセット
				// モデル（ユーザ情報）
				session.setAttribute("user_db", bean);
				// ログイン状態
				session.setAttribute("login_db", "login");
				// セッション有効時間（3分）
				session.setMaxInactiveInterval(180);
				// ③-2-2 つぎに表示させる画面（ビュー）を指定
				rd = request.getRequestDispatcher("./Lesson12_ConnectDaoDB/loginOK.jsp");

			} else {

				// ③-3 モデルの情報が存在しない（IDに紐づくユーザ情報がない）場合
				// ③-3-1 つぎに表示させる画面（ビュー）を指定
				rd = request.getRequestDispatcher("./Lesson12_ConnectDaoDB/loginNG.jsp");
			}

			rd.forward(request, response);

		} else {

			// ④ クリックされたボタンが「ログアウト」の場合はログアウト処理（セッションの破棄）を実施
			session.removeAttribute("login_db");
			session.removeAttribute("user_db");
			response.sendRedirect("./Lesson12_ConnectDaoDB/login.jsp");
		}
	}
}