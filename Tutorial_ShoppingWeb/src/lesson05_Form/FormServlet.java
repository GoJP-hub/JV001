package lesson05_Form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Java入門 Formデータ連携クラス
 */
@WebServlet("/lesson05_Form/FormServlet")
public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ.
	 */
    public FormServlet() {
        super();
    }

    /**
     * GETメソッドでリクエストされた場合の処理.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("GETメソッドで呼び出されました");

		String text1 = "";	// テキスト1格納用変数
		String text2 = "";	// テキスト2格納用変数

		// JSPの画面から値を取得
		text1 = request.getParameter("text1");
		text2 = request.getParameter("text2");

		// 取得した値をコンソールに出力
		System.out.println(text1);
		System.out.println(text2);
	}

	/**
	 * POSTメソッドで呼び出された場合の処理.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("POSTメソッドで呼び出されました");

		String text1 = "";	// テキスト1格納用変数
		String text2 = "";	// テキスト2格納用変数

		// JSPの画面から値を取得
		text1 = request.getParameter("text1");
		text2 = request.getParameter("text2");

		// 取得した値をコンソールに出力
		System.out.println(text1);
		System.out.println(text2);
	}
}