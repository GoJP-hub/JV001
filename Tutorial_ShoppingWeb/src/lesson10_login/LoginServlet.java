package lesson10_login;

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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

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
			Login login = new Login();

			// ③-1-4 ID処理クラスに②-1-1で取得したIDを渡してユーザ情報をモデルに格納
			LoginUserBean bean = login.getUserData(id, pass);

			// ③-2 モデルの情報を判定
			if(bean != null) {

				// ③-2-1 モデルの情報が存在する場合はsetAttributeメソッドを使ってセッションに情報をセット
				// モデル（ユーザ情報）
				session.setAttribute("user_lesson10", bean);
				// ログイン状態
				session.setAttribute("login", "currently_loggedin");
				// セッション有効時間（3分）
				session.setMaxInactiveInterval(180);
				// ③-2-2 つぎに表示させる画面（ビュー）を指定
				// TODO:④loginOK画面への移動設定を行う
				rd = request.getRequestDispatcher("./Lesson10_Login/loginOK.jsp");

			} else {

				// ③-3 モデルの情報が存在しない（IDに紐づくユーザ情報がない）場合
				// ③-3-1 つぎに表示させる画面（ビュー）を指定
				// TODO:⑤loginNG画面への移動設定を行う
				rd = request.getRequestDispatcher("./Lesson10_Login/loginNG.jsp");
			}

			// TODO:⑥forward処理を行う
			rd.forward(request, response);

		} else {

			// ④ クリックされたボタンが「ログアウト」の場合はログアウト処理（セッションの破棄）を実施
			session.removeAttribute("login");
			session.removeAttribute("user_lesson10");

			// TODO:⑦login画面への移動設定を行う（redirect）
			response.sendRedirect("./Lesson10_Login/login.jsp");

		}
	}
}