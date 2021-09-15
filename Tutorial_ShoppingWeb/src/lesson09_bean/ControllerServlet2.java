package lesson09_bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Java入門 MVCモデルクラス.<br>
 * C（コントローラ）
 */
@WebServlet("/ControllerServlet2")
public class ControllerServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ.
	 */
    public ControllerServlet2() {
        super();
    }

    /**
     * POSTメソッドでリクエストされた場合の処理.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ①ID入力画面で入力されたIDを取得
		String id = request.getParameter("id");

		// ②IDに紐づくユーザ情報をモデルに格納するために指示
		// ②-1 ID処理クラスをインスタンス化
		IdProcessing2 ip = new IdProcessing2();
		// ②-2 ID処理クラスに①で取得したIDを渡してユーザ情報をモデルに格納
		SampleUserBean bean = ip.getUserData(id);

		// ③ビューに画面を表示させるための準備
		RequestDispatcher rd;

		// ③-1 モデルの情報を判定
		if(bean != null) {

			// ③-1-1 モデルの情報が存在する場合
			// ③-1-1-1 setAttributeメソッドを使ってモデルの情報をセット
			request.setAttribute("user", bean);
			// ③-1-1-2 つぎに表示させる画面（ビュー）を指定
			rd = request.getRequestDispatcher("./WEB-sample09/userResponse2.jsp");

		} else {

			// ③-1-2 モデルの情報が存在しない（IDに紐づくユーザ情報がない）場合
			// ③-1-2-1 つぎに表示させる画面（ビュー）を指定
			rd = request.getRequestDispatcher("./WEB-sample09/userError2.jsp");
		}

		// ③-2 つぎの画面を表示
		rd.forward(request, response);
	}
}