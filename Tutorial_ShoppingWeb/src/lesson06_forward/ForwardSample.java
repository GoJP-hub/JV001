package lesson06_forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Java入門 フォワードクラス.
 */
@WebServlet("/lesson06_forward/ForwardSample")
public class ForwardSample extends HttpServlet {
	/**
	 * 【画面転送の基礎】
	 * 一画面から違う画面に転送する際に、フォワードとリダイレクトの手法がある
	 * ・フォワード：サーバ側で次に表示するページを作成・表示を行う
	 * ・リダイレクト：サーバがクライアントに、画面移動の指示を裏側で行う
	 * 　　※この特性のため、リダイレクトは別ウェブサイトへの遷移などに利用される
	 *
	 * 【サンプルコード】
	 * フォワード：
	 *    ServletContext con = request.getServletContext();
	 *    RequestDispatcher rd = con.getRequestDispatcher("/lesson06_Forward/redirect.jsp");
	 *    rd.foward(request, response);
	 *    // 恐らく、事前にリンク先をインスタンスに保持し、request/responseの際に、インスタンスを利用しているのでは
	 * リダイレクト：
	 *    response.sendRedirect("./lesson06_Forward/redirect.jsp")
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ.
	 */
    public ForwardSample() {
        super();
    }

    /**
     * GETメソッドでリクエストされた場合の処理.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// このWebアプリケーションの設定を取得
		ServletContext con = request.getServletContext();
		// このWebアプリケーション内にあるページ（移動先のページ）を決定
		RequestDispatcher rd= con.getRequestDispatcher("/Lesson06_Forward/redirect.jsp");
		// 移動先のページに移動
		rd.forward(request, response);
	}
}