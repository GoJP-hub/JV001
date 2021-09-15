package lesson08_scope;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Java入門 スコープセットクラス.<br>
 */
@WebServlet("/lesson08_scope/ScopeSetServlet")
public class ScopeSetServlet extends HttpServlet {

	/**
	 * スコープとは、データを見ることが出来る範囲が違う
	 * ・リクエスト：レスポンスと同時にデータが消去される
	 *      ※データを次の（クライアント側）画面で利用する場合は、Forwardを利用する必要がある
	 * ・セッション：サーバがリクエストをトリガーに作成するデータの置き場。。。タイムリミット式
	 *      ※基本的に、Apacheのセッションは30分
	 *      ※同一ブラウザの中で継続する
	 * ・アプリケーション：アプリが起動する限り利用できる
	 */
	private static final long serialVersionUID = 1L;

	public ScopeSetServlet() {
		super();
	}

	/**
	 * POSTメソッドでリクエストされた場合の処理.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 各スコープからアクセス回数を取得
		// リクエストスコープからアクセス回数を取得し、String型に変換
		String aRequest = (String) request.getAttribute("access_request");

		// セッションスコープを取得
		// セッション情報の文字化け対策
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// セッションスコープからアクセス回数を取得し、String型に変換
		String aSession = (String) session.getAttribute("access_session");

		// アプリケーションスコープを取得
		ServletContext con = request.getServletContext();

		// アプリケーションスコープ（サーブレットコンテキスト）からアクセス回数を取得し、String型に変換
		String aApplication = (String) con.getAttribute("access_application");

		int accessRequest = 1; // リクエストスコープ用アクセス回数カウンタ
		int accessSession = 1; // セッションスコープ用アクセス回数カウンタ
		int accessApplication = 1; // アプリケーションスコープ用アクセス回数カウンタ

		// 各スコープのアクセス回数をint型に変換
		accessRequest = countScope(aRequest, accessRequest);
		accessSession = countScope(aSession, accessSession);
		accessApplication = countScope((String) aApplication, accessApplication);

		// 画面移動（フォワード）の準備
		// セッションにユーザ名を格納
		String nSession = request.getParameter("name_request");
		session.setAttribute("name_session", nSession);

		// 各スコープにカウンタを格納
		request.setAttribute("access_request", Integer.toString(accessRequest));
		session.setAttribute("access_session", Integer.toString(accessSession));
		con.setAttribute("access_application", Integer.toString(accessApplication));

		// 画面移動
		RequestDispatcher rd = con.getRequestDispatcher("/Lesson08_Scope/scopeResult.jsp");
		rd.forward(request, response);
	}

	private int countScope(String scope, int counter) {
		if (scope != null) {
			counter = Integer.parseInt(scope);
			counter++;
		}
		return counter;
	}
}